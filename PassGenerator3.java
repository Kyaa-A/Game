import java.util.Random;
import java.util.Scanner;

public class PassGenerator3 {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        boolean reset = false;

        System.out.println("[!] Your password must have at least 5 characters.");
        do {
            try {

                System.out.print("\n[?] How many characters do you want in your password? ");
                int length = scan.nextInt();

                char password[] = new char[length];


                if (length >= 5) {
                    for (int i = 0; i < length; i++) {
                        password[i] = character.charAt(rand.nextInt(character.length()));
                    }
                    System.out.println("\n=-=-=-=-=-=-=-[ Password ]-=-=-=-=-=-=-=");
                    System.out.print("[x] Here is your password: ");
                    System.out.println(password);
                    return;
                } else {
                    System.out.println("[!] Invalid length! must have atleast 5 characters.");
                    reset = true;
                }

            } catch (Exception e) {
                System.out.println("[!] Invalid! Input must be integer >:( ");
                reset = true;
                scan.nextLine();
            }
        } while (reset);
    }
}
