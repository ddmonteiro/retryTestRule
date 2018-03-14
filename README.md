# retryTestRule
Retry TestRule to use in Junit assertions (e.g. UiAutomator, Appium, Espresso, etc)

Retry TestRule using @FlakyTest for JUnit (It also works with Espresso ViewAssertions)
==================

`@FlakyTest` annotation that adds retry logic to Junit tests, used for instance in UiAutomator, Appium, etc.



Usage
-----

In your test class, add the Retry Rule as a test rule, by creating
an instance of it as a public field with the number of attempts constant.

```java
@Rule 
public Retry retry = new RetryRule(Constants.NUMBER_ATTEMPTS);
```

If you prefer to use the annotation just simple uncomment the code in the BaseTest Retry method.

Then for any test that needs to implement retrying logic, annotate the method with `@FlakyTest`. 
You can customize the annotation that you want to use in the BaseTest class.

```java
@Test
@FlakyTest
public void test01_sample throws UiObjectionNotFoundException {
    
}
```
