package lab

fun main() {
    val tournament = Tournament()

    // Week 4: register your entry by adding one line here, e.g.
    //     tournament.register { Jason() }
    // (the tournament is runnable with any number of entries registered)
    tournament.register { Damien() }

    print(tournament.play())
}
