# KoTest Spec Styles Guide

This guide explains the different test styles available in KoTest and when to use each one.

## Overview

KoTest provides multiple ways to structure tests, each with different syntax and use cases. Choose the style that best fits your project's needs.

---

## 1. BehaviorSpec (BDD Style)

**File**: `BddTest.kt`

**Structure**: Given/When/Then - ideal for Behavior-Driven Development

```kotlin
class BddTest : BehaviorSpec({
    Given("a user account with balance 100") {
        When("depositing 50") {
            Then("balance should be 150") {
                // assertion
            }
        }
    }
})
```

**When to use**:
- BDD workflows with clear business requirements
- Stakeholder-readable test descriptions
- Complex scenarios with multiple Given/When/Then blocks

---

## 2. FunSpec (Functional Style)

**File**: `FunctionalTest.kt`

**Structure**: Simple `test()` blocks with optional `context()` grouping

```kotlin
class FunctionalTest : FunSpec({
    test("simple assertion") {
        // test code
    }
    
    context("grouped tests") {
        test("nested test") {
            // test code
        }
    }
})
```

**When to use**:
- Simple, straightforward unit tests
- Functional programming style
- Quick test setup without ceremony

---

## 3. DescribeSpec

**File**: `DescribeSpecTest.kt`

**Structure**: `describe()` blocks with `it()` tests (similar to Jasmine)

```kotlin
class DescribeSpecTest : DescribeSpec({
    describe("a string utility") {
        it("should concatenate strings") {
            // test code
        }
        
        context("when checking prefixes") {
            it("should start with expected prefix") {
                // test code
            }
        }
    }
})
```

**When to use**:
- Organizing tests by feature or component
- Familiar syntax for developers from JavaScript/Jasmine background
- Hierarchical test organization

---

## 4. WordSpec

**File**: `WordSpecTest.kt`

**Structure**: Readable "should" syntax with infix notation

```kotlin
class WordSpecTest : WordSpec({
    "a calculator" should {
        "add two numbers" {
            // test code
        }
        
        "multiply two numbers" {
            // test code
        }
    }
})
```

**When to use**:
- Highly readable, natural language-like tests
- Documentation-style test names
- Teams that prioritize test readability

---

## 5. AnnotationSpec

**File**: `AnnotationSpecTest.kt`

**Structure**: Traditional JUnit-style with `@Test` annotations

```kotlin
class AnnotationSpecTest : AnnotationSpec() {
    @Test
    fun `should add two numbers correctly`() {
        // test code
    }
}
```

**When to use**:
- Migrating from JUnit
- Familiar with traditional test frameworks
- Simple, straightforward test structure
- Minimal setup overhead

---

## 6. ExampleSpec (Basic)

**File**: `ExampleTest.kt`

**Structure**: Simple BehaviorSpec example for quick reference

```kotlin
class ExampleTest : BehaviorSpec({
    Given("a simple example") {
        When("we check the value") {
            Then("it should equal 42") {
                // assertion
            }
        }
    }
})
```

---

## Matchers

All styles use the same matcher syntax:

```kotlin
value shouldBe 42
value shouldNotBe null
list shouldContain 3
text shouldStartWith "hello"
isEmpty shouldBe false
```

---

## Choosing a Style

| Style | Best For | Complexity |
|-------|----------|-----------|
| **BehaviorSpec** | BDD, business requirements | Medium |
| **FunSpec** | Simple tests, functional style | Low |
| **DescribeSpec** | Feature organization, Jasmine-like | Medium |
| **WordSpec** | Readable, natural language | Low |
| **AnnotationSpec** | JUnit migration, traditional | Low |

---

## Tips

- **Mix styles**: You can use different styles in different test files
- **Consistency**: Choose one primary style per project for consistency
- **Readability**: Prioritize test readability over cleverness
- **Nesting**: Most styles support nesting for logical grouping
- **Async**: All styles support async/coroutine testing with `suspend` functions

---

## References

### Official Documentation
- [KoTest Official Documentation](https://kotest.io/)
- [KoTest Spec Styles](https://kotest.io/docs/framework/testing-styles/index.html)
- [KoTest Matchers](https://kotest.io/docs/assertions/matchers/index.html)

### Related Resources
- [Arrow-kt Functional Programming](https://arrow-kt.io/) - Functional programming library used in this project
- [Kotlin Testing Best Practices](https://kotlinlang.org/docs/testing.html)
- [BDD with Cucumber and Kotlin](https://cucumber.io/docs/cucumber/)
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)

### Community
- [KoTest GitHub](https://github.com/kotest/kotest)
- [Kotlin Slack Community](https://kotlinlang.slack.com/)
- [Stack Overflow - KoTest Tag](https://stackoverflow.com/questions/tagged/kotest)
