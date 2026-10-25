package utils.brian_mejia_greybox

/**
 * Groups items by the key returned from [keySelector].
 * Groups appear in the order their key is first seen, and items keep
 * their original order within each group.
 */

fun <T, K> groupBy(items: List<T>, keySelector: (T) -> K): Map<K, List<T>> {
    val result = mutableMapOf<K, MutableList<T>>()
    for (item in items) {
        val key = keySelector(item)
        result.getOrPut(key) { mutableListOf() }.add(item)
    }
    return result
}
