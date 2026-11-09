package br.com.perabru.appclima.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Instância única do Retrofit.
 */
object RetrofitClient {
    private fun criar(url: String): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /** Previsão do tempo */
    val api: OpenMeteoApi by lazy { criar(OpenMeteoApi.BASE_URL).create(OpenMeteoApi::class.java) }

    /** Geocoding (pesquisa de cidades) — subdomínio próprio */
    val geocoding: OpenMeteoApi by lazy { criar(OpenMeteoApi.GEOCODING_URL).create(OpenMeteoApi::class.java) }
}
