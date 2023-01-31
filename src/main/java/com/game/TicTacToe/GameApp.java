package com.game.TicTacToe;

import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("\nHello!!! Welcome to TicTacToe Game\n");
        System.out.println("Please enter the value of the board size to prepare: \n" +
                "3: -> 3 x 3 board\n" +
                "10: -> 10 x 10 board");

        int boardSize = in.nextInt();
        int winCondition = boardSize == 3 ? 3 : 5;
        char[][] board = new char[boardSize][boardSize];

        int gameMode;
        boolean cpuMode = false;

        String player2;

        while (true) {
            System.out.println("MENU\n" +
                    "select option\n" +
                    "0 - new game: player v player\n" +
                    "1 - new game: player v computer\n" +
                    "2 - quit game");

            do {
                gameMode = in.nextInt();
            } while (gameMode < 0 || gameMode > 3);
            if (gameMode == 2) {
                System.out.println("you are leaving the game! Good Bye!");
                System.exit(0);
            }

            if (gameMode == 0) {
                cpuMode = false;
            } else if (gameMode == 1) {
                cpuMode = true;
            }

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
                    System.out.println("It is turn (X):");
                } else {
                    System.out.println("It is turn (O):");
                }


                int row = 0;
                int column = 0;
                boolean keepLooking = true;

                while (keepLooking) {

                    if (!isPLayer1 && cpuMode) {
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[i].length; j++) {
                                if (board[i][j] == 0) {
                                    row = i;
                                    column = j;
                                    keepLooking = false;
                                    break;
                                }
                            }
                            if (!keepLooking) {
                                break;
                            }
                        }

                    } else {
                        System.out.println("please put row number");
                        row = new Scanner(System.in).nextInt();
                        System.out.println("please put column number");
                        column = new Scanner(System.in).nextInt();

                        if (row < 0 || column < 0 || row >= boardSize || column >= boardSize) {
                            System.out.println("Your row and column are out of range!");
                        } else if (board[row][column] != 0) {
                            System.out.println("Sorry, but this place is occupied.");
                        } else {
                            keepLooking = false;
                        }
                    }

                }

                board[row][column] = symbol;

                char result = hasWon(board, winCondition);
                if (result == 'X') {
                    System.out.println("Player with 'X' has won!!!!");
                    gameEnd = true;
                } else if (result == 'O') {
                    System.out.println("Player with 'O' has won!!!!");
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
    }

    public static char hasWon(char[][] board, int winCondition) {

        for (int i=0; i < board.length; i++) {
            char value1 = board[i][0];
            if (value1 != 0){
                int count = 1;
                for (int j=1; j < board.length; j++) {
                    if (board[i][j] != value1) {
                        break;
                    }else{
                        count++;
                        if(count == winCondition){
                            return value1;
                        }
                    }
                }
            }
        }

        for (int j=0; j < board.length; j++) {
            char value2 = board[0][j];
            if (value2 != 0) {
                int count = 1;
                for (int i = 1; i < board.length; i++) {
                    if (board[i][j] != value2) {
                        break;
                    } else {
                        count++;
                        if (count == winCondition) {
                            return value2;
                        }
                    }
                }
            }
        }

        char value3 = board[0][0];
        if (value3 != 0) {
           int count = 1;
           for (int i = 1; i < board.length; i++) {
                if (board[i][i] != value3) {
                    break;
                }else{
                    count++;
                    if (count == winCondition){
                        return value3;
                    }
                }
            }
        }

        char value4 = board[0][board[0].length - 1];
        if (value4 != 0) {
            for (int i = 1; i < board.length; i++) {
                int count = 1;
                if (board[i][board[0].length - 1 - i] != value4) {
                    break;
                }else{
                    count++;
                    if (count == winCondition) {
                        return value4;
                    }
                }
            }
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
