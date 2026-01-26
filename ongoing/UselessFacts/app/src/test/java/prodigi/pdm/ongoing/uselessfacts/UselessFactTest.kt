package prodigi.pdm.ongoing.uselessfacts

import org.junit.Assert.assertEquals
import kotlin.test.assertFailsWith
import org.junit.Test

class UselessFactTest {
    @Test
    fun `creation succeeds with non-blank string`() {
        val value = "A shrimp's heart is in its head."
        val fact = UselessFact(value)
        assertEquals(value, fact.text)
    }

    @Test
    fun `creation fails with empty string`() {
        assertFailsWith<IllegalArgumentException> {
            UselessFact("")
        }
    }

    @Test
    fun `creation fails with blank string`() {
        assertFailsWith<IllegalArgumentException> {
            UselessFact("   ")
        }
    }
}
