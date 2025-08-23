package weddingPlanner.TenueDeMaries

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TenuesSpecificationsExecutables : BehaviorSpec({

    //user story
    //en tant que futur epoux-se, je souhaite obtenir une tenue afin de participer à la"
    //            "cérémonie de mariage

    //regle
    // le prix de la robe plus costume doit etre inférieur à 10% du budget total

    context("le prix de la robe plus costume doit etre inférieur à 10% du budget local") {

        given("le couple défini un budget total de 15000€") {

            val budgetTotal = 15000

            and("le prix de la robe est de 1000€ ") {

                val prixDeLaRobe = 1000

                `when` ("je veux savoir quel est le prix maximum pour le costume ") {

                    val prixMaximumCostume = CalculPrixCostume(prixDeLaRobe , budgetTotal)

                    then("le résultat est 500€" ){
                        prixMaximumCostume shouldBe 500
                    }
                }
            }

            and("le prix de la robe est de 1250€ ") {

                val prixDeLaRobe = 1250

                `when` ("je veux savoir quel est le prix maximum pour le costume ") {

                    val prixMaximumCostume = CalculPrixCostume(prixDeLaRobe , budgetTotal)

                    then("le résultat est 250" ){
                        prixMaximumCostume shouldBe 250
                    }
                }
            }
        }

        given("le couple défini un budget total de 20000€") {

            val budgetTotal = 20000

            and("le prix de la robe est de 1500€") {

                val prixDeLaRobe = 1500

                `when` ("je veux savoir quel est le prix maximum pour le costume ") {

                    val prixMaximumCostume = CalculPrixCostume(prixDeLaRobe , budgetTotal)

                    then("le résultat est 500€" ){
                        prixMaximumCostume shouldBe 500
                    }
                }
            }


            and("le prix de la robe est de 2100€") {
                val prixDeLaRobe = 2100

                `when` ("je veux savoir quel est le prix maximum pour le costume ") {

                    val prixMaximumCostume = CalculPrixCostume(prixDeLaRobe , budgetTotal)

                    then("le résultat est 0€" ){
                        prixMaximumCostume shouldBe 0
                    }
                }
            }

            and("le prix de la robe est de 2100€") {
                val prixDeLaRobe = 2100

                `when` ("je veux savoir si le prix de la robe rentre dans le budget") {

                    val resultat = ValideLePrixDeLaRobe(prixDeLaRobe , budgetTotal)

                    then("le résultat est NO WAY" ){
                        resultat shouldBe false
                    }
                }
            }

            and("le prix de la robe est de 1900") {
                val prixDeLaRobe = 1900

                `when` ("je veux savoir si le prix de la robe rentre dans le budget") {

                    val resultat = ValideLePrixDeLaRobe(prixDeLaRobe , budgetTotal)

                    then("le résultat est 'ca paaaaasse'" ){
                        resultat shouldBe true
                    }
                }
            }

        }
    }})

fun ValideLePrixDeLaRobe(prixDeLaRobe: Int, budgetTotal: Int): Boolean {
  return  prixDeLaRobe < budgetTotal * 0.1
}


fun CalculPrixCostume(prixDeLaRobe: Int, budgetTotal: Int): Int {
    return  Math.max(  (budgetTotal * 0.1).toInt() - prixDeLaRobe, 0)
}
