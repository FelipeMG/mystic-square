package com.felipemg.mysticsquare;

import java.util.Scanner;

public class Game {

    private static Board board;

    public static void main(String args[]){

        System.out.println("This is the Mystic Square Game.");
        System.out.println("Please write the size of the board.");

        Scanner userInput = new Scanner(System.in);
        int boardSize = Integer.parseInt(userInput.nextLine());

        System.out.println("input is '" + boardSize + "'");

        board = Board.of(boardSize);

        System.out.println(board.toString());


        while(true) {

            System.out.println("Enter the number of the piece to move:");
            String pieceNumber = userInput.nextLine();
            board.moveTile(pieceNumber);
            System.out.println(board.toString());
        }
    }
}
