
//import item.Item
//import item.ItemBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test
import PriceRule
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
    @Throws(Exception::class) //usado para indicar que esse método pode lançar esse tipo de exceção.
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

/*
import item.Item
import item.ItemBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test
import rule.PricingRules
import org.junit.Assert.assertEquals
class KataTest {
    internal var rules:PricingRules
    @Before
    @Throws(Exception::class)
    fun setUp() {
        rules = PricingRules("pricing.txt")
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
        val checkOut = CheckOut(rules)
        assertEquals(0, checkOut.total())
        checkOut.scan(Item("A"))
        assertEquals(50, checkOut.total())
        checkOut.scan(Item("B"))
        assertEquals(80, checkOut.total())
        checkOut.scan(Item("A"))
        assertEquals(130, checkOut.total())
        checkOut.scan(Item("A"))
        assertEquals(160, checkOut.total())
        checkOut.scan(Item("B"))
        assertEquals(175, checkOut.total())
    }
    @Throws(Exception::class)
    fun price(itemNames:String):Int {
        val checkOut = CheckOut(rules)
        for (i in 0 until itemNames.length)
        {
            val name = Character.toString(itemNames.get(i))
            val item = ItemBuilder().withName(name).build()
            checkOut.scan(item)
        }
        return checkOut.total()
    }
}

/*
class TestPrice < Test::Unit::TestCase

    df price(goods) //def = metodos da classe
    co = CheckOut.new(RULES) //instanciando
    goods.split(//).each { |item| co.scan(item) }
    co.totale'
        end

    def test_totals  //def = metodos da classe test totals
    assert_equal(  0, price(""))
    assert_equal( 50, price("A"))
    assert_equal( 80, price("AB"))
    assert_equal(115, price("CDBA"))

    assert_equal(100, price("AA"))
    assert_equal(130, price("AAA"))
    assert_equal(180, price("AAAA"))
    assert_equal(230, price("AAAAA"))
    assert_equal(260, price("AAAAAA"))

    assert_equal(160, price("AAAB"))
    assert_equal(175, price("AAABB"))
    assert_equal(190, price("AAABBD"))
    assert_equal(190, price("DABABA"))
        end

    def test_incremental //def = metodos da classe test incremental
    co = CheckOut.new(RULES)
    assert_equal( 0, co.total)
    co.scan("A"); assert_equal( 50, co.total)
    co.scan("B"); assert_equal( 80, co.total)
    co.scan("A"); assert_equal(130, co.total)
    co.scan("A"); assert_equal(160, co.total)
    co.scan("B"); assert_equal(175, co.total)
        end
end