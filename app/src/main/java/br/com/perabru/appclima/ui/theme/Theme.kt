package br.com.perabru.appclima.ui.theme

import br.com.perabru.appclima.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ==============================================================================
// 1. PALETA DE CORES MATERIAL DESIGN 3 — MINIMALIST PRECISION
//    Estética Nórdica & Deep Obsidian (Limpeza visual, alto contraste WCAG AAA/AA)
// ==============================================================================

// Tema Claro (Light Color Scheme — Nordic Sky)
val PrimaryLight = Color(0xFF7E22CE)                 // Deep Precision Slate Azure
val OnPrimaryLight = Color(0xFFFFFFFF)
val PrimaryContainerLight = Color(0xFFF3E8FF)        // Soft Luminous Ice Blue
val OnPrimaryContainerLight = Color(0xFF3B0764)

val SecondaryLight = Color(0xFF705569)               // Refined Slate Gray
val OnSecondaryLight = Color(0xFFFFFFFF)
val SecondaryContainerLight = Color(0xFFF5ECF3)      // Subtle Neutral Pill Container
val OnSecondaryContainerLight = Color(0xFF19111E)

val TertiaryLight = Color(0xFFBE185D)                // Minimalist Sunlight Amber
val OnTertiaryLight = Color(0xFFFFFFFF)
val TertiaryContainerLight = Color(0xFFFEF3C7)
val OnTertiaryContainerLight = Color(0xFF451A03)

val ErrorLight = Color(0xFFDC2626)                   // Crisp Semantic Red
val OnErrorLight = Color(0xFFFFFFFF)
val ErrorContainerLight = Color(0xFFFEE2E2)
val OnErrorContainerLight = Color(0xFF450A0A)

val SurfaceLight = Color(0xFFFAF8FC)                 // Pure Ceramic Off-White Base
val OnSurfaceLight = Color(0xFF19111E)               // Obsidian High-Contrast Text
val SurfaceVariantLight = Color(0xFFE8E0EC)
val OnSurfaceVariantLight = Color(0xFF635B69)         // Editorial Secondary Text

// Superfícies em camadas (Surface Containers)
val SurfaceContainerLowestLight = Color(0xFFFFFFFF)
val SurfaceContainerLowLight = Color(0xFFF8FAFC)
val SurfaceContainerLight = Color(0xFFFFFFFF)        // Clean White Cards with Hairline Border
val SurfaceContainerHighLight = Color(0xFFF5ECF3)     // SearchBar M3 Container
val SurfaceContainerHighestLight = Color(0xFFE8E0EC)

val OutlineLight = Color(0xFF9A8E9F)
val OutlineVariantLight = Color(0xFFE8E0EC)           // Hairline Border Tint (0.5dp / 1dp)
val StarAmberLight = Color(0xFFF59E0B)               // Estrela de Favorito

// Tema Escuro (Dark Color Scheme — Deep Obsidian)
val PrimaryDark = Color(0xFFD8B4FE)                  // Luminous Sky Cyan
val OnPrimaryDark = Color(0xFF3B0764)
val PrimaryContainerDark = Color(0xFF581C87)         // Midnight Horizon Blue
val OnPrimaryContainerDark = Color(0xFFF3E8FF)

val SecondaryDark = Color(0xFFD4BDCE)
val OnSecondaryDark = Color(0xFF241320)
val SecondaryContainerDark = Color(0xFF1E293B)       // Muted Dark Slate Pill
val OnSecondaryContainerDark = Color(0xFFE8E0EC)

val TertiaryDark = Color(0xFFF472B6)
val OnTertiaryDark = Color(0xFF451A03)
val TertiaryContainerDark = Color(0xFF78350F)
val OnTertiaryContainerDark = Color(0xFFFEF3C7)

val ErrorDark = Color(0xFFF87171)
val OnErrorDark = Color(0xFF450A0A)
val ErrorContainerDark = Color(0xFF7F1D1D)
val OnErrorContainerDark = Color(0xFFFEE2E2)

val SurfaceDark = Color(0xFF0F0C14)                 // Deep OLED Obsidian Surface
val OnSurfaceDark = Color(0xFFF3EFF7)               // Crisp Pure White / Ice Text
val SurfaceVariantDark = Color(0xFF272030)
val OnSurfaceVariantDark = Color(0xFF9B91A3)

val SurfaceContainerLowestDark = Color(0xFF0A080E)
val SurfaceContainerLowDark = Color(0xFF15111B)
val SurfaceContainerDark = Color(0xFF1B1622)        // Modern Dark Card Surface
val SurfaceContainerHighDark = Color(0xFF272030)     // SearchBar Dark Container
val SurfaceContainerHighestDark = Color(0xFF352C40)

val OutlineDark = Color(0xFF776C80)
val OutlineVariantDark = Color(0xFF272030)          // Subtle Dark Hairline Border
val StarAmberDark = Color(0xFFF472B6)

