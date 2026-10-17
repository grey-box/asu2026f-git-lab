package utils.jason_garcia_grey_box

fun <T> dedupePreservingOrder(items: List<T>): List<T> {
	val seen = mutableSetOf<T>()
	val result = mutableListOf<T>()

	for(item in items) {
		if(!seen.contains(item)) {
			seen.add(item)
			result.add(item)
		}
	}

	return result
}
