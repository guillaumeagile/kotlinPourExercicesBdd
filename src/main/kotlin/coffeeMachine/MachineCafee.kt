package org.example.coffeeMachine

class MachineCafee(estPayante: Boolean) {

    fun Command(drink: Drink, sugar: Int, stick: Int): String {
        val codeStick = if (stick == 1) "0" else ""
        return when
                (drink) {
            Drink.Tea -> "T" + ":" + sugar.toString() + ":" + stick.toString()  //   "T:$sugar:$stick"
            Drink.Chocolate -> "H::"
            Drink.Coffee ->   "C:$sugar:$codeStick"
            else -> "Unknown drink"
        }
    }

    fun InsertCoin(i: Double) {

    }
}