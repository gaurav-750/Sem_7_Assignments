package Assignments;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int n = sc.nextInt();

            char[][] board = new char[n][n];
            for (char[] arr: board)
                Arrays.fill(arr, '.');

            nQueens(0, 0, n, board);


        }catch (InputMismatchException ime){
            System.out.println("Invalid Input! Please enter a number.");
        }finally {
            sc.close();
        }




    }

    private static void nQueens(int row, int col, int n, char[][] board) {
        //base case
        if (col >= n) return;
        if (row == n){
            printBoard(board);
            return;
        }


        //check if the queen can be placed here
        if (canQueenBePlacedHere(board, row, col, n)) {
            board[row][col] = 'Q';
            nQueens(row+1, 0, n, board);
        }

        board[row][col] = '.';
        nQueens(row, col+1, n, board); //next column
    }

    private static void printBoard(char[][] board) {
        //print chess board
        for (char[] arr: board){
            for (char c: arr)
                System.out.print(c + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean canQueenBePlacedHere(char[][] board, int row, int col, int n) {
        //check if there's any attack to the Queen if placed at chessBoard[row][col]
        //from up
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        //from left diagonal
        int i = row-1, j = col-1;
        while (i >= 0 && j >= 0){
            if (board[i][j] == 'Q')
                return false;
            i--; j--;
        }

        //from right diagonal
        i = row-1; j = col+1;
        while (i >= 0 && j < n){
            if (board[i][j] == 'Q')
                return false;
            i--; j++;
        }
        return true;
    }
}
