package com.game.oldVersion;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner playerInput = new Scanner(System.in);

        Board board = new Board();
        board.boardInstruction();
        System.out.println(" ");
        boolean isGameInProgress = CheckingFunction.result(board.getBoard()) == CheckingFunction.GamesStatus.IN_PROGRESS;

        while (isGameInProgress && (!board.boardIsFull())) {

            System.out.println("PLayer1, please enter a position: ");
            int positionPlayer1 = Integer.parseInt(playerInput.nextLine());
            board.placeIndicatedByPlayer(positionPlayer1, "X");

            board.boardDisplay();
            System.out.println(" ");
            System.out.println("Player2, please enter a position: ");
            int positionPlayer2 = Integer.parseInt(playerInput.nextLine());
            board.placeIndicatedByPlayer(positionPlayer2, "O");
            board.boardDisplay();

            isGameInProgress = CheckingFunction.result(board.getBoard()) == CheckingFunction.GamesStatus.IN_PROGRESS;
        }
        board.boardDisplay();
        if(!isGameInProgress) {
            System.out.println("GAME OVER!!!");
        }
    }
}