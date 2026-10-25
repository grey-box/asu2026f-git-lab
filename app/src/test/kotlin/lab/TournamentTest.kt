package lab

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/** Fixed deterministic entries used to test the harness. */
private class AlwaysRock : Player {
    override val name = "Rock Solid"
    override val taunt = "rock."
    override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>) = Move.ROCK
}

private class AlwaysPaper : Player {
    override val name = "Paperwork"
    override val taunt = "files everything"
    override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>) = Move.PAPER
}

private class FrequencyCounter : Player {
    override val name = "The Counter"
    override val taunt = "i see you"
    override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>): Move {
        if (theirHistory.isEmpty()) return Move.PAPER
        val favorite = theirHistory.groupBy { it }.maxBy { it.value.size }.key
        return favorite.beatenBy()
    }

    private fun Move.beatenBy(): Move =
        when (this) {
            Move.ROCK -> Move.PAPER
            Move.PAPER -> Move.SCISSORS
            Move.SCISSORS -> Move.ROCK
        }
}

class TournamentTest {

    @Test
    fun `paper beats rock for the whole match`() {
        val out = Tournament(roundsPerMatch = 10)
            .apply { register { AlwaysRock() }; register { AlwaysPaper() } }
            .play()
        // Paperwork wins the match 10 rounds to 0.
        assertTrue(out.lines().first { it.contains("Paperwork") }.startsWith("1."), out)
        assertTrue(out.lines().first { it.contains("Rock Solid") }.startsWith("2."), out)
        assertTrue("0 rounds" in out.lines().first { it.contains("Rock Solid") }, out)
    }

    @Test
    fun `frequency counter exploits always-rock`() {
        val out = Tournament(roundsPerMatch = 10)
            .apply { register { AlwaysRock() }; register { FrequencyCounter() } }
            .play()
        // The Counter must top the leaderboard: it counters every rock with paper.
        assertTrue(out.lines().first { it.contains("The Counter") }.startsWith("1."), out)
    }

    @Test
    fun `leaderboard is deterministic across runs`() {
        fun runOnce() = Tournament(roundsPerMatch = 25)
            .apply {
                register { AlwaysRock() }
                register { AlwaysPaper() }
                register { FrequencyCounter() }
            }
            .play()
        assertEquals(runOnce(), runOnce())
    }
}
