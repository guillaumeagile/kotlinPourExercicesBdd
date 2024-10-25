package montaine.guillaume

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.montaine.guillaume.Boutique
import org.example.montaine.guillaume.Panier

class MontaineGuillaumeTest: BehaviorSpec({

    context("je veux vérifier les reductions par état et selon les montants") {

        given("j'ai un panier de 50 articles à 100$ ") {

            val panier = Panier(nombreArticle= 50, prixUnitaire= 100.0)

            and("la boutique est dans le névada ") {
                val boutique = Boutique(  Etat = "NV")

                `when` ("je passe à la caisse") {

                    val ticketDeCaisse = boutique.passeAlaCaisse(panier)

                    then(" j'ai une reduction de 5% " ){
                      ticketDeCaisse.Reduction shouldBe 5
                    }
                    then ( " mon prix est TTC 5130")
                    {
                        ticketDeCaisse.TotalTtc shouldBe 5130.0
                    }
                }
            }

        }
    }})