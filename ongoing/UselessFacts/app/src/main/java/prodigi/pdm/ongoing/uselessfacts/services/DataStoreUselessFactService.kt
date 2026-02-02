package prodigi.pdm.ongoing.uselessfacts.services

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import prodigi.pdm.ongoing.uselessfacts.UselessFact
import prodigi.pdm.ongoing.uselessfacts.UselessFactService

val Context.dataStore by preferencesDataStore(name = "useless_facts")

/**
 * DataStore-based implementation of [prodigi.pdm.ongoing.uselessfacts.UselessFactService].
 * On first use, populates the DataStore with a set of default facts if empty.
 * Each call to [getFact] returns a random fact from the DataStore.
 *
 * If you wish to implement a relational data base locally, look into Room
 * https://developer.android.com/training/data-storage/room
 *
 */
class DataStoreUselessFactService(private val context: Context) : UselessFactService {
    companion object {
        private val SINGLE_FACT = stringPreferencesKey("the_Fact")
        private val FACTS_KEY = stringSetPreferencesKey("facts")
        private val DEFAULT_FACTS = setOf(
            "Bananas are berries, but strawberries are not.",
            "Honey never spoils.",
            "A group of flamingos is called a 'flamboyance'.",
            "Octopuses have three hearts.",
            "The unicorn is the national animal of Scotland.",
            "Mosquitoes are attracted to people who just ate bananas.",
            "Wombat poop is cube-shaped.",
            "There are more fake flamingos in the world than real ones.",
            "A snail can sleep for three years.",
            "The dot over the letter 'i' is called a tittle."
        )
    }

    private suspend fun ensurePopulated() {
        val current = context.dataStore.data.map { it[FACTS_KEY] }.first()
        if (current == null || current.isEmpty()) {
            context.dataStore.edit { prefs ->
                prefs[FACTS_KEY] = DEFAULT_FACTS
            }
        }
    }

    override suspend fun getFact(): UselessFact {
        ensurePopulated()
        val facts = context.dataStore.data.map { it[FACTS_KEY] ?: DEFAULT_FACTS }.first()
        val factText = facts.random()
        return UselessFact(factText)
    }
}
