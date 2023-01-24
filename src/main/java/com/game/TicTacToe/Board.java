package com.game.TicTacToe;

public class Board {

    public static class Cell {
        public int row;
        public int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    public int[][] getBoard() {
        return board;
    }

    private int[][] board = new int[3][3];

    public void boardInstruction() {
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }

    public void boardDisplay() {

        System.out.println("| - | - | - |");
        System.out.println(boardRowDisplay(0));
        System.out.println("| - | - | - |");
        System.out.println(boardRowDisplay(1));
        System.out.println("| - | - | - |");
        System.out.println(boardRowDisplay(2));
        System.out.println("| - | - | - |");
    }

    private String boardRowDisplay(int row) {
        StringBuilder rowBuild = new StringBuilder("| ");
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 0) rowBuild.append(" ");
            if (board[row][i] == 1) rowBuild.append("X");
            if (board[row][i] == 2) rowBuild.append("O");
            rowBuild.append(" | ");
        }
        rowBuild.deleteCharAt(rowBuild.lastIndexOf(" "));
        return rowBuild.toString();
    }

    public boolean placeIndicatedByPlayer(int position, String typeXO) {
        int row = (position - 1) / 3;
        int column = (position - (row * 3)) - 1;

        if (board[row][column] == 0) {
            if (typeXO.equals("X")) board[row][column] = 1;
            if (typeXO.equals("O")) board[row][column] = 2;
            return true;
        }
        return false;
    }

    public boolean boardIsFull() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if(board[row][column] == 0)
                    return false;
            }
        }
        return true;
    }
}