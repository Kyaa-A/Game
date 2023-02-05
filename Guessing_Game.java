import java.util.Scanner;
import java.util.Random;

public class Guessing_Game {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean win = false;

        System.out.println("[x] Computer has chosen a number");
        int numberToGuess = rand.nextInt(9) + 1;

        while (win == false) {

            System.out.print("[?] Guess a number from 1-9: ");
            int guess = scan.nextInt();
            if (guess == numberToGuess) {
                System.out.println("You did it!");
                win = true;
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high!");

            } else if (guess < numberToGuess) {
                System.out.println("Your guess is too low!");

            }

        }

    }

}
