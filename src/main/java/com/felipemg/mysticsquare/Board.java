package com.felipemg.mysticsquare;

import com.felipemg.util.Position;
import com.felipemg.util.Printer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class Board {

    private final Map<String, Position> tilesPosition;
    private final String[][] board;
    private final int size;

    private Board(int size){
        this.size = size;
        this.board = initializeBoard(size);
        this.tilesPosition = initializePositionMap(size);
    }

    public static Board of(int size){
        Board newBoard = new Board(size);
        return newBoard.disorderBoard();
    }

    public static Board goal(int size){
        return new Board(size);
    }

    private String[][] initializeBoard(int size){

        int number = 1;
        String[][] tiles = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tiles[row][col] = String.valueOf(number);
                ++number;
            }
        }
        tiles[size-1][size-1] = Printer.EMPTY_TILE;
        return tiles;
    }

    private Map<String, Position> initializePositionMap(int size){
        Map<String, Position> tilesPosition = new HashMap<String, Position>(size * size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tilesPosition.put(board[row][col],Position.of(row,col));
            }
        }
        return tilesPosition;
    }

    protected Position getPositionOfEmptyTile(){
        return tilesPosition.get(Printer.EMPTY_TILE);
    }

    public Board moveTile(String tileNumber){

        if (Integer.parseInt(tileNumber) >= (this.size * this.size) ){
            throw new IllegalArgumentException("Number is not valid");
        }

        Position numberPosition = tilesPosition.get(tileNumber);
        Position emptyTilePosition = getPositionOfEmptyTile();

        if (areAdjacentTiles(numberPosition,emptyTilePosition)){
            board[emptyTilePosition.getX()][emptyTilePosition.getY()] = tileNumber;
            board[numberPosition.getX()][numberPosition.getY()] = Printer.EMPTY_TILE;

            tilesPosition.put(tileNumber,getPositionOfEmptyTile());
            tilesPosition.put(Printer.EMPTY_TILE,numberPosition);
        }
        return this;
    }

    private boolean areAdjacentTiles(Position tile, Position emptyTile){
        return areAdjacentInX(tile, emptyTile) || areAdjacentInY(tile, emptyTile);

    }

    private boolean areAdjacentInY(Position tile, Position emptyTile) {
        return emptyTile.getY() == tile.getY() && (Math.abs(emptyTile.getX() - tile.getX()) == 1 );
    }

    private boolean areAdjacentInX(Position tile, Position emptyTile) {
        return emptyTile.getX() == tile.getX() && (Math.abs(emptyTile.getY() - tile.getY()) == 1 );
    }

    private Board disorderBoard(){
        this.moveTile(String.valueOf((size*size-1)));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                builder.append(Printer.TILE_SEPARATOR);
                builder.append(board[row][col]);
            }
            builder.append(Printer.TILE_SEPARATOR);
            builder.append(Printer.NEW_LINE);
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        if (size != board1.size) return false;
        return Arrays.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(board);
        result = 31 * result + size;
        return result;
    }
}
