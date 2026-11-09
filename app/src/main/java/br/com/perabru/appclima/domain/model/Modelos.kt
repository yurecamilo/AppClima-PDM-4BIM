package br.com.perabru.appclima.domain.model

/**
 * Modelos de domínio do aplicativo de clima.
 */
data class Cidade(
    val id: Long,
    val nome: String,
    val estado: String?,
    val pais: String?,
    val latitude: Double,
    val longitude: Double
) {
    val rotulo: String
        get() = listOfNotNull(nome, estado, pais).joinToString(", ")

    /** Nome curto para títulos (cidade, estado) — conforme design do OpenDesign */
    val rotuloCurto: String
        get() = listOfNotNull(nome, estado).joinToString(", ")
}

data class Clima(
    val temperaturaAtual: Double,
    val sensacaoTermica: Double,
    val umidade: Int,
    val ventoKmh: Double,
    val codigoClima: Int,
    val proximosDias: List<Dia>
)

data class Dia(
    val data: String, // ISO (ex.: 2026-11-05)
    val maxima: Double,
    val minima: Double,
    val codigoClima: Int
) {
    val rotuloDia: String
        get() {
            val hoje = java.time.LocalDate.now()
            return try {
                val d = java.time.LocalDate.parse(data)
                when {
                    d.isEqual(hoje) -> "Hoje"
                    d.isEqual(hoje.plusDays(1)) -> "Amanhã"
                    else -> d.dayOfWeek.getDisplayName(
                        java.time.format.TextStyle.SHORT, java.util.Locale("pt", "BR")
                    ).removeSuffix(".").replaceFirstChar { it.uppercase() }
                }
            } catch (e: Exception) {
                data
            }
        }

    val dataCurta: String
        get() = try {
            java.time.LocalDate.parse(data)
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM"))
        } catch (e: Exception) {
            data
        }
}
