package utils.harshit_kumar

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UtilsTest {
    @Test
    fun `empty list returns empty list`() {
        val result = zipWithIndex(emptyList<String>())
        assertTrue(result.isEmpty())
    }

    @Test
    fun `single element gets index zero`() {
        val result = zipWithIndex(listOf("hello"))
        assertEquals(listOf(Pair("hello", 0)), result)
    }

    @Test
    fun `multiple elements receive sequential zero-based indices`() {
        val result = zipWithIndex(listOf("a", "b", "c", "d"))
        val expected = listOf(
            Pair("a", 0),
            Pair("b", 1),
            Pair("c", 2),
            Pair("d", 3)
        )
        assertEquals(expected, result)
    }

    @Test
    fun `duplicate elements remain separate with different indices`() {
        val result = zipWithIndex(listOf("x", "y", "x", "z", "x"))
        assertEquals(Pair("x", 0), result[0])
        assertEquals(Pair("x", 2), result[2])
        assertEquals(Pair("x", 4), result[4])
        assertEquals(5, result.size)
    }

    @Test
    fun `works with non-String types`() {
        val result = zipWithIndex(listOf(10, 20, 30))
        val expected = listOf(
            Pair(10, 0),
            Pair(20, 1),
            Pair(30, 2)
        )
        assertEquals(expected, result)
    }
}
