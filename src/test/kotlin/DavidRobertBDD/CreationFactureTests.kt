package DavidRobertBDD

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import arrow.core.getOrElse

class CreationFactureTests : BehaviorSpec({

    given("un professeur identifié par son email david.robert@um6.fr") {
        // val professeur = Professeur("david.robert@um6.fr")
        
        `when`("le montant de la facture est -10 €") {
            
            // driver choisi : au niveau de l'entité métier avec Arrow-kt
            val resultatFacture = Facture.creer(-10.0)

            then("la facture n'existe pas") {                
                resultatFacture.isLeft() shouldBe true
            }         
            
            then("l'erreur montant de facture négatif non autorisé") {
                
                resultatFacture.fold(
                    { erreur -> erreur shouldBe "montant de facture négatif non autorisé" },
                    { _ -> throw AssertionError("Devrait être une erreur") }
                )
            }
        }
        
        `when`("le montant de la facture est 0 €") {
            val resultatFacture = Facture.creer(0.0)
            
            then("la facture est créée avec succès") {
                resultatFacture.isRight() shouldBe true
                resultatFacture.getOrElse { throw AssertionError("Devrait être un succès") }.montant shouldBe 0.0
            }
        }
    }
})