package utils.dmygtsgreybox

fun <T> partition(items: Iterable<T>, predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
	val matching = mutableListOf<T>()
	val notMatching = mutableListOf<T>()
	for (item in items) {
		if (predicate(item)) {
			matching.add(item)
		} else {
			notMatching.add(item)
		}
	}
	return Pair(matching, notMatching)
}
