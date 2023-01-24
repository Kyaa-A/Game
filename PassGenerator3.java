import java.util.Random;
import java.util.Scanner;

public class PassGenerator3 {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 0;
        boolean reset = false;

        System.out.println("Your password must have at least 5 characters.");
        do {
            System.out.print("How many characters do you want in your password? ");
            length = scan.nextInt();

            char password[] = new char[length];

            if (length >= 5) {
                for (int i = 0; i < length; i++) {
                    password[i] = character.charAt(rand.nextInt(character.length()));
                }
                System.out.println("Here is your password: " + password);
            } else {
                System.out.println("Invalid length! must have atleast 5 characters.");
                reset = true;
            }

        } while (reset);
    }
}
