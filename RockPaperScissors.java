import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int randomizer = rand.nextInt(3) + 1;
        String computerChoice = "";
        String playerChoice = "";
        boolean bool = true;

        System.out.println("Options to choose from:\n1. Rock\n2. Paper\n3. Scissors");

        System.out.println("\nThe Computer already made it's choice\n");

        do {
            System.out.print("Pick one that suits you: ");
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

        if (randomizer == 1) {
            computerChoice = "Rock";
        } else if (randomizer == 2) {
            computerChoice = "Paper";
        } else if (randomizer == 3) {
            computerChoice = "Scissors";
        }

        System.out.println("Computer choose: " + computerChoice);

        System.out.println();
        System.out.println(winner(playerChoice, computerChoice));

    }

    public static String winner(String playerChoice, String computerChoice) {

        String finalMessage = "";

        if (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) {
            finalMessage = "===Player Wins===";
        } else if (playerChoice.equals("Paper") && computerChoice.equals("Rock")) {
            finalMessage = "===Player Wins===";
        } else if (playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            finalMessage = "===Player Wins===";
        }

        if (computerChoice.equals("Rock") && playerChoice.equals("Scissors")) {
            finalMessage = "===Computer Wins===";
        } else if (computerChoice.equals("Paper") && playerChoice.equals("Rock")) {
            finalMessage = "===Computer Wins===";
        } else if (computerChoice.equals("Scissors") && playerChoice.equals("Paper")) {
            finalMessage = "===Computer Wins===";
        }

        for (int i = 0; i < 3; i++) {
            if (playerChoice.equals(computerChoice)) {
                finalMessage = "===Draw!===";
            }
        }

        return finalMessage;

    }
}
