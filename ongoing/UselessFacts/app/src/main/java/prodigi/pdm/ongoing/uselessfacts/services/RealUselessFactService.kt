package prodigi.pdm.ongoing.uselessfacts.services

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import prodigi.pdm.ongoing.uselessfacts.APP_TAG
import prodigi.pdm.ongoing.uselessfacts.UselessFact
import prodigi.pdm.ongoing.uselessfacts.UselessFactService
import java.io.IOException

/**
 * Implementation of [prodigi.pdm.ongoing.uselessfacts.UselessFactService] that fetches facts from the remote API using Ktor client and Kotlin serialization.
 * API: https://uselessfacts.jsph.pl/api/v2/facts/random?language=en
 */
class RealUselessFactService : UselessFactService {

    init {
        Log.v(APP_TAG, "Inside RealUselessFactService constructor")
    }

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    private val endpoint = "https://uselessfacts.jsph.pl/api/v2/facts/random?language=en"

    @Serializable
    private data class ApiResponse(
        val text: String,
        val source: String
    )

    override suspend fun getFact(): UselessFact {
        try {
            val apiResponse: ApiResponse = client.get(endpoint) {
                headers.append("Accept", "application/json")
            }.body()
            // You can now use apiResponse.source as needed
            return UselessFact(apiResponse.text)
        } catch (e: Exception) {
            throw IOException("Failed to fetch fact: ${e.message}", e)
        }
    }
}
