package coffeeMachine

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.coffeeMachine.Drink
import org.example.coffeeMachine.DrinkMachine

class MachineCafeeTests : BehaviorSpec({

    //GIVEN
    //WHEN
    //THEN
    given("une machine à café payante") {
        val machine = DrinkMachine(true )

        When("je met 1 euro dans la machine"){
            machine.InsertCoin(1.0 )

            And ("je demande un thé avec un sucre et une touillette") {
                var command = machine.Command( drink = Drink.Tea, sugar = 1, stick = 1 )

                then("le message est envoyé au Drink Maker") {
                    command shouldBe "T:1:1"
                }
            }
        }

        When("je met 0,1 euro dans la machine"){
            machine.InsertCoin(0.1)
            And("je demande un thé avec un sucre et une touillette") {
                var command = machine.Command( drink = Drink.Tea, sugar = 1, stick = 1 )

                then("le message est envoyé au Drink Maker") {

                    command shouldBe "M:not enough money"
                }
            }
        }
    }

    given("une machine à café") {

         val machine = DrinkMachine(false)

        `when`("je demande un thé avec un sucre et une touillette")  {

            var command = machine.Command( drink = Drink.Tea, sugar = 1, stick = 1 )

            then("le message est envoyé au Drink Maker") {

               command shouldBe "T:1:1"
            }
        }

        `when`("je demande un cHoco sans sucre et sans touillette") {

            var command = machine.Command( drink = Drink.Chocolate, sugar = 0, stick = 0 )

            then("le message est envoyé au Drink Maker") {

                command shouldBe "H::"

            }
        }

        // nouveau cas de vérification  "C:2:0" (Drink maker makes 1 coffee with 2 sugars and a stick)
       When("je demande un café avec 2 sucre et une touillette") {
         var command = machine.Command(Drink.Coffee, 2, 1  )

            then("le message est envoyé au Drink Maker") {

                command shouldBe "C:2:0"

            }
       }

        When("je demande un café avec 1 sucre et pas de touillette") {
            var command = machine.Command(Drink.Coffee, 1, 0  )

            then("le message est envoyé au Drink Maker") {

                command shouldBe "C:1:"

            }
        }

}

}
)

