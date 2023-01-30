package com.game.TicTacToe;

import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("\nHello!!! Welcome to TicTacToe Game\n");
        System.out.println("Please enter the value of the board size to prepare: \n"+
                "3: -> 3 x 3 board\n"+
                "10: -> 10 x 10 board");

        int boardSize = new Scanner(System.in).nextInt();
        char[][] board = new char[boardSize][boardSize];

        System.out.println("Player 1, what is Your name?");
        String player1 = in.nextLine();
        System.out.println();
        System.out.println("Player 2, what is Your name?");
        String player2 = in.nextLine();
        System.out.println();

        boolean isPLayer1 = true;
        boolean gameEnd = false;
        while (!gameEnd) {

            printGameBoard(board);

            char symbol = ' ';
            if (isPLayer1) {
                symbol = 'X';
            } else {
                symbol = 'O';
            }

            if (isPLayer1) {
                System.out.println("It is " + player1 + " turn (X):");
            } else {
                System.out.println("It is " + player2 + " turn (O):");
            }


            int row = 0;
            int column = 0;

            while (true) {
                System.out.println("please put row number");
                row = new Scanner(System.in).nextInt();
                System.out.println("please put column number");
                column = new Scanner(System.in).nextInt();

                if (row < 0 || column < 0 || row >= boardSize || column >= boardSize) {
                    System.out.println("Your row and column are out of range!");
                } else if (board[row][column] != 0) {
                    System.out.println("Sorry, but this place is occupied.");
                } else {
                    break;
                }
            }
            board[row][column] = symbol;

            if (hasWon(board) == 'X') {
                System.out.println(player1 + " has won!!!!");
                gameEnd = true;
            } else if (hasWon(board) == 'O') {
                System.out.println(player2 + " has won!!!!");
                gameEnd = true;
            } else {
                if (isTie(board)) {
                    System.out.println("It is Tie!");
                    gameEnd = true;
                } else {
                    isPLayer1 = !isPLayer1;
                }
            }
        }
        printGameBoard(board);
        System.out.println();
        System.out.println("###GAME OVER###");
    }

    public static char hasWon(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            boolean inLine = true;
            char value1 = board[i][0];
            if (value1 == 0) {
                inLine = false;
            } else {
                for (int j = 1; j < board.length; j++) {
                    if (board[i][j] != value1) {
                        inLine = false;
                        break;
                    }
                }
            }
            if (inLine) {
                return value1;
            }
        }

        for (int j = 0; j < board.length; j++) {
            boolean inColumn = true;
            char value2 = board[0][j];
            if (value2 == 0) {
                inColumn = false;
            } else {
                for (int i = 1; i < board.length; i++) {
                    if (board[i][j] != value2) {
                        inColumn = false;
                        break;
                    }
                }
            }
            if (inColumn) {
                return value2;
            }
        }
        boolean checkDiagonal1 = true;
        char value3 = board[0][0];
        if (value3 == 0) {
            checkDiagonal1 = false;
        } else {
            for (int i = 1; i < board.length; i++) {
                if (board[i][i] != value3) {
                    checkDiagonal1 = false;
                    break;
                }
            }
        }
        if (checkDiagonal1) {
            return value3;
        }

        boolean checkDiagonal2 = true;
        char value4 = board[0][board[0].length - 1];
        if (value4 == 0) {
            checkDiagonal2 = false;
        } else {
            for (int i = 1; i < board.length; i++) {
                if (board[i][board[0].length - 1 - i] != value4) {
                    checkDiagonal2 = false;
                    break;
                }
            }
        }
        if (checkDiagonal2) {
            return value4;
        }
        return 0;
    }

    static void printGameBoard(char[][] board) {
        int boardSize = board.length;

        System.out.print("\t");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int row = 0; row < boardSize; row++) {
            System.out.print(row + ":\t");
            for (int column = 0; column < boardSize; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean isTie(char[][] board) {
        for (int i =0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
