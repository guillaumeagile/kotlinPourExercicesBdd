import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BddTest : BehaviorSpec({
    Given("a user account with balance 100") {
        var balance = 100
        
        When("depositing 50") {
            balance += 50
            
            Then("balance should be 150") {
                balance shouldBe 150
            }
        }
    }
    
    Given("a string") {
        val text = "hello"
        
        When("checking if empty") {
            val isEmpty = text.isEmpty()
            
            Then("it should not be empty") {
                isEmpty shouldBe false
            }
        }
    }
    
    Given("a list of numbers") {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        
        When("filtering even numbers") {
            val evens = numbers.filter { it % 2 == 0 }
            
            Then("result should contain only evens") {
                evens shouldBe listOf(2, 4, 6)
            }
        }
    }
})
