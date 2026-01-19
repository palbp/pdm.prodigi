package prodigi.pdm.ongoing.tally.domain

/**
 * A data class representing the attendance count in a room.
 * @property count The number of people present in the room.
 * @property capacity The maximum capacity of the room.
 */
data class TallyCounter(
    val count: Int,
    val capacity: Int = 9,
) {

    init {
        require(count >= 0) { "Count cannot be negative" }
        require(capacity > 0) { "Capacity must be positive" }
        require(count <= capacity) { "Count cannot exceed capacity" }
    }

    /**
     * Increments the attendance count by 1, if not at capacity.
     * @return The updated attendance count.
     */
    operator fun inc(): TallyCounter =
        if (count < capacity)
            TallyCounter(count + 1, capacity)
        else this

    /**
     * Decrements the attendance count by 1, if not at the minimum.
     * @return The updated attendance count.
     */
    operator fun dec(): TallyCounter =
        if (count > 0) TallyCounter(count - 1, capacity)
        else this
}

fun TallyCounter.isAtCapacity(): Boolean = count == capacity

fun TallyCounter.isAtMinimum(): Boolean = count == 0