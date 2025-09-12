package org.example.facturation

class Facture private constructor(val montant: Double) {

    companion object {
        fun creer(artistan: Utilisateur.Artisan, montant: Double): Possiblement<String, Facture> {
            return if (montant < 0) {
                "montant de facture négatif non autorisé".echec()
            } else {
                Facture(montant).succes()
            }
        }

        fun creer2(artistan: Utilisateur, montant: Double): Possiblement<String, Facture> {
            TODO("Not yet implemented")
        }
    }

    override fun toString(): String = "Facture(montant=$montant)"
}