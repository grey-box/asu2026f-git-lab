package lab

import kotlin.test.Test
import kotlin.test.assertEquals

class HarshitTest {
    private val player = Harshit()

    @Test
    fun `empty opponent history returns paper`() {
        assertEquals(Move.PAPER, player.nextMove(emptyList(), emptyList()))
    }

    @Test
    fun `counters the most frequent move in the last five throws`() {
        val history = listOf(Move.ROCK, Move.PAPER, Move.ROCK, Move.ROCK, Move.SCISSORS)

        assertEquals(Move.PAPER, player.nextMove(emptyList(), history))
    }

    @Test
    fun `ignores history older than the last five throws`() {
        val history = listOf(
            Move.PAPER,
            Move.PAPER,
            Move.PAPER,
            Move.ROCK,
            Move.SCISSORS,
            Move.PAPER,
            Move.PAPER,
        )

        assertEquals(Move.SCISSORS, player.nextMove(emptyList(), history))
    }

    @Test
    fun `breaks frequency ties using the most recent tied move`() {
        val history = listOf(Move.ROCK, Move.PAPER)

        assertEquals(Move.SCISSORS, player.nextMove(emptyList(), history))
    }
}
