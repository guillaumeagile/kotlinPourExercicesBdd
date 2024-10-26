package org.example.coffeeMachine

class MachineCafee {
    fun Command(drink: Any, sugar: Int, stick: Int): String {
        return when
                   (drink) {
                        Drink.Tea -> "T:$sugar:$stick"
                        Drink.Chocolate -> "H::"
                        else -> "Unknown drink"
        }
    }
}