import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

class DescribeSpecTest : DescribeSpec({
    describe("a string utility") {
        it("should concatenate strings") {
            val result = "hello" + " " + "world"
            result shouldBe "hello world"
        }
        
        context("when checking prefixes") {
            it("should start with expected prefix") {
                "hello world" shouldStartWith "hello"
            }
        }
    }
    
    describe("a number operation") {
        it("should add numbers correctly") {
            val sum = 10 + 5
            sum shouldBe 15
        }
    }
})
