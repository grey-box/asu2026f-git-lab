package utils.flaviovazquezgreybox
import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest{
	// this tests that fold adds multiple values correctly
	@Test
	fun `fold adds multiple numbers`(){
		val result=fold(listOf(1,2,3),0) {total,number->total+number}
		assertEquals(6,result)
	}
	
	//this tests that fold works correctly when the list has only one item
	@Test
	fun `fold works with one element`(){
		val result=fold(listOf(5),0) {total,number->total+number}
		assertEquals(5,result)
	}
	
	// this tests that fold can combine strings
	@Test
	fun `fold works with strings`(){
		val result=fold(listOf("a","b","c"),"") {text,value->text+value}
		assertEquals("abc",result)
	}

	// this tests that an empty list returns the starting value unchanged
	@Test
	fun `fold returns initial value for empty list`(){
		val result=fold(emptyList<Int>(),10) {total,number->total+number}
		assertEquals(10,result)
	}
}

