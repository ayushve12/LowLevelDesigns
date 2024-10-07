package LLD.TicTacToe;

public class Player extends Piece{
    String name;
    Player(String name, Symbol symbol) {
        super(symbol);
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
