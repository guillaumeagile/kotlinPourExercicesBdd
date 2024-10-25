package org.example.montaine.guillaume

data class Boutique(val Etat: String) {

    fun passeAlaCaisse(panier: Panier): TicketDeCaisse {
        return TicketDeCaisse(1)
    }

}

data class TicketDeCaisse(val Id: Int ) {

    val TotalTtc: Double = 5130.0
    val Reduction: Double = 5.0
}
