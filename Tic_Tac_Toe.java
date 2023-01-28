import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe {

    static int pieceCount, playerTurn, computerTurn = 0;
    static char playerSymbol = 'X', compSymbol = 'O';
    static String winner = "Draw";
    static boolean gameEnds = false, fixedTrue = true;

    public static void main(String args[]) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        System.out.print("[?] Would you like to play? Y/N: ");
        String playIdentifier = scan.nextLine();

        while (playIdentifier.equalsIgnoreCase("Y")) {
            while (!gameEnds) {

                clear();

                printBoard(board);

                playerTurn(scan, fixedTrue, board);

                playerMove(board);

                computerTurn(rand, board);

                computerMove(board);

                gameMaster(board);

                Reloader();
            }
        }
    }

    private static void gameMaster(char[][] board) {

        if ((board[0][0] == playerSymbol && board[0][1] == playerSymbol && board[0][2] == playerSymbol) ||
                (board[1][0] == playerSymbol && board[1][1] == playerSymbol && board[1][2] == playerSymbol) ||
                (board[2][0] == playerSymbol && board[2][1] == playerSymbol && board[2][2] == playerSymbol) ||

                (board[0][0] == playerSymbol && board[1][0] == playerSymbol && board[2][0] == playerSymbol) ||
                (board[0][1] == playerSymbol && board[1][1] == playerSymbol && board[2][1] == playerSymbol) ||
                (board[0][2] == playerSymbol && board[1][2] == playerSymbol && board[2][2] == playerSymbol) ||

                (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) ||
                (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol)) {
            clear();
            printBoard(board);
            winner = "Player";
            System.out.println("\n---------------[ " + winner + "  Wins! ]-----------");
            gameEnds = true;

        } else if ((board[0][0] == compSymbol && board[0][1] == compSymbol && board[0][2] == compSymbol) ||
                (board[1][0] == compSymbol && board[1][1] == playerSymbol && board[1][2] == playerSymbol) ||
                (board[2][0] == compSymbol && board[2][1] == playerSymbol && board[2][2] == compSymbol) ||

                (board[0][0] == compSymbol && board[1][0] == compSymbol && board[2][0] == compSymbol) ||
                (board[0][1] == compSymbol && board[1][1] == compSymbol && board[2][1] == compSymbol) ||
                (board[0][2] == compSymbol && board[1][2] == compSymbol && board[2][2] == compSymbol) ||

                (board[0][0] == compSymbol && board[1][1] == compSymbol && board[2][2] == compSymbol) ||
                (board[0][2] == compSymbol && board[1][1] == compSymbol && board[2][0] == compSymbol)) {
            clear();
            printBoard(board);
            winner = "Computer";
            System.out.println("\n-------------[ " + winner + " Wins! ]----------");
            gameEnds = true;
        } else if (pieceCount == 8 && winner.equals("Draw")) {
            clear();
            printBoard(board);
            System.out.println("\n----------------[ " + winner + "! ]---------------");
            gameEnds = true;
        }
    }

    private static void computerMove(char[][] board) {
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
    }

    private static void computerTurn(Random rand, char[][] board) {
        while (true) {
            computerTurn = rand.nextInt(9) + 1;
            if (isValidMove(board, computerTurn)) {
                break;
            }
        }
        System.out.println("Computer chose " + computerTurn);
    }

    private static void playerMove(char[][] board) {
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
    }

    private static void playerTurn(Scanner scan, boolean fixedTrue, char[][] board) {
        while (fixedTrue) {
            System.out.print("\n[?] Where would you like to play? (1-9): ");
            playerTurn = scan.nextInt();
            if (isValidMove(board, playerTurn)) {
                break;
            } else {
                System.out.println("[!] " + playerTurn + " is not a valid move, re-enter number.");
            }
        }
    }

    private static void printBoard(char[][] board) {
       
        System.out.println("\n\t\t + - + - + - +");
        System.out.println("\t\t" + " | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | ");
        System.out.println("\t\t + - + - + - +");
        System.out.println("\t\t" + " | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | ");
        System.out.println("\t\t + - + - + - +");
        System.out.println("\t\t" + " | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | ");
        System.out.println("\t\t + - + - + - +");
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