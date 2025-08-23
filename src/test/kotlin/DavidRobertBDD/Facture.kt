package DavidRobertBDD

import arrow.core.Either
import arrow.core.left
import arrow.core.right

class Facture private constructor(val montant: Double) {
    
    companion object {
        fun creer(montant: Double): Either<String, Facture> {
            return if (montant < 0) "montant de facture négatif non autorisé".left() 
           // else TODO()
            else Facture(montant).right()
        }
    }
    
    override fun toString(): String = "Facture(montant=$montant)"
}
