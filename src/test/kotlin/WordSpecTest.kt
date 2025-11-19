import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class WordSpecTest : WordSpec({
    "a calculator" should {
        "add two numbers" {
            val result = 5 + 3
            result shouldBe 8
        }
        
        "multiply two numbers" {
            val result = 5 * 3
            result shouldBe 15
        }
    }
    
    "a string" should {
        "not be empty" {
            val text = "hello"
            text shouldNotBe ""
        }
        
        "have correct length" {
            "hello".length shouldBe 5
        }
    }
})
