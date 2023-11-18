package Assignments;

import java.util.Arrays;

//Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and
//bound strategy.
public class Knapsack {
    public static void main(String[] args) {

        int profits[] = {10,20,30};
        int weights[] = {1,1,1};

        int W = 2;
        int[][] dp = new int[profits.length][W+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

//        System.out.println("Knapsack Max Profit: " +
//                knapsack(W, weights, profits, 0, dp));

        System.out.println("Using Tabulation: " +
                knapsackUsingTabulation(W, weights, profits));


    }

    private static int knapsackUsingTabulation(int W, int[] weights, int[] profits) {
        int i, n = weights.length;
        int[][] dp = new int[n+1][W+1];

        for (i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i-1] <= W){
                    dp[i][w] = Math.max(
                            profits[i-1] + dp[i-1][w - weights[i-1]],
                            dp[i-1][w]
                    );
                }else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[n][W];
    }

    private static int knapsack(int W, int[] weights, int[] profits, int i, int[][] dp) {
        //base case
        if (W == 0 || i >= weights.length)
            return 0;

        if (dp[i][W] != -1)
            return dp[i][W];
//        System.out.println(i + "," + W);


        //if weight of current element is more than capacity W, skip
        if (weights[i] > W)
            return knapsack(W, weights, profits, i+1, dp);

        //the element's weight is <= W
        //so we'll either take it (or) skip it
        dp[i][W] = Math.max(
                profits[i] + knapsack(W - weights[i], weights, profits, i+1, dp), //take
                knapsack(W, weights, profits, i+1, dp));
        return dp[i][W];
    }
}