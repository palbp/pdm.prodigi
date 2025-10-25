package prodigi.pdm.demos.jokeofday

import android.app.Application
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val JOKE_APP_TAG = "JokeApp"

/**
 * The Application class for the Demos Host Application.
 * It initializes and provides access to shared services used across the app.
 */
class JokeOfDayApplication : Application() {

    private val httpClient by lazy {
        // HTTP engine is chosen by Ktor based on the current dependencies and platform.
        HttpClient {
            install(plugin = ContentNegotiation) {
                json(
                    json = Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    val jokeService by lazy {
        IcanhazDadJokes(client = httpClient)
        // FakeJokesService()
    }
}