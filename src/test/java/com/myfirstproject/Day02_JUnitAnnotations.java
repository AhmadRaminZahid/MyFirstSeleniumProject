package com.myfirstproject;

import org.junit.jupiter.api.*;

public class Day02_JUnitAnnotations {
    /*
    1. @Test: This is used to create Test Cases.
       This is the most commonly used annotation.

Note: All test methods should be void

2. @BeforeAll and  @AfterAll annotations run only ONCE at class level
3. @BeforeEach and @AfterEach annotations run before and after each test method
4. @Disabled annotation just makes that test case ignored for that run
     */
    @BeforeAll

    public static void setUpClass(){
        System.out.println("Before all class ... ");
    }
    @AfterAll
    public static void tearDownClass(){
        System.out.println("After all class ... ");
    }
    @BeforeEach
    public void setUpMethods(){
        System.out.println("Before each method... ");
    }

    @AfterEach
    public void tearDownMethods(){
        System.out.println("After each method ..... ");
    }

    @Test
    public void test1(){
        System.out.println("Test case 1.... ");
    }

    @Test
    public void test2(){
        System.out.println("Test case 2 ....");
    }


    @Test
    public void  test3(){
        System.out.println("Test case 3... ");
    }

    @Test
    public void test4(){
        System.out.println("Test case 4.... ");
    }

    @Test
    public void test5(){
        System.out.println("Test case 5 ....");
    }

    @Test
    public void  test6(){
        System.out.println("Test case 6... ");
    }


    }


