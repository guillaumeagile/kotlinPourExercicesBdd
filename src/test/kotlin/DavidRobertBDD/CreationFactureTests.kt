package DavidRobertBDD

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CreationFactureTests : BehaviorSpec({

    given("un professeur identifié par son email david.robert@um6.fr") {
        // val professeur = Professeur("david.robert@um6.fr")
        
        `when`("le montant de la facture est -10 €") {
            val montant = -10
            
            then("l'erreur montant de facture négatif non autorisé") {
                // Ici tu peux ajouter ton test
                // Par exemple :
                // shouldThrow<IllegalArgumentException> {
                //     CreationFacture(professeur, montant)
                // }.message shouldBe "montant de facture négatif non autorisé"
                
                // Pour l'instant, un test simple pour vérifier que ça fonctionne
                montant shouldBe -10
            }
        }
    }
})