package lab

import org.junit.Test
import kotlin.test.assertEquals

class BrianTest {

    @Test
    fun `counters an opponent who always throws rock`() {
        val theirs = listOf(Move.ROCK, Move.ROCK, Move.ROCK, Move.ROCK)
        val mine = listOf(Move.PAPER, Move.PAPER, Move.PAPER, Move.PAPER)
        assertEquals(Move.PAPER, Brian().nextMove(mine, theirs))
    }

    @Test
    fun `spots a rock-paper-scissors cycle and counters the next throw`() {
        // After PAPER they always throw SCISSORS, so Brian should throw ROCK
        val theirs = listOf(
            Move.ROCK, Move.PAPER, Move.SCISSORS,
            Move.ROCK, Move.PAPER, Move.SCISSORS,
            Move.ROCK, Move.PAPER
        )
        val mine = List(theirs.size) { Move.ROCK }
        assertEquals(Move.ROCK, Brian().nextMove(mine, theirs))
    }

    @Test
    fun `first move is reproducible`() {
        assertEquals(
            Brian().nextMove(emptyList(), emptyList()),
            Brian().nextMove(emptyList(), emptyList())
        )
    }
}
