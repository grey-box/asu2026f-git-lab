package lab

class Flavio : Player{
	override val name = "Flavio"
	override val taunt = "If it works, I will keep it"
	override fun nextMove(myHistory: List<Move>, theirHistory: List<Move>): Move{
		// starts with rock on first round
		if (myHistory.isEmpty() || theirHistory.isEmpty()){ return Move.ROCK }

		val myLastMove = myHistory.last()
		val theirLastMove = theirHistory.last()

		return when {
			// keeps the move if won
			beats(myLastMove, theirLastMove) -> myLastMove

			//switches the move if tie
			myLastMove == theirLastMove -> nextMoveAfter(myLastMove)
			
			// counters opponent after a loss
			else -> counter(theirLastMove)
		}
	}

	private fun beats(myMove: Move, theirMove: Move): Boolean =
		when (myMove){
			Move.ROCK -> theirMove == Move.SCISSORS
			Move.PAPER -> theirMove == Move.ROCK
			Move.SCISSORS -> theirMove == Move.PAPER
		}	
	
	private fun counter(move: Move): Move =
			when (move){
				Move.ROCK ->  Move.PAPER
				Move.PAPER -> Move.SCISSORS
				Move.SCISSORS -> Move.ROCK
			}
	
	private fun nextMoveAfter(move: Move): Move =
			when (move) {
				Move.ROCK -> Move.PAPER
				Move.PAPER -> Move.SCISSORS
				Move.SCISSORS -> Move.ROCK
			}
}