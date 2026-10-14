package utils.brian_mejia_greybox

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UtilsTest {
    @Test
    fun `empty list returns empty map`() {
        val result = groupBy(emptyList<String>()) { it.length }
        assertTrue(result.isEmpty())
    }

    @Test
    fun `single element makes one group`() {
        val result = groupBy(listOf("hello")) { it.length }
        assertEquals(mapOf(5 to listOf("hello")), result)
    }

    @Test
    fun `groups words by first letter`() {
        val words = listOf("apple", "avocado", "banana", "blueberry", "cherry")
        val result = groupBy(words) { it.first() }
        val expected = mapOf(
            'a' to listOf("apple", "avocado"),
            'b' to listOf("banana", "blueberry"),
            'c' to listOf("cherry"),
        )
        assertEquals(expected, result)
    }

    @Test
    fun `keeps original order and duplicates within each group`() {
        val result = groupBy(listOf(3, 1, 4, 1, 5, 9, 2, 6)) { it % 2 }
        assertEquals(listOf(3, 1, 1, 5, 9), result[1])
        assertEquals(listOf(4, 2, 6), result[0])
    }

    @Test
    fun `groups appear in the order their key is first seen`() {
        val result = groupBy(listOf("cherry", "apple", "banana", "avocado")) { it.first() }
        assertEquals(listOf('c', 'a', 'b'), result.keys.toList())
    }
}
