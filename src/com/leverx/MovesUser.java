package com.leverx;

import java.util.Scanner;

public class MovesUser {
    public static Scanner scanner = new Scanner(System.in);
    public static void userPlay(char[][] board, char currentSymbol) {
        System.out.print("\n"+currentSymbol+", enter the row and column, please: ");

        int rowIndex = scanner.nextInt();
        int colIndex = scanner.nextInt();

        while (board[rowIndex][colIndex] != ' ') {
            System.out.print("\n!! The cell is already taken.\nEnter the row and column indices: ");
            rowIndex = scanner.nextInt();
            colIndex = scanner.nextInt();
        }

        board[rowIndex][colIndex] = currentSymbol;
    }
}
