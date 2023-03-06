import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Rock_Paper_Scissors {

    static String playerChoice = " ";
    static String computerChoice = "";
    static int playerPoints = 0;
    static int computerPoints = 0;
    static boolean bool = true;
    static boolean gameEnds = false;

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("[?] Want to play Rock, Paper, Scissor? Y/N: ");
        String playIdentifier = scan.nextLine();

        while (playIdentifier.equalsIgnoreCase("Y")) {

            while (!gameEnds) {

                clear();

                System.out.println("\n[!] Options to choose from:\n1. Rock\n2. Paper\n3. Scissors");
                System.out.println("\n[!] The Computer already made it's choice");

                playerTurn(scan);

                computerTurn(rand);

                System.out.println("\n" + scoringIdentifier(playerChoice, computerChoice));

                winnerIdentifier();

                Reloader();
            }

        }

    }

    // Player Turn
    private static void playerTurn(Scanner scan) {
        do {
            System.out.print("[x] Pick one that suits you: ");
            int playerTurn = scan.nextInt();
            System.out.println();

            if (playerTurn == 1) {
                playerChoice = "Rock";
                bool = true;
            } else if (playerTurn == 2) {
                playerChoice = "Paper";
                bool = true;
            } else if (playerTurn == 3) {
                playerChoice = "Scissors";
                bool = true;
            } else {
                System.out.println("Invalid");
                bool = false;
            }
        } while (!bool);

        System.out.println("You choose: " + playerChoice);
    }

    // Computer Turn
    private static void computerTurn(Random rand) {
        int randomizer = rand.nextInt(3) + 1;
        if (randomizer == 1) {
            computerChoice = "Rock";
        } else if (randomizer == 2) {
            computerChoice = "Paper";
        } else if (randomizer == 3) {
            computerChoice = "Scissors";
        }
        System.out.println("Computer choose: " + computerChoice);
    }

    // Scoring Identifier
    public static String scoringIdentifier(String playerChoice, String computerChoice) {

        String finalMessage = "";

        if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            finalMessage = "-------------Player Scored-------------";
            playerPoints++;
        }
        
        if ((computerChoice.equals("Rock") && playerChoice.equals("Scissors")) ||
                (computerChoice.equals("Paper") && playerChoice.equals("Rock")) ||
                (computerChoice.equals("Scissors") && playerChoice.equals("Paper"))) {
            finalMessage = "------------Computer Scored------------";
            computerPoints++;
        }

        for (int i = 0; i < 3; i++) {
            if (playerChoice.equals(computerChoice)) {
                finalMessage = "-----------------Draw!-----------------";
            }
        }

        return finalMessage;
    }

    // Winner Identifier
    public static void winnerIdentifier() {
        System.out.println("| Player Score: " + playerPoints + " | Computer Score: " + computerPoints + " |");
        if (playerPoints == 5) {
            System.out.println("------------[ Player Wins! ]-----------");
            gameEnds = true;
        } else if (computerPoints == 5) {
            System.out.println("-----------[ Computer Wins! ]----------");
            gameEnds = true;
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