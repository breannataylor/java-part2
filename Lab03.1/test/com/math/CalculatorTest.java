/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
  //fixture: business object(s) under test
  private Calculator calc;

  @BeforeClass
  public static void initializedTestRun() {
    System.out.println("initializedTestRun");
  }

  @AfterClass
  public static void finalizedTestRun() {
    System.out.println("finalizedTestRun");
  }

  @Before
  public void setUp() {
    System.out.println("setUp");
    calc = new Calculator();
  }

  @After
  //purpose is to close down any files or databases opened in @Before
  public void tearDown() {
    System.out.println("tearDown");
  }

  @Test
  public void testIsEven() {
    System.out.println("testIsEven");

    assertTrue(calc.isEven(10));         //passes if boolean condition is true
    assertFalse(calc.isEven(11));       // passes if boolean condition is false
  }

  @Test
  public void testAdd() {
    System.out.println("testAdd");

    assertEquals(5, calc.add(1, 4));  // expected, actual
  }

  @Test
  public void testDivide() {
    System.out.println("testDivide");

    assertEquals(2.5, calc.divide(5, 2), .001);  //expected, actual, delta (intolerance)
  }
}