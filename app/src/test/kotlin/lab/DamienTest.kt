package lab

import org.junit.Test
import kotlin.test.assertEquals

class DamienTest {

    @Test
    fun beatsScissors() {
        val theirs = listOf(Move.SCISSORS, Move.SCISSORS, Move.SCISSORS)
        assertEquals(Move.ROCK, Damien().nextMove(emptyList(), theirs))
    }
}
