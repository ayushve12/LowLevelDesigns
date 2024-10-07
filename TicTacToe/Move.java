package LLD.TicTacToe;

public class Move {
    Player player;
    int []to = new int[2];

    public Move(Player player, int row, int column) {
        this.player = player;
        this.to[0]  = row;
        this.to[1]  = column;
    }

    public Move getMove() {
        return this;
    }

    public Player getPlayer() {
        return this.player;
    }
}
