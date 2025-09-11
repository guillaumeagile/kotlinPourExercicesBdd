package DavidRobertBDD

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CreationFactureTests : BehaviorSpec({

    given("je suis artisan") {

        val artisan = Artisan()
        
        `when`("le montant de la facture est -10 €") {
            
            // driver choisi : le niveau de l'entité métier avec son vocabulaire métier en français
            val resultatFacture = Facture.creer(artisan, -10.0)

            then("la facture ne sera créée pas") {
                resultatFacture.Echec() shouldBe true
            }         
            
            then("l'erreur doit être: montant de facture négatif non autorisé") {

            resultatFacture.selon(
                    siEchec = { err -> err shouldBe "montant de facture négatif non autorisé" },
                    siSucces = { _ -> throw AssertionError("Devrait être une erreur") }
                )
            }
        }
        
        `when`("le montant de la facture est 0 €") {
            val resultatFacture = Facture.creer(artisan, 0.0)
            
            then("la facture est créée avec succès") {
                resultatFacture.Succès() shouldBe true
                
                resultatFacture.siSucces { facture -> 
                    facture.montant shouldBe 0.0 
                }
                
                resultatFacture.selon(
                    siEchec = { _ -> throw AssertionError("Devrait être une erreur") },
                    siSucces = { facture -> facture.montant shouldBe 0.0 }
                )
                
            }
        }
    }

    given("je suis admnistrateur") {

        val admin = Administrateur()

        `when`("le montant de la facture est 10000 €") {

            // driver choisi : le niveau de l'entité métier avec son vocabulaire métier en français
            val resultatFacture = Facture.creer(admin, 10000.0)


            then("") {

                resultatFacture.selon(
                    siEchec = { err -> err shouldBe "seul un artisan peut créer une facture" },
                    siSucces = { _ -> throw AssertionError("Devrait être une erreur") }
                )
            }
        }
})