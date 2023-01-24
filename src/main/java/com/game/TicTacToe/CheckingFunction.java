package com.game.TicTacToe;

public class CheckingFunction {

    public enum GamesStatus {
    X_WON, O_WON, IN_PROGRESS;
    }


    public static GamesStatus calculateGameStatus(int[][] board, Board.Cell position) {

        int gameElement = board[position.row][position.column];

        if (gameElement == 0)
            return GamesStatus.IN_PROGRESS;

        boolean isCellOutOfBoard = (position.row-1 < 0);
        if (!isCellOutOfBoard && (board[position.row -1][position.column] == gameElement)){
            isCellOutOfBoard = (position.row-2 < 0);
            if (!isCellOutOfBoard && (board[position.row-2][position.column] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.row-1 < 0) || (position.column+1 > board[0].length-1);
        if (!isCellOutOfBoard && (board[position.row -1][position.column+1] == gameElement)) {
            isCellOutOfBoard = (position.row-2 < 0) || (position.column+2 > board[0].length-1);
            if (!isCellOutOfBoard && (board[position.row-2][position.column+2] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.column+1 > board[0].length-1);
        if (!isCellOutOfBoard && (board[position.row][position.column+1] == gameElement)) {
            isCellOutOfBoard = (position.column+2 > board[0].length-1);
            if (!isCellOutOfBoard && (board[position.row][position.column+2] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.row+1 > board.length-1) || (position.column+1 > board[0].length-1);
        if (!isCellOutOfBoard && (board[position.row+1][position.column+1] == gameElement)){
            isCellOutOfBoard = (position.row+2 > board.length-1) || (position.column+2 > board[0].length-1);
            if (!isCellOutOfBoard && (board[position.row+2][position.column+2] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.row+1 > board.length-1);
        if(!isCellOutOfBoard && (board[position.row+1][position.column] == gameElement)) {
            isCellOutOfBoard = (position.row+2 > board.length-1);
            if (!isCellOutOfBoard && (board[position.row+2][position.column] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.row+1 > board.length-1) || (position.column-1 < 0);
        if (!isCellOutOfBoard && (board[position.row+1][position.column] == gameElement)){
            isCellOutOfBoard = position.row+2 > board.length-1 || (position.column-2 < 0);
            if (!isCellOutOfBoard && (board[position.row+2][position.column-2] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.column-1 < 0);
        if (!isCellOutOfBoard && (board[position.row][position.column-1] == gameElement)){
            isCellOutOfBoard = (position.column - 2 < 0);
            if (!isCellOutOfBoard && (board[position.row][position.column - 2] == gameElement)) {
                return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
            }
        }

        isCellOutOfBoard = (position.row-1 < 0) || (position.column-1 < 0);
            if (!isCellOutOfBoard && (board[position.row-1][position.column-1] == gameElement)) {
                isCellOutOfBoard = (position.row - 2 < 0) || (position.column - 2 < 0);
                if (!isCellOutOfBoard && (board[position.row - 2][position.column - 2] == gameElement)) {
                    return gameElement == 1?GamesStatus.X_WON:GamesStatus.O_WON;
                }
            }
            return GamesStatus.IN_PROGRESS;
    }
    public static GamesStatus result(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                GamesStatus gameStatus = calculateGameStatus(board, new Board.Cell(row, column));
                if (gameStatus != GamesStatus.IN_PROGRESS) {
                    return gameStatus;
                }
            }
        }
        return GamesStatus.IN_PROGRESS;
    }
}
