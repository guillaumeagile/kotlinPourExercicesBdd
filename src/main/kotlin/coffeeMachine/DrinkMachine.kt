package org.example.coffeeMachine

class DrinkMachine(paymentRequired: Boolean) {

    private var _totalAmount: Double = 0.0

    public var TotalAmount: Double = 0.0
        get() = _totalAmount



    fun Command(drink: Drink, sugar: Int, stick: Int): String {
        val codeStick = if (stick == 1) "0" else ""
        return when
                (drink) {
            Drink.Tea ->  "T:$sugar:$stick" // "T" + ":" + sugar.toString() + ":" + stick.toString()
            Drink.Chocolate -> "H::"
            Drink.Coffee ->   "C:$sugar:$codeStick"
            else -> "Unknown drink"
        }
    }

    fun InsertCoin(i: Double) {
            _totalAmount += i
    }

    fun Reset() {
        _totalAmount = 0.0
    }
}