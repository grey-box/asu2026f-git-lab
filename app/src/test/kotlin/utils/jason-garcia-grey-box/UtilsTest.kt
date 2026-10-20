package utils.jason_garcia_grey_box

import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest {
    @Test
    fun `Empty list returns empty list`() {
        val input = emptyList<Int>()
	val expected = emptyList<Int>()

	val actual = dedupePreservingOrder(input)
	
	assertEquals(expected, actual)
    }
    @Test
    fun `List without duplicates keeps its order`() {
        val input = listOf(3, 1, 2)
        val expected = listOf(3, 1, 2)

        val actual = dedupePreservingOrder(input)

        assertEquals(expected, actual)
    }
    @Test
    fun `Identical elements appear only onec`() {
        val input = listOf(4, 4, 4)
        val expected = listOf(4)

        val actual = dedupePreservingOrder(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `Separated duplicates keep first appearance order`() {
        val input = listOf(3, 1, 3, 2, 1)
        val expected = listOf(3, 1, 2)

        val actual = dedupePreservingOrder(input)

        assertEquals(expected, actual)
    }

}
