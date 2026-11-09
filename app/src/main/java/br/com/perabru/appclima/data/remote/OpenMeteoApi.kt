package br.com.perabru.appclima.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * DTOs (formato JSON da Open-Meteo) e definição dos endpoints.
 */
data class GeocodingResposta(
    val results: List<LocalDTO>?
)

data class LocalDTO(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String?,
    val admin1: String?
)

data class WeatherResposta(
    val current: ClimaAtualDTO?,
    val daily: ClimaDiarioDTO?
)

data class ClimaAtualDTO(
    val temperature_2m: Double,
    val apparent_temperature: Double,
    val relative_humidity_2m: Int,
    val weather_code: Int,
    val wind_speed_10m: Double
)

data class ClimaDiarioDTO(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val weather_code: List<Int>
)

interface OpenMeteoApi {

    @GET("v1/search")
    suspend fun buscarCidade(
        @Query("name") nome: String,
        @Query("count") count: Int = 10,
        @Query("language") idioma: String = "pt",
        @Query("format") formato: String = "json"
    ): GeocodingResposta

    @GET("v1/forecast")
    suspend fun buscarClima(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String =
            "temperature_2m,apparent_temperature,relative_humidity_2m,weather_code,wind_speed_10m",
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min,weather_code",
        @Query("forecast_days") dias: Int = 7,
        @Query("timezone") timezone: String = "America/Sao_Paulo"
    ): WeatherResposta

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/"
        const val GEOCODING_URL = "https://geocoding-api.open-meteo.com/"
    }
}
