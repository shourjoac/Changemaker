//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tester class for the Changemaker class
// Course:   CS 300 Spring 2023
//
// Author:   Shourjo Aditya Chaudhuri
// Email:    sachaudhuri@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Swasti Singh
// Partner Email: sssingh4@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

/**
 * This class has six methods which tests whether each method present in the Changemaker class functions properly.
 */
public class ChangemakerTester {
    /**
     * This method checks the correctness of the base case in count method in the Changemaker class
     * <p>
     * Each test case checks a specific scenario:
     * Test case (1) when the value passed to "count" method is negative.
     * Test case (2) when there is no way to make change for the value passed to "count"
     * method.
     * Test case (3) when the value passed to "count" method is 0.
     * For each test case, the expected result is defined and compared to the actual result
     * returned by the "count" method. If the 2 values don't match then it returns false.
     *
     * @return true only if all scenarios pass, false otherwise
     */
    public static boolean testCountBase() {
        //(1) when the value is negative
        {
            int[] denominations = {1, 5, 10, 25};
            int[] coinsRemaining = {1, 2, 3, 4};
            int expected = 0;
            int actual = Changemaker.count(denominations, coinsRemaining, -3);
            if (expected != actual) {
                return false;
            }
        }
        //(2) when the value is positive but there is no way to make change
        {
            int[] denominations = {1, 5, 10, 25};
            int[] coinsRemaining = {0, 0, 0, 1};
            int expected = 0;
            int actual = Changemaker.count(denominations, coinsRemaining, 58);
            if (expected != actual) {
                return false;
            }
        }
        //(3) when the value is 0
        {
            int[] denominations = {1, 5, 10, 25};
            int[] coinsRemaining = {0, 0, 0, 2};
            int expected = 1;
            int actual = Changemaker.count(denominations, coinsRemaining, 0);
            if (expected != actual) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks how correct the recursive case in count method of the Changemaker
     * class is.
     * <p>
     * Each test case checks a specific scenario:
     * <p>
     * Test case (1) when there are at least three different coins used to make change.
     * Test case (2) when there are at least two different optimal ways to make change.
     * Test case (3) when greedily choosing the largest coin first does not produce a
     * result with the minimum number of coins.
     * For each test case, the expected result is defined and compared to the actual result
     * returned by the "count" method. If the two values are not equal, the method returns false
     *
     * @return true only if all scenarios pass, false otherwise
     */
    public static boolean testCountRecursive() {
        //(1) The scenario where there are at-least 3 different coins used to make change
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {1, 1, 1, 1};
            int expected = 6;
            int actual = Changemaker.count(denomination, coinsRemaining, 36);
            if (expected != actual) {
                return false;
            }
        }
        //(2) The scenario where there are at-least 2 different optimal ways to make change
        {
            int[] denomination = {2, 5, 7, 10};
            int[] coinsRemaining = {1, 1, 1, 1};
            int expected = 4;
            int actual = Changemaker.count(denomination, coinsRemaining, 12);
            if (expected != actual) {
                return false;
            }
        }
        //(3) The scenario where one greedily chooses the largest coin first and does not produce a result with
        // the minimum number of coins
        {
            {
                int[] denomination = {1, 5, 6, 9};
                int[] coinsRemaining = {2, 1, 1, 1};
                int expected = 5;
                int actual = Changemaker.count(denomination, coinsRemaining, 11);
                if (expected != actual) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks the correctness of the base case in minCoins method in the Changemaker
     * class
     * <p>
     * Each test case checks a specific scenario:
     * Test case (1) when the value passed to minCoins method is negative.
     * Test case (2) when there is no way to make change for the value passed to "minCoins"
     * method.
     * Test case (3) when the value passed to "minCoins" method is 0.
     * For each test case, the expected result is defined and compared to the actual result
     * returned by the "minCoins" method. If the 2 values don't match then it returns false.
     *
     * @return true only if all scenarios pass, false otherwise
     */
    public static boolean testMinCoinsBase() {
        //(1) when the value is negative
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {1, 2, 3, 4};
            int expected = -1;
            int actual = Changemaker.minCoins(denomination, coinsRemaining, -1);
            if (expected != actual) {
                return false;
            }
        }
        //(2) when the value is positive but there is no way to make change
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {0, 0, 0, 1};
            int expected = -1;
            int actual = Changemaker.minCoins(denomination, coinsRemaining, 50);
            if (expected != actual) {
                return false;
            }
        }
        //(3) when the value is 0
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {0, 0, 0, 2};
            int expected = 0;
            int actual = Changemaker.minCoins(denomination, coinsRemaining, 0);
            if (expected != actual) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks the correctness of the recursive case in minCoins method in the Changemaker
     * class.
     * <p>
     * Each test case checks a specific scenario:
     * <p>
     * Test case (1) when there are at least three different coins used to make change.
     * Test case (2) when there are at least two different ways to make change using the same
     * optimal number of coins.
     * Test case (3) when greedily choosing the largest coin first does not produce a
     * result with the minimum number of coins.
     * For each test case, the expected result is defined and compared to the actual result
     * returned by the "minCoins" method. If the two values are not equal, the method returns false
     *
     * @return true only if all scenarios pass, false otherwise
     */
    public static boolean testMinCoinsRecursive() {
        //(1) The scenario where there are at-least 3 different coins used to make change
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {1, 1, 1, 1};
            int expected = 3;
            int actual = Changemaker.minCoins(denomination, coinsRemaining, 36);
            if (expected != actual) {
                return false;
            }
        }
        //(2) The scenario where there are at-least 2 different ways to make change using the same optimal number
        // of coins
        {
            int[] denomination = {2, 5, 7, 10};
            int[] coinsRemaining = {1, 1, 1, 1};
            int expected = 2;
            int actual = Changemaker.minCoins(denomination, coinsRemaining, 12);
            if (expected != actual) {
                return false;
            }
        }
        //(3) The scenario where one greedily chooses the largest coin first and does not produce a result with
        //the minimum number of coins
        {
            {
                int[] denomination = {1, 5, 6, 9};
                int[] coinsRemaining = {2, 1, 1, 1};
                int expected = 2;
                int actual = Changemaker.minCoins(denomination, coinsRemaining, 11);
                if (expected != actual) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks the correctness of the base case in makeChange method in the Changemaker
     * class
     * <p>
     * Each test case checks a specific scenario:
     * Test case (1) when the value passed to makeChange method is negative.
     * Test case (2) nwhen there is no way to make change for the value passed to "makeChange"
     * method.
     * Test case (3) when the value passed to "makeChange" method is 0.
     * For each test case, the expected result is defined and compared to the actual result
     * returned by the "makeChange" method. If the 2 values don't match then it returns false.
     *
     * @return true only if all scenarios pass, false otherwise
     */
    public static boolean testMakeChangeBase() {
        //(1) when the value is negative
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {1, 2, 3, 4};
            int[] expected = null;
            int[] actual = Changemaker.makeChange(denomination, coinsRemaining, -1);
            if (!Arrays.equals(actual, expected)) {
                return false;
            }
        }
        //(2) when the value is positive but there is no way to make change
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {0, 0, 0, 1};
            int[] expected = null;
            int[] actual = Changemaker.makeChange(denomination, coinsRemaining, 50);
            if (!Arrays.equals(actual, expected)) {
                return false;
            }
        }
        //(3) when the value is 0
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {0, 0, 0, 2};
            int[] expected = {0, 0, 0, 0};
            int[] actual = Changemaker.makeChange(denomination, coinsRemaining, 0);
            if (!Arrays.equals(actual, expected)) {
                return false;
            }
            return true;
        }
    }

    /**
     * This method checks the correctness of the recursive case in makeChange method in
     * the Changemaker class.
     * Each test case checks a specific scenario:
     * <p>
     * Test case (1)  when there are at least three different coins used to make change.
     * Test case (2)  when there are at least two different ways to make change using the same
     * optimal number of coins.
     * Test case (3)  when always choosing the largest coin first does not produce a result
     * with the minimum number of coins used.
     * For each test case, the expected array is compared to the actual array
     * returned by the "makeChange" method. If the two arrays are not equal, the method returns false
     *
     * @return true only if all scenarios pass, false otherwise
     */
    public static boolean testMakeChangeRecursive() {
        //(1) The Scenario where there are at-least 3 different coins used to make change
        {
            int[] denomination = {1, 5, 10, 25};
            int[] coinsRemaining = {1, 1, 1, 1};
            int[] expected = {1, 1, 1, 0};
            int[] actual = Changemaker.makeChange(denomination, coinsRemaining, 16);
            if (!Arrays.equals(actual, expected)) {
                return false;
            }
        }
        //(2) The scenario where there are at-least 2 different ways to make change using the
        //same optimal number of coins
        {
            int[] denomination = {2, 5, 7, 10};
            int[] coinsRemaining = {1, 1, 1, 1};
            int[] expected = {0, 1, 1, 0};
            int[] expected2 = {1, 0, 0, 1};
            int[] actual = Changemaker.makeChange(denomination, coinsRemaining, 12);
            if (!(Arrays.equals(actual, expected) || Arrays.equals(actual, expected2))) {
                return false;
            }
        }
        //(3) The scenario in which always choosing the largest coin first does not produce a result
        // with the minimum number of coins used.
        {
            int[] denomination = {1, 5, 6, 9};
            int[] coinsRemaining = {2, 1, 1, 1};
            int[] expected = {0, 1, 1, 0};
            int[] actual = Changemaker.makeChange(denomination, coinsRemaining, 11);
            if (!Arrays.equals(actual, expected)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("Count Base: " + (testCountBase() ? "pass" : "X"));
        System.out.println("Count Recursive: " + (testCountRecursive() ? "pass" : "X"));
        System.out.println("Minimum Coins Base: " + (testMinCoinsBase() ? "pass" : "X"));
        System.out.println("Minimum Coins Recursive: " + (testMinCoinsRecursive() ? "pass" : "X"));
        System.out.println("Make Change Base: " + (testMakeChangeBase() ? "pass" : "X"));
        System.out.println("Make Change Recursive: " + (testMakeChangeRecursive() ? "pass" : "X"));
    }
}
