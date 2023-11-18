package Assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

//Write a program non-recursive and recursive program to calculate Fibonacci numbers and
//analyze their time and space complexity.
public class Fibo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();

            System.out.println("Recursive: " + recursiveFibo(n));
            System.out.println("Iterative: " + iterativeFibo(n));
        }catch (InputMismatchException e){
            System.out.println("Invalid Input! Please enter a number.");
        }

    }

    private static int iterativeFibo(int n) {
        if (n == 0 || n == 1)
            return n;

        int prev = 1, previousPrev = 0, cur = 1;
        for (int i = 1; i < n; i++) {
            cur = prev + previousPrev;
            previousPrev = prev;
            prev = cur;
        }

        return cur;
    }

    private static int recursiveFibo(int n) {
        //base case
        if (n == 0 || n == 1)
            return n;

        return recursiveFibo(n-1) + recursiveFibo(n-2);
    }
}