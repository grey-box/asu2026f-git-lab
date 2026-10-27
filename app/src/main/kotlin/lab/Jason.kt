package lab

class Jason : Player {
    override val name = "Jason"
    override val taunt = "Mathematically Lucky"

    override fun nextMove(
        myHistory: List<Move>,
        theirHistory: List<Move>
    ): Move {
        var rockCount = 0
        var scissorsCount = 0

        for (move in theirHistory) {
            if (move == Move.ROCK) {
                rockCount++
            } else if (move == Move.SCISSORS) {
                scissorsCount++
            }
        }

        if (scissorsCount > rockCount) {
            return Move.ROCK
        } else {
            return Move.PAPER
        }
    }
}
