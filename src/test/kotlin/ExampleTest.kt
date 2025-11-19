import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ExampleTest : BehaviorSpec({
    Given("a simple example") {
        val value = 42
        
        When("we check the value") {
            Then("it should equal 42") {
                value shouldBe 42
            }
        }
        
        When("we check it's not null") {
            Then("it should not be null") {
                value shouldNotBe null
            }
        }
    }
})
