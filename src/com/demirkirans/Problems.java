package com.demirkirans;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.lang.Math;
import java.lang.IllegalArgumentException;

public class Problems {
    
    /**
     * checks if given list is a palindrome
     * @param list array of integer values to be checked 
     * @return true if given array is a palindrome
     */
    public static boolean isPalindrome(ArrayList<Integer> list) throws NoSuchElementException {
        int size = list.size();
        int firstPartitionLastIndex = 0;
        int secondPartitionFirstIndex = 0;

        //check if array is null
        if (size == 0) throw new NoSuchElementException("No element found in list");
        
        //check if the size is even or odd and take action based on this
        if (size % 2 == 0) {
            firstPartitionLastIndex = (size / 2) - 1;
            secondPartitionFirstIndex = (size / 2);
        }
        else {
            firstPartitionLastIndex = ((size - 1) / 2) - 1;
            secondPartitionFirstIndex = (size + 1) / 2;
        }

        //put first part into stack

        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i <= firstPartitionLastIndex; i++) {
            stack.push(list.get(i));
        }

        //now we filled in our stack, we will compare values one by one
        for (int i = secondPartitionFirstIndex; i < size; i++) {
            int top = stack.pop();
            if (top != list.get(i)) {
                System.out.println("List is not a palindrome");
                return false;
            }
        }
        return true;
    }

    /**
     * checks if fiven number is a prime number
     * @param x an integer number
     * @return true if given number is a prime number, false otherwise
     */
    public static boolean isPrime(int x) {
        if (x <= 1) throw new IllegalArgumentException();

        double checkUntil = Math.sqrt(x);

        for (int i = 2; i <= checkUntil; i++) {
            if (x % i == 0) return false; //its not a prime number
        }
        //if no divisible number found
        return true;
    }

    /**
     * prints fibonacci numbers less than given integer number
     * @param n an integer number
     */
    public static void printFibonacciNumbers(int n) {
        int temp = 0;
        int a = 0;
        int b = 1;

        System.out.println(a + ", ");

        while(b < n) {
            System.out.println(b + ", ");
            temp = b;
            b = a + b;
            a = temp;
            
        }
    }
}
