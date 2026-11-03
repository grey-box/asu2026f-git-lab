package lab

class Harshit : Player {
    override val name = "Harshit"
    override val taunt = "I've seen enough."

    override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>): Move {
        if (theirHistory.isEmpty()) return Move.PAPER

        val recentMoves = theirHistory.takeLast(5)
        val counts = recentMoves.groupingBy { it }.eachCount()
        val mostFrequent = recentMoves.asReversed().first { move ->
            counts[move] == counts.values.maxOrNull()
        }

        return when (mostFrequent) {
            Move.ROCK -> Move.PAPER
            Move.PAPER -> Move.SCISSORS
            Move.SCISSORS -> Move.ROCK
        }
    }
}
