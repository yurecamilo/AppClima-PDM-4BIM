package br.com.perabru.appclima.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.perabru.appclima.data.repository.ClimaRepository
import br.com.perabru.appclima.domain.model.Cidade
import br.com.perabru.appclima.domain.model.Clima
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Estados possíveis da consulta de clima (carregamento / sucesso / erro).
 */
sealed class EstadoClima {
    object Vazio : EstadoClima()
    object Carregando : EstadoClima()
    data class Pronto(val cidade: Cidade, val clima: Clima) : EstadoClima()
    data class Erro(val mensagem: String, val cidade: Cidade? = null) : EstadoClima()
}

data class UiClimaState(
    val favoritos: List<Cidade> = emptyList(),
    val resultadoBusca: List<Cidade> = emptyList(),
    val estado: EstadoClima = EstadoClima.Vazio
)

class ClimaViewModel(context: Context) : ViewModel() {

    private val repository = ClimaRepository(context)
    private val _ui = MutableStateFlow(UiClimaState())
    val ui = _ui.asStateFlow()

    init {
        atualizarFavoritos()
    }

    fun atualizarFavoritos() {
        viewModelScope.launch {
            _ui.value = _ui.value.copy(favoritos = repository.listarFavoritos())
        }
    }

    fun pesquisar(nome: String) {
        if (nome.isBlank()) return
        viewModelScope.launch {
            try {
                _ui.value = _ui.value.copy(resultadoBusca = repository.pesquisarCidades(nome))
            } catch (e: Exception) {
                _ui.value = _ui.value.copy(resultadoBusca = emptyList())
            }
        }
    }

    fun mostrarClima(cidade: Cidade) {
        viewModelScope.launch {
            _ui.value = _ui.value.copy(estado = EstadoClima.Carregando)
            try {
                _ui.value = _ui.value.copy(estado = EstadoClima.Pronto(cidade, repository.carregarClima(cidade)))
            } catch (e: Exception) {
                _ui.value = _ui.value.copy(
                    estado = EstadoClima.Erro(
                        "Falha ao consultar o clima. Verifique sua internet e tente novamente.",
                        cidade
                    )
                )
            }
        }
    }

    fun alternarFavorito(cidade: Cidade) {
        if (repository.ehFavorita(cidade)) repository.removerFavorito(cidade)
        else repository.adicionarFavorito(cidade)
        atualizarFavoritos()
    }
}
