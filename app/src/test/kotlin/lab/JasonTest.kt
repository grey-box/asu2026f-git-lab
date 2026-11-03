package lab

import org.junit.Test
import kotlin.test.assertEquals

class JasonTest {
    @Test
    fun `starts with paper`() {
        val player = Jason()

        val actual = player.nextMove(emptyList(), emptyList())

        assertEquals(Move.PAPER, actual)
    }

    @Test
    fun `plays paper when opponent favors rock`() {
        val player = Jason()
        val myHistory = listOf(Move.PAPER, Move.PAPER, Move.ROCK)
        val theirHistory = listOf(Move.ROCK, Move.SCISSORS, Move.ROCK)

        val actual = player.nextMove(myHistory, theirHistory)

        assertEquals(Move.PAPER, actual)
    }

    @Test
    fun `plays rock when opponent favors scissors`() {
        val player = Jason()
        val myHistory = listOf(Move.PAPER, Move.ROCK, Move.ROCK)
        val theirHistory = listOf(Move.SCISSORS, Move.ROCK, Move.SCISSORS)

        val actual = player.nextMove(myHistory, theirHistory)

        assertEquals(Move.ROCK, actual)
    }

    @Test
    fun `plays paper when rock and scissors counts tie`() {
        val player = Jason()
        val myHistory = listOf(Move.PAPER, Move.ROCK)
        val theirHistory = listOf(Move.ROCK, Move.SCISSORS)

        val actual = player.nextMove(myHistory, theirHistory)

        assertEquals(Move.PAPER, actual)
    }
}
