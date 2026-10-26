package lab

class Damien : Player {
    override val name = "Damien"
    override val taunt = "Rock wins."
    override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>) = Move.ROCK
}
