package com.leverx;

public class ArtificialIntelligence {
    // computer find the first empty
    public static void compPlay(char[][] board, char stepComp) {

        //check if need to break other player win
        char opponentSymbol = stepComp == 'x' ? 'o' : 'x';
        if (placeCharIfOnlyOneRest(board, opponentSymbol, stepComp)) {
            //attempted to prevent other player will finish line
            return;
        }
        if (placeCharIfOnlyOneRest(board, stepComp, stepComp)) {
            //finishing own line
            return;
        }
        //check center
        int cX = (int) Math.floor(board.length / 2d);
        int cY = (int) Math.floor(board[cX].length / 2d);
        if (placeIfEmpty(board, cX, cY, stepComp)) {
            return;
        }
        //check angles
        if (placeIfEmpty(board, 0, 0, stepComp)) {
            return;
        }
        if (placeIfEmpty(board, 0, 2, stepComp)) {
            return;
        }
        if (placeIfEmpty(board, 2, 0, stepComp)) {
            return;
        }
        if (placeIfEmpty(board, 2, 2, stepComp)) {
            return;
        }

        //fallback and take any free position
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (placeIfEmpty(board, i, j, stepComp)) {
                    return;
                }
            }
        }
        //  throw new RuntimeException("happening");
    }

    private static boolean placeIfEmpty(char[][] board, int x, int y, char symbol) {
        boolean isEmpty = false;
        if (board[x][y] == ' ') {
            board[x][y] = symbol;
            return isEmpty = true;
        } else {
            return isEmpty;
        }
    }

    private static boolean placeCharIfOnlyOneRest(char[][] board, char symbolToCheck, char symbolToPlace) {
        boolean isUnfinished = false;
        //rows
        for (int i = 0; i < board.length; i++) {
            int ch = checkOnlyOneRest(board[i][0], board[i][1], board[i][2], symbolToCheck);
            if (ch > -1) {
                board[i][ch] = symbolToPlace;
                isUnfinished = true;

            }
        }
        //columns
        for (int i = 0; i < board.length; i++) {
            int ch = checkOnlyOneRest(board[0][i], board[1][i], board[2][i], symbolToCheck);
            if (ch > -1) {
                board[ch][i] = symbolToPlace;
                isUnfinished = true;
            }
        }
        //diagonals
        int ch = checkOnlyOneRest(board[0][0], board[1][1], board[2][2], symbolToCheck);
        if (ch > -1) {
            board[ch][ch] = symbolToPlace;
            isUnfinished = true;
        }
        ch = checkOnlyOneRest(board[0][2], board[1][1], board[2][0], symbolToCheck);
        if (ch > -1) {
            board[ch][2 - ch] = symbolToPlace;
            isUnfinished = true;
        }
        //no unfinished lines, return false
        return isUnfinished;
    }

    private static int checkOnlyOneRest(char c0, char c1, char c2, char symbol) {
        if (c0 == symbol & c1 == symbol & c2 == ' ') {
            return 2;
        }
        if (c0 == symbol & c1 == ' ' & c2 == symbol) {
            return 1;
        }
        if (c0 == ' ' & c1 == symbol & c2 == symbol) {
            return 0;
        }
        return -1;
    }
}
