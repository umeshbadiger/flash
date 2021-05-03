package io.javabrains;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

	MathUtils utils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		utils = new MathUtils();
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
	}
	
	@Test
	@DisplayName("Adding two numbers")
	@Tag("Math")
	void test() {
		int expected = 2;
		int actual = utils.add(1, 1);
		assertEquals(expected, actual, "The add method should add two numbers");
	}
	
	@Test
	@Tag("Circle")
	void computeCircleRadius() {
		assertEquals(314.1592653589793, utils.computeCircleArea(10), "should return right circle area");
	}
	
	@Test
	@Tag("Math")
	void testDevide() {
		assertThrows(ArithmeticException.class, () -> utils.devide(1, 0), "Divide by zero should throw");
	}

	@Test
	@Disabled
	@DisplayName("TDD method should not run")
	void testDisabled() {
		fail("this test should be failed");
	}
	
	@Test
	@DisplayName("multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4, utils.multiply(2, 2)),
				() -> assertEquals(0, utils.multiply(0, 2)),
				() -> assertEquals(2, utils.multiply(-2, -1))
				);
	}
	
	
	
	
	
}
