package prodigi.pdm.ongoing.uselessfacts.services

import kotlinx.coroutines.delay
import prodigi.pdm.ongoing.uselessfacts.UselessFact
import prodigi.pdm.ongoing.uselessfacts.UselessFactService
import kotlin.random.Random

/**
 * Fake implementation of [prodigi.pdm.ongoing.uselessfacts.UselessFactService] for demo and testing purposes.
 * Simulates network delay and returns a random useless fact each time [getFact] is called.
 * Occasionally throws an exception to simulate network errors.
 */
class FakeUselessFactService : UselessFactService {
    private val facts = listOf(
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

    override suspend fun getFact(): UselessFact {
        delay(1500) // Simulate network delay of 1.5 seconds
        // Simulate error with 1 in 5 chance
        if (Random.nextInt(5) == 0) {
            throw RuntimeException("Network error: Could not fetch fact.")
        }
        val factText = facts.random()
        return UselessFact(factText)
    }
}
