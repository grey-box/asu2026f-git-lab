package utils.harshit_kumar

/**
 * Pairs each element with its zero-based index.
 * Returns a list of pairs where the first element is the original item
 * and the second element is its index in the input list.
 */
fun <T> zipWithIndex(items: List<T>): List<Pair<T, Int>> {
    val result = mutableListOf<Pair<T, Int>>()
    for (i in items.indices) {
        result.add(Pair(items[i], i))
    }
    return result
}
