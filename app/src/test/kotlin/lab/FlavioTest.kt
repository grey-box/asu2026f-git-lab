package lab

import org.junit.Test
import kotlin.test.assertEquals

class FlavioTest{
	private val player = Flavio()

    // tests the starting move
    @Test
    fun `starts with rock`(){
        assertEquals(Move.ROCK, player.nextMove(emptyList(), emptyList()))
    }

    // tests that a winning move is repeated
    @Test
    fun `repeats move after winning`(){
        val myHistory = listOf(Move.ROCK)
        val theirHistory = listOf(Move.SCISSORS)

        assertEquals(Move.ROCK, player.nextMove(myHistory, theirHistory))
    }

    // tests that a losing move is changed to a counter
    @Test
    fun `counters opponent after losing`(){
        val myHistory = listOf(Move.ROCK)
        val theirHistory = listOf(Move.PAPER)

        assertEquals(Move.SCISSORS, player.nextMove(myHistory, theirHistory))
    }

    // tests that a tie causes the move to change
    @Test
    fun `changes move after a tie`(){
        val myHistory = listOf(Move.ROCK)
        val theirHistory = listOf(Move.ROCK)

        assertEquals(Move.PAPER, player.nextMove(myHistory, theirHistory))
    }
}