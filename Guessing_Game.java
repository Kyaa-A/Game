import java.util.Scanner;
import java.util.Random;

public class Guessing_Game {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean win = false;
        int numTries = 0;
        String limiter = " ";

        System.out.println("[x] Computer has chosen a number");
        int numberToGuess = rand.nextInt(9) + 1;

        while (win == false) {

            System.out.print("\n[?] Guess a number from 1-9: ");
            int guess = scan.nextInt();

            numTries++;

            if (guess == numberToGuess) {
                System.out.println("\nYou did it!");
                win = true;
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high!");
                limiter = "lost";
            } else if (guess < numberToGuess) {
                System.out.println("Your guess is too low!");
                limiter = "lost";
            }

            if(numTries == 3 && limiter.equals("lost") ){
                System.out.println("\nYou lost!");
                break;
            }
        }

    }
}
