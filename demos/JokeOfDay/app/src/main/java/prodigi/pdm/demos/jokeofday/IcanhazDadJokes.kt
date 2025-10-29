package prodigi.pdm.demos.jokeofday

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import java.net.URL

/**
 * Implementation of the JokesService that fetches jokes from a remote server using HTTP.
 * @param client The HTTP client to use for fetching jokes.
 */
@Suppress("UNUSED")
class IcanhazDadJokes(private val client: HttpClient) : JokesService {
    private val source = URL("https://icanhazdadjoke.com/")

    override suspend fun fetchJoke(): Joke {
        delay(timeMillis = 3500) // Simulate network delay
        return client.get(url = source) { header("accept", "application/json") }
            .body<JokeDto>()
            .toJoke(source)
    }

    @Serializable
    private data class JokeDto(
        val id: String,
        val joke: String,
        val status: Int
    ) {
        fun toJoke(source: URL) = Joke(text = joke, source = source)
    }
}