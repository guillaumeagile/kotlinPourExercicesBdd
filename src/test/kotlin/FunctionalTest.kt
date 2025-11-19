import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldContain

class FunctionalTest : FunSpec({
    test("simple assertion") {
        val result = 2 + 2
        result shouldBe 4
    }
    
    test("list operations") {
        val list = listOf(1, 2, 3, 4, 5)
        list shouldContain 3
    }
    
    context("nested context") {
        test("can group related tests") {
            val value = "hello"
            value.length shouldBe 5
        }
    }
})