// ==============================================================================
// 2. ESQUEMAS DE CORES MATERIAL DESIGN 3
// ==============================================================================

val AppClimaLightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = TertiaryLight,
    onTertiary = OnTertiaryLight,
    tertiaryContainer = TertiaryContainerLight,
    onTertiaryContainer = OnTertiaryContainerLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight
)

val AppClimaDarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    tertiary = TertiaryDark,
    onTertiary = OnTertiaryDark,
    tertiaryContainer = TertiaryContainerDark,
    onTertiaryContainer = OnTertiaryContainerDark,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = OutlineDark,
    outlineVariant = OutlineVariantDark
)

// ==============================================================================
// 3. TIPOGRAFIA DE ALTA TENDÊNCIA — PLUS JAKARTA SANS
//    Escala geométrica contemporânea para clareza e leitura editorial
// ==============================================================================

// Definição da família Plus Jakarta Sans (Google Fonts) — TTFs em res/font/
val PlusJakartaSans = FontFamily(
    Font(R.font.plusjakartasans_light, FontWeight.Light),
    Font(R.font.plusjakartasans_regular, FontWeight.Normal),
    Font(R.font.plusjakartasans_medium, FontWeight.Medium),
    Font(R.font.plusjakartasans_semibold, FontWeight.SemiBold),
    Font(R.font.plusjakartasans_bold, FontWeight.Bold)
)

val AppClimaTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Light,
        fontSize = 72.sp,
        lineHeight = 78.sp,
        letterSpacing = (-2.5).sp
    ),
    headlineMedium = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = (-0.5).sp
    ),
    headlineSmall = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.3).sp
    ),
    titleLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.2).sp
    ),
    titleMedium = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    titleSmall = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.15.sp
    ),
    bodySmall = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelSmall = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

// ==============================================================================
// 4. SHAPES (CANTOS ARREDONDADOS MD3 & HAIRLINE BORDERS)
// ==============================================================================

val AppClimaShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),      // Cards de Cidades
    extraLarge = RoundedCornerShape(18.dp)  // Carrossel 7 Dias & Card de Métricas
)

val FullCornerShape = CircleShape           // SearchBar M3 & Botões de Ação

// ==============================================================================
// 5. COMPOSABLES NATIVOS PRONTOS PARA O APP CLIMA
// ==============================================================================

/**
 * 1. SearchBar Nativa Material Design 3 (Pílula Fluida 28dp / 56dp altura)
 *    Estilo Minimalista com Hairline Border e Plus Jakarta Sans
 */
