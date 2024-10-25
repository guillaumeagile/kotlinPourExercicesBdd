package org.example.montaine.guillaume

data class Boutique(val Etat: String) {

    fun passeAlaCaisse(panier: Panier): TicketDeCaisse {
        return TicketDeCaisse(1)
    }

}

