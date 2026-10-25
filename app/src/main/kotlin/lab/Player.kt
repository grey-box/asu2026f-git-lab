package lab

/**
 * The three legal throws.
 */
enum class Move { ROCK, PAPER, SCISSORS }

/**
 * One tournament entry: a rock, paper, scissors function. Implement this in
 * your own file, then register your entry in `Main.kt`.
 *
 * [nextMove] is called once per round with everything thrown so far in the
 * current match (empty lists on round 1) and returns exactly one [Move].
 * Entries are instantiated fresh for every match, so per-match state kept in
 * fields resets between opponents.
 */
interface Player {
    val name: String    // shows up on the leaderboard
    val taunt: String   // one line of trash talk
    fun nextMove(myHistory: List<Move>, theirHistory: List<Move>): Move
}
