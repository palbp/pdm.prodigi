package prodigi.pdm.ongoing.uselessfacts

/**
 * Represents a useless fact obtained from a remote web API.
 *
 * @property text the useless fact as a string. Cannot be empty or blank.
 * @throws IllegalArgumentException if [text] is empty or blank
 */
data class UselessFact(val text: String) {
    init {
        require(text.isNotBlank()) { "UselessFact text cannot be empty or blank" }
    }
}

/**
 * Abstraction for a service that provides useless facts from a remote web API.
 *
 * Implementations of this interface are responsible for fetching a single fact
 * from a remote source. This abstraction allows the UI and other consumers to
 * remain decoupled from the details of the network or data source.
 */
interface UselessFactService {
    /**
     * Fetches a useless fact from the remote API.
     *
     * @return a [UselessFact] containing a useless fact
     * @throws Exception if the fact cannot be retrieved
     */
    suspend fun getFact(): UselessFact
}
