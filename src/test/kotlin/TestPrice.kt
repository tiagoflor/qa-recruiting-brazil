

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
    assertEquals(0, price(""))
    assertEquals(50, price("A"))
    assertEquals(80, price("AB"))
    assertEquals(115, price("CDBA"))
    assertEquals(100, price("AA"))
    assertEquals(130, price("AAA"))
    assertEquals(180, price("AAAA"))
    assertEquals(230, price("AAAAA"))
    assertEquals(260, price("AAAAAA"))
    assertEquals(160, price("AAAB"))
    assertEquals(175, price("AAABB"))
    assertEquals(190, price("AAABBD"))
    assertEquals(190, price("DABABA"))
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

    /*@Throws(Exception::class) //usado para indicar que esse método pode lançar esse tipo de exceção
    fun price(itemNames:String):Int {
        val checkOut = CheckOut()
        for (i in 0 until itemNames.length) //procurando outra solução para aplicar "scan" / "price" 
        {
            val name = Character.toString(itemNames.get(i))
            val item = PriceRule().withName(name).build()
            checkOut.scan(item)
        }
        return checkOut.total()
    }*/
}

