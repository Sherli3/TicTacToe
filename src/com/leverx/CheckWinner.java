package com.leverx;

public class CheckWinner {
    public static boolean isGameWon(char[][] board, int turn, char userSymbol, char compOrUser2Symbol) {
        char symmetric;
        if (turn == 0)
            symmetric = userSymbol;
        else
            symmetric = compOrUser2Symbol;

        int i, j;
        boolean win = false;

        //win by row
        for (i = 0; i < board.length && !win; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] != symmetric)
                    break;
            }
            if (j == board[0].length)
                win = true;
        }

        // win by column
        for (j = 0; j < board[0].length && !win; j++) {
            for (i = 0; i < board.length; i++) {
                if (board[i][j] != symmetric)
                    break;
            }
            if (i == board.length)
                win = true;
        }

        // win by a diagonal (1)
        if (!win) {
            for (i = 0; i < board.length; i++) {
                if (board[i][i] != symmetric)
                    break;
            }
            if (i == board.length)
                win = true;
        }

        // win by a diagonal (2)
        if (!win) {
            for (i = 0; i < board.length; i++) {
                if (board[i][board.length - 1 - i] != symmetric)
                    break;
            }
            if (i == board.length)
                win = true;
        }
        return win;
    }

}
