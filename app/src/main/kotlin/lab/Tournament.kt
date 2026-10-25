package lab

/**
 * The referee. Runs a round-robin tournament: every registered entry plays
 * every other entry exactly once; each match is [roundsPerMatch] rounds;
 * whoever wins more rounds wins the match. Ties in the standings are broken
 * by total rounds won across all matches, then by name.
 *
 * The harness itself rolls no dice, so a tournament is fully deterministic:
 * the same entries always produce the same leaderboard. (Entries that want
 * randomness should seed it themselves to stay reproducible.)
 *
 * Entries are instantiated fresh for every match, so per-match state kept in
 * fields resets between opponents.
 */
class Tournament(
    private val roundsPerMatch: Int = 300,
) {
    private val entries = mutableListOf<() -> Player>()

    /** Register an entry; [factory] is invoked once per match (fresh state). */
    fun register(factory: () -> Player) {
        entries += factory
    }

    /** Play every pairing and return the leaderboard. */
    fun play(): String {
        data class Stats(val player: Player, var matches: Int = 0, var rounds: Int = 0)

        // One long-lived instance per entry just for name/taunt display;
        // matches below always play on fresh instances.
        val stats = entries.map { Stats(it()) }

        for (i in entries.indices) {
            for (j in i + 1 until entries.size) {
                val (winsI, winsJ) = playMatch(entries[i], entries[j])
                stats[i].rounds += winsI
                stats[j].rounds += winsJ
                when {
                    winsI > winsJ -> stats[i].matches++
                    winsJ > winsI -> stats[j].matches++
                }
            }
        }

        return buildString {
            appendLine("=== Rock, Paper, Scissors Tournament ===")
            appendLine("${stats.size} entries · round-robin · $roundsPerMatch rounds per match")
            appendLine()
            stats
                .sortedWith(
                    compareByDescending<Stats> { it.matches }
                        .thenByDescending { it.rounds }
                        .thenBy { it.player.name },
                )
                .forEachIndexed { rank, s ->
                    appendLine(
                        "%d. %-20s %d matches, %3d rounds  \"%s\"".format(
                            rank + 1,
                            s.player.name,
                            s.matches,
                            s.rounds,
                            s.player.taunt,
                        ),
                    )
                }
        }
    }

    /** Play one match between fresh instances; returns rounds won by each. */
    private fun playMatch(
        factoryA: () -> Player,
        factoryB: () -> Player,
    ): Pair<Int, Int> {
        val a = factoryA()
        val b = factoryB()
        val historyA = mutableListOf<Move>()
        val historyB = mutableListOf<Move>()
        var winsA = 0
        var winsB = 0

        repeat(roundsPerMatch) {
            val moveA = a.nextMove(historyA, historyB)
            val moveB = b.nextMove(historyB, historyA)
            when {
                moveA.beats(moveB) -> winsA++
                moveB.beats(moveA) -> winsB++
            }
            historyA += moveA
            historyB += moveB
        }
        return winsA to winsB
    }

    private fun Move.beats(other: Move): Boolean =
        when (this) {
            Move.ROCK -> other == Move.SCISSORS
            Move.PAPER -> other == Move.ROCK
            Move.SCISSORS -> other == Move.PAPER
        }
}
