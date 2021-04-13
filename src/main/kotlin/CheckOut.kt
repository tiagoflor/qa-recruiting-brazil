object CheckOut {
    @JvmStatic
    fun main(args: Array<String>) {
        var quantityItem = 0
        var i = 0
        val pr = PriceRule() //instancia da regra carrinho regra para usar na classe
        println("\nCARRINHO ABERTO!")


        quantityItem = pr.randomItems()//Sorteio da quantidade do  A que vai ser adionado
        while (i < quantityItem) {
            pr.addingItem("A")
            i++
        }
        i = 0

        quantityItem = pr.randomItems()//Sorteio a quantidade do  B que vai ser adionado
        while (i < quantityItem) {
            pr.addingItem("B")
            i++
        }
        i = 0

        quantityItem = pr.randomItems()//Sorteio a quantidade do  C que vai ser adicionado
        while (i < quantityItem) {
            pr.addingItem("C")
            i++
        }
        i = 0

        quantityItem = pr.randomItems()//Sorteio a quantidade do  D que vai ser adicionado
        while (i < quantityItem) {
            pr.addingItem("D")
            i++
        }

        pr.closePurchase()
    }

    //Objetos com invoke() podem ser chamados como uma função
    // operator fun invoke(priceRule: PriceRule): Any {
    //   return CheckOut
    //}
}

