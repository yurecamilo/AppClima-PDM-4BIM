package br.com.perabru.appclima.data.repository

import android.content.Context
import android.content.SharedPreferences
import br.com.perabru.appclima.data.remote.RetrofitClient
import br.com.perabru.appclima.domain.model.Cidade
import br.com.perabru.appclima.domain.model.Clima
import br.com.perabru.appclima.domain.model.Dia

/**
 * Único ponto de acesso aos dados: rede (Open-Meteo) + favoritos locais.
 */
class ClimaRepository(context: Context) {

    private val api = RetrofitClient.api
    private val prefs: SharedPreferences =
        context.getSharedPreferences("favoritos", Context.MODE_PRIVATE)

    // ---------- Favoritos (persistência local) ----------

    suspend fun listarFavoritos(): List<Cidade> =
        prefs.all.values.mapNotNull { (it as? String)?.let(::cidadeDe) }
            .sortedBy { it.nome }

    fun adicionarFavorito(cidade: Cidade) {
        prefs.edit().putString("cidade_${cidade.id}", cidade.serializada()).apply()
    }

    fun removerFavorito(cidade: Cidade) {
        prefs.edit().remove("cidade_${cidade.id}").apply()
    }

    fun ehFavorita(cidade: Cidade): Boolean =
        prefs.contains("cidade_${cidade.id}")

    private fun cidadeDe(texto: String): Cidade? = runCatching {
        val p = texto.split("|")
        if (p.size < 6) return null
        Cidade(
            id = p[0].toLong(),
            nome = p[1],
            estado = p[2].ifEmpty { null },
            pais = p[3].ifEmpty { null },
            latitude = p[4].toDouble(),
            longitude = p[5].toDouble()
        )
    }.getOrNull()

    private fun Cidade.serializada(): String =
        "$id|$nome|${estado ?: ""}|${pais ?: ""}|$latitude|$longitude"

    // ---------- Rede ----------

    suspend fun pesquisarCidades(nome: String): List<Cidade> =
        RetrofitClient.geocoding.buscarCidade(nome).results?.map {
            Cidade(
                id = it.id,
                nome = it.name,
                estado = it.admin1,
                pais = it.country,
                latitude = it.latitude,
                longitude = it.longitude
            )
        } ?: emptyList()

    suspend fun carregarClima(cidade: Cidade): Clima {
        val resposta = api.buscarClima(cidade.latitude, cidade.longitude)
        val atual = resposta.current!!
        val diario = resposta.daily

        return Clima(
            temperaturaAtual = atual.temperature_2m,
            sensacaoTermica = atual.apparent_temperature,
            umidade = atual.relative_humidity_2m,
            ventoKmh = atual.wind_speed_10m,
            codigoClima = atual.weather_code,
            proximosDias = diario?.let {
                it.temperature_2m_max.mapIndexed { i, max ->
                    Dia(
                        data = it.time[i],
                        maxima = max,
                        minima = it.temperature_2m_min[i],
                        codigoClima = it.weather_code[i]
                    )
                }
            } ?: emptyList()
        )
    }
}
