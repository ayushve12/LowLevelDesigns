package LLD.TicTacToe;

import java.util.ArrayList;
import java.util.Scanner;
public class GameEngine {
    private static final int INVALID_MOVE_THRESHOLD = 5;
    Board board;
    int size;
    ArrayList<Player> players;
    ArrayList<Move> moves;

    Player winner;

    GameEngine(int size) {
        this.size = size;
        board = new Board(size);
        players = new ArrayList<Player>();
        moves = new ArrayList<Move>();
    }

    public void init() {
        resetGame();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void start() {
        // TODO: toss logic
        /* default start with player in List and alternate */
        //TODO checks before game starts
        // player 2 are there, assume true
        int index = 0;
        int invalidMove = 0;
        if (players.size() ==0) {
            System.out.println("Add players to play");
            return;
        }
        while (true) {
            board.printBoard();
            Scanner sc = new Scanner(System.in);
            System.out.print(players.get(index).getName()+ "'s Chance: ");
            int currentRow = sc.nextInt();
            int currentCol = sc.nextInt();
            boolean isValidMove = board.fillCell(currentRow, currentCol, players.get(index));

            // check move validity
            if (!isValidMove) {
                invalidMove++;
                System.out.println("Invalid move");
                if (invalidMove > INVALID_MOVE_THRESHOLD) {
                    System.out.println("invalidMove count exceeded threshold. Exiting Game.");
                    return;
                }
                continue;
            }

            moves.add(new Move(players.get(index), currentRow, currentCol));
            // check if someone won
            boolean gameWon = winningMoveCheck(players.get(index), currentRow, currentCol);
            if (gameWon) {
                winner = players.get(index);
                break;
            }

            // game ends if moves exhausted
            if (moves.size() >= size * size) {
                break;
            }
            index = (index + 1)%players.size();
        }

        //decision
        board.printBoard();
        if (winner != null) {
            System.out.println(winner.getName() + " wins with : " + winner.getSymbol());
        } else {
            System.out.println("Game's a Tie");
        }
    }

    public Player getWinner() {
        return winner;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void undoMove() {

    }

    public void resetGame() {
        winner = null;
        board.reset();
        players.clear();
        moves.clear();
    }

    private boolean winningMoveCheck(Player player, int row, int column) {
        //calc win logic here
        Symbol currentSymbol = player.getSymbol();

        Piece[][] currentBoard = board.getBoard();

        boolean wonCol = true, wonRow = true, wonDiagPrim = true, wonDiagNonPrim = true;
        for (int i=0; i<size; i++) {
            if (currentBoard[i][column] == null || currentBoard[i][column].getSymbol() != currentSymbol) {
                wonCol = false;
            }
            if (currentBoard[row][i] == null || currentBoard[row][i].getSymbol() != currentSymbol) {
                wonRow = false;
            }
            if (currentBoard[i][i] == null || currentBoard[i][i].getSymbol() != currentSymbol) {
                wonDiagPrim = false;
            }
            if (currentBoard[i][size - i - 1] == null || currentBoard[i][size - i - 1].getSymbol() != currentSymbol) {
                wonDiagNonPrim = false;
            }
        }
        return wonCol || wonRow || wonDiagNonPrim || wonDiagPrim;
    }

}
