package br.com.perabru.appclima.util

/**
 * Códigos WMO traduzidos para português + emoji de ícone.
 */
object CodigosClima {
    data class Info(val descricao: String, val emoji: String)

    fun traduzir(code: Int): Info = when (code) {
        0 -> Info("Céu limpo", "☀️")
        1 -> Info("Predominantemente limpo", "🌤️")
        2 -> Info("Parcialmente nublado", "⛅")
        3 -> Info("Nublado", "☁️")
        45, 48 -> Info("Nevoeiro", "🌫️")
        51, 53, 55 -> Info("Garoa", "🌦️")
        56, 57 -> Info("Garoa congelante", "🌧️")
        61, 63, 65 -> Info("Chuva", "🌧️")
        66, 67 -> Info("Chuva congelante", "🌧️")
        71, 73, 75 -> Info("Neve", "❄️")
        77 -> Info("Grãos de neve", "🌨️")
        80, 81, 82 -> Info("Pancadas de chuva", "🌦️")
        85, 86 -> Info("Pancadas de neve", "🌨️")
        95 -> Info("Tempestade", "⛈️")
        96, 99 -> Info("Tempestade com granizo", "⛈️")
        else -> Info("Desconhecido", "🌡️")
    }
}
