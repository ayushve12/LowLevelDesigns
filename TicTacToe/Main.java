package LLD.TicTacToe;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTac Toe");

        Player p1 = new Player("Ayush", Symbol.X);
        Player p2 = new Player("Shubham", Symbol.O);

        GameEngine game = new GameEngine(3);
        game.init();
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.start();
    }
}
