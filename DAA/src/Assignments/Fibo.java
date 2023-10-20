package Assignments;


//Write a program non-recursive and recursive program to calculate Fibonacci numbers and
//analyze their time and space complexity.
public class Fibo {
    public static void main(String[] args) {

        int n = 5;
        System.out.println("Recursive: " + recursiveFibo(n));
        System.out.println("Iterative: " + iterativeFibo(n));

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
