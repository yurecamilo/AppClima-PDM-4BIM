package br.com.perabru.appclima.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.perabru.appclima.domain.model.Cidade
import br.com.perabru.appclima.domain.model.Clima
import br.com.perabru.appclima.ui.theme.AppClimaSearchBar
import br.com.perabru.appclima.ui.theme.CityWeatherCard
import br.com.perabru.appclima.ui.theme.ForecastDay
import br.com.perabru.appclima.ui.theme.ForecastHorizontalCarousel
import br.com.perabru.appclima.ui.theme.WeatherHero
import br.com.perabru.appclima.ui.theme.WeatherMetricsGrid
import br.com.perabru.appclima.util.CodigosClima
import br.com.perabru.appclima.viewmodel.EstadoClima
import br.com.perabru.appclima.viewmodel.UiClimaState

/**
 * Tela de Busca (artboard 1–2): título + alternador de tema, SearchBar MD3,
 * resultados com badge de contagem e "Cidades Favoritas" com badge "X salvas".
 */
@Composable
fun TelaBusca(
    estadoUi: UiClimaState,
    modoEscuro: Boolean,
    aoAlternarTema: () -> Unit,
    aoPesquisar: (String) -> Unit,
    aoAbrirCidade: (Cidade) -> Unit,
    aoAlternarFavorito: (Cidade) -> Unit
) {
    var texto by remember { mutableStateOf("") }
    val ehFavorita: (Cidade) -> Boolean = { cidade -> estadoUi.favoritos.any { it.id == cidade.id } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        // Barra superior: logo + tema
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Cloud,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                "App Clima",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.weight(1f))
            IconButton(onClick = aoAlternarTema) {
                Icon(
                    imageVector = if (modoEscuro) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = "Alternar tema",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        Spacer(Modifier.height(12.dp))

        AppClimaSearchBar(
            query = texto,
            onQueryChange = { texto = it },
            onSearch = { aoPesquisar(texto) },
            onClear = { texto = "" }
        )
        Spacer(Modifier.height(16.dp))

        if (estadoUi.resultadoBusca.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Resultados da busca",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.weight(1f))
                Badge(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ) {
                    Text("${estadoUi.resultadoBusca.size} encontradas")
                }
            }
            Spacer(Modifier.height(8.dp))
            LazyColumn(modifier = Modifier.weight(1.5f)) {
                items(estadoUi.resultadoBusca, key = { "busca_${it.id}" }) { cidade ->
                    CityWeatherCard(
                        cityName = cidade.rotulo,
                        condition = "Toque para ver o clima",
                        temperature = "—",
                        feelsLike = "—",
                        isFavorite = ehFavorita(cidade),
                        onCardClick = { aoAbrirCidade(cidade) },
                        onFavToggle = { aoAlternarFavorito(cidade) },
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
        }

        // Cidades Favoritas + badge
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Cidades Favoritas",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.weight(1f))
            Badge(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Text("${estadoUi.favoritos.size} salvas")
            }
        }
        Spacer(Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(estadoUi.favoritos, key = { it.id }) { cidade ->
                CityWeatherCard(
                    cityName = cidade.rotulo,
                    condition = "Toque para ver o clima",
                    temperature = "—",
                    feelsLike = "—",
                    isFavorite = true,
                    onCardClick = { aoAbrirCidade(cidade) },
                    onFavToggle = { aoAlternarFavorito(cidade) },
                    onDeleteClick = { aoAlternarFavorito(cidade) },
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
            if (estadoUi.favoritos.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text("Nenhuma cidade favorita", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "Pesquise uma localidade acima na SearchBar e toque na estrela ⭐ para acompanhar a previsão em tempo real aqui.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

/**
 * Tela de Detalhe (artboard 3–4): voltar + estrela no topo, Hero, métricas carrossel.
 */
@Composable
fun TelaDetalhe(
    estado: EstadoClima,
    favoritos: List<Cidade>,
    aoRecarregar: (Cidade) -> Unit,
    aoVoltar: () -> Unit,
    aoAlternarFavorito: (Cidade) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        when (val e = estado) {
            is EstadoClima.Vazio -> {
                Text("Escolha uma cidade para ver o clima.")
            }
            is EstadoClima.Carregando -> EstadoCarregando()
            is EstadoClima.Erro -> EstadoErro(e, aoRecarregar, aoVoltar)
            is EstadoClima.Pronto -> DetalheClima(e.cidade, e.clima, favoritos, aoAlternarFavorito, aoVoltar)
        }
    }
}

// Artboard 5 — loading com skeleton
@Composable
private fun EstadoCarregando() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        CircularProgressIndicator()
        Spacer(Modifier.height(16.dp))
        Text("Consultando Open-Meteo...", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Text(
            "Carregando condições meteorológicas em tempo real",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(24.dp))
        Skeleton(shape = 18.dp, height = 120.dp)
        Spacer(Modifier.height(12.dp))
        Skeleton(shape = 18.dp, height = 72.dp)
        Spacer(Modifier.height(12.dp))
        Skeleton(shape = 18.dp, height = 150.dp)
    }
}

@Composable
private fun Skeleton(shape: androidx.compose.ui.unit.Dp, height: androidx.compose.ui.unit.Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(shape))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
    )
}

// Artboard 6 — erro com ícone circular e retry tonal
@Composable
private fun EstadoErro(e: EstadoClima.Erro, aoRecarregar: (Cidade) -> Unit, aoVoltar: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.errorContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Error,
                contentDescription = "Erro",
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(Modifier.height(12.dp))
        Text("Falha na atualização", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Text(
            "Não foi possível carregar os dados climáticos. Verifique sua conexão.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        FilledTonalButton(
            onClick = {
                val cidade = e.cidade
                if (cidade != null) aoRecarregar(cidade) else aoVoltar()
            }
        ) { Text("Tentar de novo") }
    }
}

@Composable
private fun DetalheClima(
    cidade: Cidade,
    clima: Clima,
    favoritos: List<Cidade>,
    aoAlternarFavorito: (Cidade) -> Unit,
    aoVoltar: () -> Unit
) {
    val info = CodigosClima.traduzir(clima.codigoClima)
    val hoje = clima.proximosDias.firstOrNull()
    val favorita = favoritos.any { it.id == cidade.id }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 4.dp)
    ) {
        // Topo: voltar (esq.) + estrela (dir.)
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = aoVoltar) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { aoAlternarFavorito(cidade) }) {
                Icon(
                    imageVector = if (favorita) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = "Favoritar",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
        Spacer(Modifier.height(4.dp))

        WeatherHero(
            cityName = cidade.rotuloCurto,
            temperature = "${clima.temperaturaAtual}°C".replace('.', ','),
            condition = info.descricao,
            hiLo = if (hoje != null) "Máx ${hoje.maxima}° / Mín ${hoje.minima}°" else "",
            wmoCode = clima.codigoClima
        )

        Spacer(Modifier.height(16.dp))

        WeatherMetricsGrid(
            feelsLike = "${clima.sensacaoTermica}°".replace('.', ','),
            humidity = "${clima.umidade}%",
            windSpeed = "${clima.ventoKmh} km/h".replace('.', ','),
            subtitleFeels = "Sensação térmica",
            subtitleHumidity = if (clima.umidade >= 70) "Elevada" else if (clima.umidade >= 40) "Normal" else "Baixa",
            subtitleWind = if (clima.ventoKmh < 12) "Brisa leve" else if (clima.ventoKmh < 28) "Brisa moderada" else "Vento forte"
        )

        Spacer(Modifier.height(16.dp))

        ForecastHorizontalCarousel(
            forecastList = clima.proximosDias.map { dia ->
                ForecastDay(
                    day = dia.rotuloDia,
                    date = dia.dataCurta,
                    condition = CodigosClima.traduzir(dia.codigoClima).descricao,
                    wmo = dia.codigoClima,
                    max = "${dia.maxima}°".replace('.', ','),
                    min = "${dia.minima}°".replace('.', ','),
                    rainProb = ""
                )
            },
            onDayClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
