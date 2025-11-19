import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class AnnotationSpecTest : AnnotationSpec() {
    
    @Test
    fun `should add two numbers correctly`() {
        val result = 5 + 3
        result shouldBe 8
    }
    
    @Test
    fun `should concatenate strings`() {
        val result = "hello" + " " + "world"
        result shouldContain "world"
    }
    
    @Test
    fun `should check list contains element`() {
        val list = listOf(1, 2, 3, 4, 5)
        list.contains(3) shouldBe true
    }
}
