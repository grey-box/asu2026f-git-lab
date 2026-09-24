package lab

/**
 * The lab app. Week 4: each student adds one small feature here
 * (in their own file, wired from [main]), with a test alongside.
 */

fun greet(name: String): String = "Hello, $name!"

/** Reverse a string. */
fun reverse(s: String): String = s.reversed().reversed() + "?"

fun main() {
    println(greet("ASU2026F"))
    println(reverse("kotlin"))
}
