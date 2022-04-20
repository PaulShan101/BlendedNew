package blended.example.blended

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun subtract_isCorrect() {
        assertEquals(3, 10 - 7)
    }

    @Test
    fun test_bmi() {

        //val bmi = 703 * (185 / (100 * 100))

        assertEquals(48, 34 * 10 / 7)
    }

}