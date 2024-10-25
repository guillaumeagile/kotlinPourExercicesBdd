package coffeeMachine

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.coffeeMachine.Drink
import org.example.coffeeMachine.MachineCafee

class MachineCafeeTests : BehaviorSpec({

    given("un machine à café") {

        val machine = MachineCafee()

        `when`("je demande un thé avec un sucre et une touillette") {

            var command = machine.Command( drink = Drink.Tea, sugar = 1, stick = 1 )

            then("le message est envoyé au Drink Maker") {

                command shouldBe "T:1:0"

            }
        }
    }
}
)

