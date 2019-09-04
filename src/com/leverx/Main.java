package com.leverx;

import java.util.Scanner;

public class Main {
    private static final int SIZE_BOARD = 3;
    private static char[][] gameBoard = new char[SIZE_BOARD][SIZE_BOARD];

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Board newBoard = new Board();
        MovesUser user = new MovesUser();
        CheckWinner checkWinner = new CheckWinner();
        ArtificialIntelligence artificialIntelligence1 = new ArtificialIntelligence();

        System.out.println("---- TIC-TAC-TOE GAME!! ----\n");

        int switchSide = (int) Math.round(Math.random());
        char userSymbol;
        char compSymbol = (switchSide == 0) ? 'O' : 'X';
        if (compSymbol == 'O') {
            userSymbol = 'X';
        } else {
            userSymbol = 'O';
        }


        System.out.print("  Your opponent is human? ");
        boolean isOpponent = !scanner.next().toLowerCase().equals("y");

        int turn = (int) (Math.random() * 2);
        int cellCount = SIZE_BOARD * SIZE_BOARD;

        boolean isPlay = false;
        //-1-draw, 0-user, 1-computer
        int winner = -1;
        //drawing empty cells
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }

        while (!isPlay && cellCount > 0) {
            // flag to true if have a winner
            isPlay = checkWinner.isGameWon(gameBoard, userSymbol);

            if (isPlay) {
                winner = turn;
            } else {
                newBoard.showBoard((gameBoard));
                turn = (turn + 1) % 2;

                if (turn == 0) {
                    user.userPlay(gameBoard, userSymbol);
                } else {
                    if (isOpponent) {
                        artificialIntelligence1.compPlay(gameBoard, compSymbol);
                    } else {
                        user.userPlay(gameBoard, compSymbol);
                    }
                }
                cellCount--;
            }
        }
        newBoard.showBoard((gameBoard));
        if (winner == 0)
            System.out.println("\n---- " + userSymbol + " YOU WON!! ----");
        else if (winner == 1) {
            if (isOpponent) {
                System.out.println("\n---- " + userSymbol + " YOU LOST!! WON " + compSymbol + " ----");
            } else
                System.out.println("Won: " + compSymbol);
        } else
            System.out.println("\n---- DRAW!! ----");

    }
}
