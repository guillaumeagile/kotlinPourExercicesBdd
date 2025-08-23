package DavidRobertBDD

class Facture private constructor(val montant: Double) {
    
    companion object {
        fun creer(montant: Double): Possiblement<String, Facture> {
            return if (montant < 0) {
                "montant de facture négatif non autorisé".echec()
            } else {
                Facture(montant).succes()
            }
        }
    }
    
    override fun toString(): String = "Facture(montant=$montant)"
}
