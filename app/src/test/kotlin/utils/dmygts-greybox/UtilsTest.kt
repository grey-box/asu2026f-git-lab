package utils.dmygtsgreybox
import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest {
	@Test
	fun `empty list`() {
		val (matching, notMatching) = partition(emptyList<Int>()) { it > 0 }
        	assertEquals(emptyList(), matching)
	        assertEquals(emptyList(), notMatching)
	}

	@Test
 	fun `single matching`() {
        	val (matching, notMatching) = partition(listOf(5)) { it > 0 }
	        assertEquals(listOf(5), matching)
	        assertEquals(emptyList(), notMatching)
    	}

   	 @Test
	 fun `single non-match`() {
	        val (matching, notMatching) = partition(listOf(-5)) { it > 0 }
        	assertEquals(emptyList(), matching)
	        assertEquals(listOf(-5), notMatching)
	}

    	@Test
    	fun `mixed list`() {
        	val (positive, negative) = partition(listOf(1, 3, -4, 2, -11)) { it > 0 }
	        assertEquals(listOf(1, 3, 2), positive)
	        assertEquals(listOf(-4, -11), negative)   
	}

	@Test
	fun `works with strings`() {
        	val (short, long) = partition(listOf("a", "abc", "bb")) { it.length < 2 }
	        assertEquals(listOf("a"), short)
	        assertEquals(listOf("abc", "bb"), long)
    }
}
