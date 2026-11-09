package br.com.perabru.appclima.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Grain
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.filled.Umbrella
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny

/**
 * Códigos WMO -> ícones vetoriais (Material Icons), conforme design substituindo os emojis.
 */
object WmoIcones {
    fun condicao(code: Int) = when (code) {
        0 -> Icons.Default.WbSunny
        1, 2 -> Icons.Default.WbCloudy
        3 -> Icons.Default.Cloud
        45, 48 -> Icons.Default.BlurOn // Névoa
        51, 53, 55, 56, 57 -> Icons.Default.Grain // Garoa (drizzle)
        61, 63, 65, 66, 67 -> Icons.Default.Umbrella // Chuva
        71, 73, 75, 77 -> Icons.Default.AcUnit // Neve
        80, 81, 82, 85, 86 -> Icons.Default.Grain // Pancadas
        95, 96, 99 -> Icons.Default.Thunderstorm
        else -> Icons.Default.BlurOn
    }
}
