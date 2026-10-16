
package utils.flaviovazquezgreybox

fun <T,R> fold(items: Iterable<T>,initial: R, operation: (R,T) -> R): R{
	var accumulator=initial
	for(item in items){
		accumulator=operation(accumulator,item)
	}
	return accumulator
}
