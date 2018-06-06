package com.felipemg.mysticsquare;

import java.util.Scanner;

public class Game {

    private static Board board;
    private static Board goalBoard;

    public static void main(String args[]){

        System.out.println("This is the Mystic Square Game.");
        System.out.println("Please write the size of the board.");

        Scanner userInput = new Scanner(System.in);
        int boardSize = Integer.parseInt(userInput.nextLine());

        System.out.println("input is '" + boardSize + "'");

        board = Board.of(boardSize);
        goalBoard = Board.goal(boardSize);

        System.out.println(board.toString());

        while(!board.equals(goalBoard)) {

            System.out.println("Enter the number of the piece to move:");
            String pieceNumber = userInput.nextLine();
            try {
                board.moveTile(pieceNumber);
                System.out.println(board.toString());
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        System.out.println("Congratulations, end of game");
    }

}
