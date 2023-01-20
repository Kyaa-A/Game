import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Tic_Tac_Toe {
    public static void main(String[] args) throws InterruptedException {

        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };
        Scanner scan = new Scanner(System.in);
        boolean gameEnds = false;

        System.out.print("Would you like to play? Y/N: ");
        String playIdentifier = scan.nextLine();

        while (playIdentifier.equalsIgnoreCase("Y")) {
            while (!gameEnds) {

                clear();
                
                printBoard(board);

                winnerIdentifier(board, gameEnds);

                playerTurn(board, scan);

                computerTurn(board);

                Reloader();
            }
        }

    }

    // Print Board
    private static void printBoard(char[][] board) {
        System.out.println("\n\t\t" + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("\t\t- + - + -");
        System.out.println("\t\t" + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("\t\t- + - + -");
        System.out.println("\t\t" + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    // Player Turn
    private static void playerTurn(char[][] board, Scanner scan) {

        int playerTurn;
        while (true) {
            System.out.print("\n[ Where would you like to play? ] (1-9): ");
            playerTurn = scan.nextInt();
            if (isValidMove(board, playerTurn)) {
                break;
            } else {
                System.out.println(playerTurn + " is not a valid move.");
            }
        }
        placeMove(board, playerTurn, 'X');
    }

    // Computer Turn
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerTurn;
        while (true) {
            computerTurn = rand.nextInt(9) + 1;
            if (isValidMove(board, computerTurn)) {
                break;
            }
        }
        System.out.println("Computer chose " + computerTurn);
        placeMove(board, computerTurn, 'O');
    }

    // Scoring Identifier
    private static boolean scoringIdentifier(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    // Winner Identifier
    private static boolean winnerIdentifier(char[][] board, boolean gameEnds) {

        if (scoringIdentifier(board, 'X')) {
            System.out.println("\n-------------[ Player Wins! ]-----------");
        } 
        if (scoringIdentifier(board, 'O')) {
            System.out.println("\n------------[ Computer Wins! ]----------");
        }
        return gameEnds = true;
    }

    // Move Identifier
    private static void placeMove(char[][] board, int position, char symbol) {
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid!");
        }
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