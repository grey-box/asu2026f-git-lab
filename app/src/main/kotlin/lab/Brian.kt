package lab

import kotlin.random.Random

class Brian : Player {
    override val name = "Brian"
    override val taunt = "I already know your next move."

    // Seeded so every tournament run is reproducible
    private val rng = Random(2026)

    override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>): Move {
        if (theirHistory.isEmpty()) return Move.values()[rng.nextInt(3)]
        val predicted = predictFromPattern(theirHistory) ?: mostFrequent(theirHistory)
        return beats(predicted)
    }

    // What have they usually thrown right after their last move?
    private fun predictFromPattern(history: List<Move>): Move? {
        val last = history.last()
        val followUps = history.zipWithNext()
            .filter { it.first == last }
            .map { it.second }
        if (followUps.isEmpty()) return null
        return followUps.groupingBy { it }.eachCount().maxBy { it.value }.key
    }

    private fun mostFrequent(history: List<Move>): Move =
        history.groupingBy { it }.eachCount().maxBy { it.value }.key

    companion object {
        fun beats(move: Move): Move = when (move) {
            Move.ROCK -> Move.PAPER
            Move.PAPER -> Move.SCISSORS
            Move.SCISSORS -> Move.ROCK
        }
    }
}
