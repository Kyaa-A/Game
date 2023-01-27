import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class testfile {
    static int pieceCount = 0;

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        boolean gameEnds = false;
        boolean others = true;

        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        System.out.print("[?] Would you like to play? Y/N: ");
        String playIdentifier = scan.nextLine();

        while (playIdentifier.equalsIgnoreCase("Y")) {
            while (!gameEnds) {

                printBoard(board);

                int playerTurn = 0;

                while (others) {
                    System.out.print("\n[?] Where would you like to play? (1-9): ");
                    playerTurn = scan.nextInt();
                    if (isValidMove(board, playerTurn)) {
                        break;
                    } else {
                        System.out.println("[!] " + playerTurn + " is not a valid move, re-enter number.");
                    }
                }

                char playerSymbol = 'X';
                switch (playerTurn) {
                    case 1:
                        board[0][0] = playerSymbol;
                        pieceCount++;
                        break;
                    case 2:
                        board[0][1] = playerSymbol;
                        pieceCount++;
                        break;
                    case 3:
                        board[0][2] = playerSymbol;
                        pieceCount++;
                        break;
                    case 4:
                        board[1][0] = playerSymbol;
                        pieceCount++;
                        break;
                    case 5:
                        board[1][1] = playerSymbol;
                        pieceCount++;
                        break;
                    case 6:
                        board[1][2] = playerSymbol;
                        pieceCount++;
                        break;
                    case 7:
                        board[2][0] = playerSymbol;
                        pieceCount++;
                        break;
                    case 8:
                        board[2][1] = playerSymbol;
                        pieceCount++;
                        break;
                    case 9:
                        board[2][2] = playerSymbol;
                        pieceCount++;
                        break;
                    default:
                        System.out.println("Invalid!");

                }
                Random rand = new Random();
                int computerTurn;
                while (true) {
                    computerTurn = rand.nextInt(9) + 1;
                    if (isValidMove(board, computerTurn)) {
                        break;
                    }
                }
                System.out.println("Computer chose " + computerTurn);
                char compSymbol = 'O';

                switch (computerTurn) {
                    case 1:
                        board[0][0] = compSymbol;
                        pieceCount++;
                        break;
                    case 2:
                        board[0][1] = compSymbol;
                        pieceCount++;
                        break;
                    case 3:
                        board[0][2] = compSymbol;
                        pieceCount++;
                        break;
                    case 4:
                        board[1][0] = compSymbol;
                        pieceCount++;
                        break;
                    case 5:
                        board[1][1] = compSymbol;
                        pieceCount++;
                        break;
                    case 6:
                        board[1][2] = compSymbol;
                        pieceCount++;
                        break;
                    case 7:
                        board[2][0] = compSymbol;
                        pieceCount++;
                        break;
                    case 8:
                        board[2][1] = compSymbol;
                        pieceCount++;
                        break;
                    case 9:
                        board[2][2] = compSymbol;
                        pieceCount++;
                        break;
                    default:
                        System.out.println("Invalid!");
                }

                String winner = "Draw";

                if ((board[0][0] == playerSymbol && board[0][1] == playerSymbol && board[0][2] == playerSymbol) ||
                        (board[1][0] == playerSymbol && board[1][1] == playerSymbol && board[1][2] == playerSymbol) ||
                        (board[2][0] == playerSymbol && board[2][1] == playerSymbol && board[2][2] == playerSymbol) ||

                        (board[0][0] == playerSymbol && board[1][0] == playerSymbol && board[2][0] == playerSymbol) ||
                        (board[0][1] == playerSymbol && board[1][1] == playerSymbol && board[2][1] == playerSymbol) ||
                        (board[0][2] == playerSymbol && board[1][2] == playerSymbol && board[2][2] == playerSymbol) ||

                        (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) ||
                        (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol)) {
                    printBoard(board);
                    winner = "Player";
                    System.out.println("\n-------------[ " + winner + " Wins! ]-----------");
                    gameEnds = true;

                } else if ((board[0][0] == compSymbol && board[0][1] == compSymbol && board[0][2] == compSymbol) ||
                        (board[1][0] == compSymbol && board[1][1] == playerSymbol && board[1][2] == playerSymbol) ||
                        (board[2][0] == compSymbol && board[2][1] == playerSymbol && board[2][2] == compSymbol) ||

                        (board[0][0] == compSymbol && board[1][0] == compSymbol && board[2][0] == compSymbol) ||
                        (board[0][1] == compSymbol && board[1][1] == compSymbol && board[2][1] == compSymbol) ||
                        (board[0][2] == compSymbol && board[1][2] == compSymbol && board[2][2] == compSymbol) ||

                        (board[0][0] == compSymbol && board[1][1] == compSymbol && board[2][2] == compSymbol) ||
                        (board[0][2] == compSymbol && board[1][1] == compSymbol && board[2][0] == compSymbol)) {
                    printBoard(board);
                    winner = "Computer";
                    System.out.println("\n------------[ " + winner + " Wins! ]----------");
                    gameEnds = true;
                } else if (pieceCount == 8 && winner.equals("Draw")) {
                    printBoard(board);
                    System.out.println("\n------------[ " + winner + "! ]-----------");
                    gameEnds = true;
                }
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("\n\t\t" + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("\t\t- + - + -");
        System.out.println("\t\t" + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("\t\t- + - + -");
        System.out.println("\t\t" + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    // Valid Move Identifier
    private static boolean isValidMove(char[][] board, int position) {

        switch (position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    // ClearScreen
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime();
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    // Time Reloader for Next Round
    private static void Reloader() throws InterruptedException {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("Something is wrong");
        }
    }
}