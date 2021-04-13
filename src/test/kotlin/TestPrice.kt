

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

abstract class TestPrice {
    internal abstract var rules: PriceRule
    @Before
    @Throws(Exception::class)
    fun setUp() {
        rules = PriceRule()
    }
    @After
    @Throws(Exception::class)
    fun tearDown() {
        this.rules = null
    }
    @Test
    @Throws(Exception::class) 
    fun testTotal() {
        assertEquals(0, price("").toLong())
        assertEquals(50, price("A").toLong())
        assertEquals(80, price("AB").toLong())
        assertEquals(115, price("CDBA").toLong())
        assertEquals(100, price("AA").toLong())
        assertEquals(130, price("AAA").toLong())
        assertEquals(180, price("AAAA").toLong())
        assertEquals(230, price("AAAAA").toLong())
        assertEquals(260, price("AAAAAA").toLong())
        assertEquals(160, price("AAAB").toLong())
        assertEquals(175, price("AAABB").toLong())
        assertEquals(190, price("AAABBD").toLong())
        assertEquals(190, price("DABABA").toLong())
    }
    @Test
    @Throws(Exception::class)
    fun testIncremental() {
        val checkOut = CheckOut()
        assertEquals(0, checkOut.total())
        checkOut.scan("A")
        assertEquals(50, checkOut.total())
        checkOut.scan("B")
        assertEquals(80, checkOut.total())
        checkOut.scan("A")
        assertEquals(130, checkOut.total())
        checkOut.scan("A")
        assertEquals(160, checkOut.total())
        checkOut.scan("B")
        assertEquals(175, checkOut.total())
    }

    @Throws(Exception::class) //usado para indicar que esse método pode lançar esse tipo de exceção
    fun price(itemNames:String):Int {
        val checkOut = CheckOut()
        for (i in 0 until itemNames.length)
        {
            val name = Character.toString(itemNames.get(i))
            val item = PriceRule().withName(name).build()
            checkOut.scan(item)
        }
        return checkOut.total()
    }
}

