package com.leverx;

public class Board {

    public void showBoard(char[][] board) {
        int numRow = board.length;
        int numCol = board[0].length;
        //number of horizontal
        System.out.println();
        System.out.print("    ");
        for (int i = 0; i < numCol; i++) {
            System.out.print(i + "   ");
        }
        System.out.println('\n');
        //vertically |
        for (int i = 0; i < numRow; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < numCol; j++) {//number of vertical
                if (j != 0)
                    System.out.print("|");
                System.out.print(" " + board[i][j] + " ");
            }

            System.out.println();
            //horizontal stripe
            if (i != (numRow - 1)) {
                System.out.print("   ");
                for (int j = 0; j < numCol; j++) {
                    if (j != 0) {
                        System.out.print("+");
                    }
                    System.out.print("---");
                }
                System.out.println();
            }
        }
    }
}
