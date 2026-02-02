package prodigi.pdm.ongoing.uselessfacts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Represents the possible UI states for the useless fact screen.
 */
sealed interface FactUiState {
    /**
     * Idle state: No loading is in progress. Displays the current fact if available.
     */
    data class Idle(val fact: UselessFact?) : FactUiState
    /**
     * Loading state: A fact is being fetched from the service.
     */
    object Loading : FactUiState
    /**
     * Error state: An error occurred while fetching a fact.
     */
    data class Error(val message: String) : FactUiState
}

/**
 * ViewModel responsible for managing the UI state of the useless fact screen.
 *
 * This ViewModel exposes a [FactUiState] property that represents the current state of the screen.
 * It provides a [fetchFact] method to asynchronously fetch a new useless fact from the provided [UselessFactService].
 *
 * The existing states are as follows:
 * - [FactUiState.Idle]: No loading is in progress. Displays the current fact if available.
 * - [FactUiState.Loading]: A fact is being fetched from the service.
 * - [FactUiState.Error]: An error occurred while fetching a fact.
 *
 * The ViewModel does not fetch a fact automatically on initialization. The UI should call [fetchFact] explicitly.
 *
 * @property service The abstraction used to fetch useless facts from a remote API.
 */
class FactViewModel(
    private val service: UselessFactService
) : ViewModel() {
    /**
     * The current UI state of the screen. Use this property to observe and display the state in the UI.
     */
    var state: FactUiState by mutableStateOf(FactUiState.Idle(null))
        private set

    /**
     * Fetches a new useless fact from the [service].
     *
     * Sets the state to [FactUiState.Loading] while fetching, then to [FactUiState.Idle] with the new fact,
     * or to [FactUiState.Error] if an error occurs.
     *
     * @throws IllegalStateException if called while a fact is already being loaded.
     */
    fun fetchFact() {
        check(state !is FactUiState.Loading) { "Cannot fetch fact while already loading." }
        state = FactUiState.Loading
        viewModelScope.launch {
            try {
                val fact = service.getFact()
                state = FactUiState.Idle(fact)
            } catch (e: Exception) {
                state = FactUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    companion object {
        /**
         * Returns a [ViewModelProvider.Factory] that provides [FactViewModel] with the given [UselessFactService].
         */
        fun factory(service: UselessFactService): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(FactViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return FactViewModel(service) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            }
    }
}
