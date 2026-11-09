package br.com.perabru.appclima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.perabru.appclima.ui.screens.TelaBusca
import br.com.perabru.appclima.ui.screens.TelaDetalhe
import br.com.perabru.appclima.ui.theme.AppClimaTheme
import br.com.perabru.appclima.viewmodel.ClimaViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ClimaViewModel(applicationContext)

        setContent {
            // Alternador de tema claro/escuro (switch do topo, conforme design)
            var modoEscuro by rememberSaveable { mutableStateOf(false) }

            // Status bar na cor surface + ícones legíveis conforme tema
            val janela = this.window
            androidx.compose.runtime.LaunchedEffect(modoEscuro) {
                androidx.core.view.WindowCompat.setDecorFitsSystemWindows(janela, false)
                janela.statusBarColor = 0 // transparente
                val controller = androidx.core.view.WindowCompat.getInsetsController(janela, janela.decorView)
                controller.isAppearanceLightStatusBars = !modoEscuro
            }

            AppClimaTheme(darkTheme = modoEscuro) {
                // Fundo acompanha o tema (surface)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "busca") {
                        composable("busca") {
                            TelaBusca(
                                estadoUi = viewModel.ui.collectAsState().value,
                                modoEscuro = modoEscuro,
                                aoAlternarTema = { modoEscuro = !modoEscuro },
                                aoPesquisar = viewModel::pesquisar,
                                aoAbrirCidade = { cidade ->
                                    viewModel.mostrarClima(cidade)
                                    navController.navigate("detalhe")
                                },
                                aoAlternarFavorito = viewModel::alternarFavorito
                            )
                        }
                        composable("detalhe") {
                            TelaDetalhe(
                                estado = viewModel.ui.collectAsState().value.estado,
                                favoritos = viewModel.ui.collectAsState().value.favoritos,
                                aoRecarregar = { cidade -> viewModel.mostrarClima(cidade) },
                                aoVoltar = { navController.popBackStack() },
                                aoAlternarFavorito = viewModel::alternarFavorito
                            )
                        }
                    }
                }
            }
        }
    }
}
