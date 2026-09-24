package lab

import org.junit.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun `greet says hello`() {
        assertEquals("Hello, world!", greet("world"))
    }
}
