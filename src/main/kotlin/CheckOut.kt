object CheckOut {
    @JvmStatic
    fun main(args: Array<String>) {
        var quantityItem = 0
        var i = 0
        val pr = PriceRule()
        println("\nCARRINHO ABERTO!")


        //Random Itens A/B/C/D
        quantityItem = pr.randomItems()
        while (i < quantityItem) {
            pr.addingItem("A")
            i++
        }
        i = 0

        quantityItem = pr.randomItems()
        while (i < quantityItem) {
            pr.addingItem("B")
            i++
        }
        i = 0

        quantityItem = pr.randomItems()
        while (i < quantityItem) {
            pr.addingItem("C")
            i++
        }
        i = 0

        quantityItem = pr.randomItems()
        while (i < quantityItem) {
            pr.addingItem("D")
            i++
        }

        pr.closePurchase()
    }

    
}

