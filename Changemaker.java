//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Changemaker P06
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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class simulates a cash register dispensing change to a customer.
 *
 * @author Shourjo Aditya Chaudhuri and Swasti Singh
 */
public class Changemaker {
    /**
     * This method returns the number of possible ways to make change for a specified value
     * with a limited amount of coins of different denominations.
     *
     * @param denominations  array describing the value of each type of coin in the register
     * @param coinsRemaining array describing the quantity of each type of coin in the register
     * @param value          the total amount of change to be dispensed to the customer
     * @return the number of possible ways to make change for a given
     * value with a limited number of coins of varying denominations.
     * 0 if the value is negative or there are not enough coins.
     * 1 if there is a condition to dispense no coins, hence there being only one way possible
     */
    public static int count(int[] denominations, int[] coinsRemaining, int value) {

        //there is no way to make change if there are not enough coins,
        if ((denominations.length == 0) || (coinsRemaining.length == 0))
            return 0;
        //there is no way to make change if the value is negative
        if (value < 0)
            return 0;
        //there is only one way to make change if the value is 0
        if (value == 0)
            //dispensing no coins is "one" way to make change
            return 1;

        int numberOfWays = 0; //variable describing the number of possible ways to make change
        for (int i = 0; i < denominations.length; i++) { //iterates through all the indexes of the denominations array
            if (value >= denominations[i] && coinsRemaining[i] > 0) {
                //checks if the value is greater than or equal to the denomination
                //checks if there are coins remaining for that denomination.
                coinsRemaining[i]--; //decrements the number of remaining coins for that specific denomination
                numberOfWays += count(denominations, coinsRemaining,
                        value - denominations[i]); // recursively calls itself using the updated value argument
                coinsRemaining[i]++; //increments the number of remaining coins for that specific denomination
            }
        }
        return numberOfWays; //returns the number of ways
    }

    /**
     * This method returns the minimum total number of coins needed to make change for the
     * given value using a limited number of coins of various denominations. If there is no way to make
     * change using the given coins the method should return -1. If it is possible to make a change
     * using no coins then the method returns 0.
     *
     * @param denominations  array describing the value of each type of coin in the register
     * @param coinsRemaining array describing the quantity of each type of coin in the register
     * @param value          the total amount of change to be dispensed to the customer
     * @return the minimum total number of coins needed to make change for the
     * given value using a limited number of coins of various denominations.
     * -1 If there is no way to make change using the given coins.
     * 0 If it is possible to make a change using no coins
     */
    public static int minCoins(int[] denominations, int[] coinsRemaining, int value) {
        // checks if the value is negative and there is no way to make change using the given coins
        if (value < 0) {
            return -1;
        }
        // checks if the value is 0 there is no way to make change
        if (value == 0) {
            return 0;
        }
        int minNumberCoins = Integer.MAX_VALUE;
        for (int i = 0; i < denominations.length; i++) { //iterates over the denominations array
            if (coinsRemaining[i] > 0 && denominations[i] <= value) {
                //checks if there are coins remaining for that denomination
                //checks if the denomination is less than or equal to the remaining value
                coinsRemaining[i]--; //decrements the number of remaining coins for that specific denomination
                int min = minCoins(denominations, coinsRemaining,
                        value - denominations[i]); //recursively calls minCoins with the new updated value
                if (min != -1) {
                    //checks for valid solution
                    minNumberCoins = Math.min(minNumberCoins, min + 1);
                }
                coinsRemaining[i]++; //increments the number of remaining coins for that specific denomination
            }
        }
        return (minNumberCoins == Integer.MAX_VALUE) ? -1 : minNumberCoins;
    }

    /**
     * This method tells the number of coins of each denomination that are used
     * by computing an array representing the exact number of each type of coin
     * needed to make change optimally.
     *
     * @param denominations  array describing the value of each type of coin in the register
     * @param coinsRemaining array describing the quantity of each type of coin in the register
     * @param value          the total amount of change to be dispensed to the customer
     * @return array of the same length as the denominations and coinsRemaining arrays,
     * where the value at index represents how many coins of the corresponding
     * value denominations were selected
     * If there are multiple different ways to make change using the same optimal total number of coins, you
     * can return an arbitrary solution among them
     * If no way to make change, return null
     * If value=0, returns an array filled with 0
     */
    public static int[] makeChange(int[] denominations, int[] coinsRemaining, int value) {
        //checks if the value is greater than 0
        if (value < 0) {
            return null;
        }
        //checks if the value is zero
        if (value == 0) {
            return new int[denominations.length];
        }
        int[] minimumChange = null;
        for (int i = 0; i < denominations.length; i++) { //iterates over each specific denomination in the array
            if (coinsRemaining[i] > 0 && value >= denominations[i]) { //checks if there are coins remaining for that denomination and if the denomination is less than or equal to the remaining value.
                coinsRemaining[i]--; //decrements
                int[] change = makeChange(denominations, coinsRemaining,
                        value - denominations[i]); //recursively calls makeChange() with the new value
                if (change != null) {
                    change[i]++; // increments
                    if (minimumChange == null || Arrays.stream(change).sum() < Arrays.stream(minimumChange)
                            .sum()) {
                        minimumChange =
                                change; //the minimum combination of coins required to make change
                    }
                }
                coinsRemaining[i]++; //increments
            }
        }
        return minimumChange;
    }
}