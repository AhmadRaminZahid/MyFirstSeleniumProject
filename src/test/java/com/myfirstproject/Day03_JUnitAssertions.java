package com.myfirstproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day03_JUnitAssertions {

 /*
    What is assertion?
    Assertion is used to check the expected value against the actual value
   .Every test case MUST have an assertion
                expected = actual => PASS
                expected != actual => FAIL
    *************************************
    IN JUnit 5, we use Assertions class to verify the expected values against actual values
        Assertions.assertEquals
        Assertions.assertTrue
        Assertions.assertFalse
        Assertions.assertNUll

    ************************************
    These assertions are called HARD assertion.
    Because once assertion fails, it STOPS executing the remaining steps of the test case

     */

    @Test
    public void assertionsTest() {

        Assertions.assertEquals(5, 5);
        Assertions.assertEquals("Amazon", "Amazon");
        Assertions.assertEquals("amazon", "Amazon".toLowerCase());

        System.out.println("Line 34");

        Assertions.assertTrue(5 > 3);
        Assertions.assertTrue(true);
        Assertions.assertTrue("selenium".contains("e"));
        Assertions.assertTrue("apple".contains("a"));

        Assertions.assertFalse(4 > 9);
        Assertions.assertFalse("Java".contains("e"));

        String str = null;  // this null means the string is empty
//        String str = "null";  // this null means the string is not empty, it has word null inside
//        String str = "123";  // this means the string is not empty, it has some value inside
//        String str = "";  // this means the string is empty
//        String str = " ";  // this means the string is not empty because it has space in the middle

        Assertions.assertNull(str);
//        Assertions.assertNotNull(str);

        char[] arr1 = {'j', 'a', 'v', 'a'};
        char[] arr2 = "java".toCharArray();
        Assertions.assertArrayEquals(arr1, arr2);

    }
}