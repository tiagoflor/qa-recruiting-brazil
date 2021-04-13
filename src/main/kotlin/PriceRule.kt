import java.util.Random
//import kotlin.random.Random

class PriceRule {
    internal var totalPurchases = 0
    internal var purchasedItems  = 0
    internal var quantityItemA = 0
    internal var quantityItemB = 0
    internal var quantityItemC = 0
    internal var quantityItemD = 0
    internal var itemA = 0
    internal var itemB = 0
    internal var itemC = 0
    internal var itemD = 0
    internal var specialPriceA = 0
    internal var specialPriceB = 0
    internal var randomGenerator = 0


    fun addingItem(item: String) { 
        when (item) {
            "A" -> { 
                ++quantityItemA 
                calculateItemA()
            }
            "B" -> { 
                ++quantityItemB
                calculateItemB()
            }
            "C" -> {
                ++quantityItemC
                calculateItemC()
            }
            "D" -> {
                ++quantityItemD
                calculateItemD()
            }
        }
    }
fun calculateItemA() {
    when (specialPriceA) {
        0 -> {
            itemA = itemA + 50
            println("Item A adicionado, seu valor unitario é 50 centavos, totalA:  $itemA")
            specialPriceA = 1
        }
        1 -> {
            itemA = itemA + 50
            println("Item A adicionado, seu valor unitario é 50 centavos, totalA:  $itemA")
            specialPriceA = 2
        }
        2 -> {
            itemA = itemA + 30 // no terceiro item passará a valer 30 do desconto aplicado
            println("Item A adicionado , devido a promoção da semana a  unidade terá 60% de desconto e o valor passará a ser é 30, totalA:  $itemA")
            specialPriceA = 0
        }
    }
}
fun calculateItemB() {
    when (specialPriceB) {
        0 -> {
            itemB = itemB + 30
            println(" Item B adicionado, seu valor unitario é 30 centavos, totalB: $itemB")
            specialPriceB = 1
        }
        1 -> {
            itemB = itemB + 15 
            println(" Item B adicionado , devido a promoção da semana a unidade terá  50% de desconto e o valor passará a ser 15 centavos, totalB:  $itemB")
            specialPriceB = 0
        }
    }
}

  

fun calculateItemC() {
    itemC = itemC + 20
    println("Item C adicionado ao Carrinho, seu valor unitário  é 20, totalC:  $itemC")
    }
fun calculateItemD() {
    itemD = itemD + 15
    println("Item D adicionado ao Carrinho, seu valor unitário é 15, totalD: $itemD")
    }
fun closePurchase() {
    totalPurchases = itemA + itemB + itemC + itemD
    purchasedItems = quantityItemA + quantityItemB + quantityItemC + quantityItemD
    println("\n ***FECHANDO COMPRA***")
    println("Total $purchasedItems de itens comprados.")
    println("Valor total a pagar: $totalPurchases")
    reset()
    }
private fun reset() {
    itemA = 0
    itemB = 0
    itemC = 0
    itemD = 0
    quantityItemA = 0
    quantityItemB = 0
    quantityItemC = 0
    quantityItemD = 0
    purchasedItems = 0
    totalPurchases = 0
    }

fun randomItems():Int {
    val randomValues = Random()
    randomGenerator = randomValues.nextInt((5) + 1)
    return randomGenerator
    }

}