@Composable
fun AppClimaSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val containerBg = if (isDark) SurfaceContainerHighDark else SurfaceContainerHighLight
    val borderColor = if (isDark) Color.White.copy(alpha = 0.08f) else Color(0xFF19111E).copy(alpha = 0.08f)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = FullCornerShape,
        color = containerBg,
        border = BorderStroke(1.dp, borderColor),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Ícone de busca",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearch(query) }),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = "Pesquisar cidade...",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    innerTextField()
                }
            )

            if (query.isNotEmpty()) {
                IconButton(
                    onClick = onClear,
                    modifier = Modifier.size(34.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Limpar busca",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Button(
                onClick = { onSearch(query) },
                shape = FullCornerShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 0.dp),
                modifier = Modifier.height(40.dp)
            ) {
                Text(
                    text = "Buscar",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

/**
 * 2. Hero Climático Monumental Minimalista
 *    Temperatura em destaque Light (72sp), tipografia Plus Jakarta Sans e pílula discreta
 */
@Composable
fun WeatherHero(
    cityName: String,
    temperature: String,
    condition: String,
    hiLo: String,
    wmoCode: Int,
    modifier: Modifier = Modifier
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val borderColor = if (isDark) Color.White.copy(alpha = 0.08f) else Color(0xFF19111E).copy(alpha = 0.08f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Chip de localização discreto
        Surface(
            shape = FullCornerShape,
            color = if (isDark) SurfaceContainerHighDark else SurfaceContainerHighLight,
            border = BorderStroke(1.dp, borderColor)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(13.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "PREVISÃO WMO OFICIAL",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Nome da cidade
        Text(
            text = cityName,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Text(
            text = "ATUALIZADO AGORA · OPEN-METEO API",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Placeholder para ilustração vetorial WMO outline-duotone (120dp)
        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = br.com.perabru.appclima.util.WmoIcones.condicao(wmoCode),
                contentDescription = condition,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(64.dp)
            )
        }

        // Temperatura Monumental com peso Light
        Text(
            text = temperature,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Pílula Tonal de Condição
        Surface(
            shape = FullCornerShape,
            color = if (isDark) SurfaceContainerHighDark else SurfaceContainerHighLight,
            border = BorderStroke(1.dp, borderColor)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = condition,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "·",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = hiLo,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * 3. Card de Métricas Atmosféricas da Open-Meteo
 *    Grid de 3 colunas com divisores verticais sutis
 */
@Composable
fun WeatherMetricsGrid(
    feelsLike: String,
    humidity: String,
    windSpeed: String,
    subtitleFeels: String = "—",
    subtitleHumidity: String = "—",
    subtitleWind: String = "—",
    modifier: Modifier = Modifier
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val cardBg = if (isDark) SurfaceContainerDark else SurfaceContainerLight
    val borderColor = if (isDark) Color.White.copy(alpha = 0.08f) else Color(0xFF19111E).copy(alpha = 0.08f)
    val dividerColor = if (isDark) Color.White.copy(alpha = 0.06f) else Color(0xFF19111E).copy(alpha = 0.06f)

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = AppClimaShapes.extraLarge,
        color = cardBg,
        border = BorderStroke(1.dp, borderColor),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Sensação Térmica
            MetricColumn(
                label = "SENSAÇÃO",
                value = feelsLike,
                subtitle = subtitleFeels,
                icon = Icons.Default.Thermostat
            )

            // Divisor vertical
            Box(modifier = Modifier.width(1.dp).height(44.dp).background(dividerColor))

            // Umidade
            MetricColumn(
                label = "UMIDADE",
                value = humidity,
                subtitle = subtitleHumidity,
                icon = Icons.Default.WaterDrop
            )

            // Divisor vertical
            Box(modifier = Modifier.width(1.dp).height(44.dp).background(dividerColor))

            // Vento
            MetricColumn(
                label = "VENTO",
                value = windSpeed,
                subtitle = subtitleWind,
                icon = Icons.Default.Air
            )
        }
    }
}

@Composable
private fun MetricColumn(
    label: String,
    value: String,
    subtitle: String,
    icon: ImageVector
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp, fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

/**
 * 4. Previsão de 7 Dias — Carrossel Horizontal Compacto (LazyRow)
 */
data class ForecastDay(
    val day: String,
    val date: String,
    val condition: String,
    val wmo: Int,
    val max: String,
    val min: String,
    val rainProb: String
)

@Composable
fun ForecastHorizontalCarousel(
    forecastList: List<ForecastDay>,
    onDayClick: (ForecastDay) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Próximos 7 dias",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Deslize para ver →",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 4.dp, horizontal = 2.dp)
        ) {
            itemsIndexed(forecastList) { index, item ->
                ForecastMiniCard(
                    item = item,
                    isToday = index == 0,
                    onClick = { onDayClick(item) }
                )
            }
        }
    }
}

@Composable
fun ForecastMiniCard(
    item: ForecastDay,
    isToday: Boolean,
    onClick: () -> Unit
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val cardBg = if (isToday) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        if (isDark) SurfaceContainerDark else SurfaceContainerLight
    }
    val borderColor = if (isToday) {
        MaterialTheme.colorScheme.primary
    } else {
        if (isDark) Color.White.copy(alpha = 0.08f) else Color(0xFF19111E).copy(alpha = 0.08f)
    }

    Surface(
        modifier = Modifier
            .width(96.dp)
            .height(150.dp)
            .clickable(onClick = onClick),
        shape = AppClimaShapes.extraLarge,
        color = cardBg,
        border = BorderStroke(if (isToday) 1.5.dp else 1.dp, borderColor),
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = item.day,
                    style = MaterialTheme.typography.titleSmall,
                    color = if (isToday) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = br.com.perabru.appclima.util.WmoIcones.condicao(item.wmo),
                contentDescription = item.condition,
                tint = if (isToday) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(32.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = item.max,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = if (isToday) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = item.min,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

/**
 * 5. Card de Cidade (Pesquisa & Favoritos)
 */
@Composable
fun CityWeatherCard(
    cityName: String,
    condition: String,
    temperature: String,
    feelsLike: String,
    isFavorite: Boolean,
    onCardClick: () -> Unit,
    onFavToggle: () -> Unit,
    onDeleteClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val cardBg = if (isDark) SurfaceContainerDark else SurfaceContainerLight
    val borderColor = if (isDark) Color.White.copy(alpha = 0.08f) else Color(0xFF19111E).copy(alpha = 0.08f)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        shape = AppClimaShapes.large,
        color = cardBg,
        border = BorderStroke(1.dp, borderColor),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Cloud,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = cityName,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "$condition · Sensação $feelsLike",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = temperature,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.width(8.dp))

                if (onDeleteClick != null) {
                    IconButton(onClick = onDeleteClick, modifier = Modifier.size(36.dp)) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Remover favorito",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                } else {
                    IconButton(onClick = onFavToggle, modifier = Modifier.size(36.dp)) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Star else Icons.Outlined.Star,
                            contentDescription = "Favoritar",
                            tint = if (isFavorite) StarAmberLight else MaterialTheme.colorScheme.outline,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * 6. Tema Raiz do App Clima
 */
@Composable
fun AppClimaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) AppClimaDarkColorScheme else AppClimaLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppClimaTypography,
        shapes = AppClimaShapes,
        content = content
    )
}
