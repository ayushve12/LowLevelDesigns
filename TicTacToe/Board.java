package LLD.TicTacToe;

public class Board {
    int size;
    Piece [][]board;
    Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }
    public Boolean fillCell(int row, int column, Piece piece) {
        if (!isExists(row, column)|| !isEmpty(row, column)) {
            return false;
        }
        board[row][column] = piece;
        return true;
    }
    private Boolean isEmpty(int row, int columns) {
        System.out.println(board[row][columns] == null?"EMPTY": "NOT EMPTTY");
        if (board[row][columns] == null)
            return true;
        return false;
    }

    private Boolean isExists(int row, int columns) {
        System.out.println(row + " " + columns + " "  + size);
        if (row >=0 && row < this.size && columns >=0 && columns < this.size)
            return true;
        return false;
    }

    public void reset() {
        for (int row=0; row< size; row++) {
            for (int column=0; column< size; column++) {
                board[row][column] = null;
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int row=0; row< size; row++) {
            for (int column=0; column< size; column++) {
                if (board[row][column] == null) {
                    System.out.print(" |");
                } else {
                    System.out.print(board[row][column].getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }
}
