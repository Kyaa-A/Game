import java.util.Random;

public class PassGenerator2 {
    public static void main(String[] args) {

        Random rand = new Random();

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = upperCase.toLowerCase();

        char upperChar[] = new char[1];
        char lowerChar[] = new char[5];
        try {
            System.out.print("Here is your password:\t");
            // 2 Numbers
            for (int i = 0; i < 2; i++) {
                int randomizer = rand.nextInt(9);
                System.out.print(randomizer);
            }
            // 1 Uppercase Letter
            for (int i = 0; i < 1; i++) {
                upperChar[i] = upperCase.charAt(rand.nextInt(upperCase.length()));
                System.out.print(upperChar[i]);
            }
            // 5 Lowercase Letter
            for (int i = 0; i < 5; i++) {
                lowerChar[i] = lowerCase.charAt(rand.nextInt(lowerCase.length()));
                System.out.print(lowerChar[i]);
            }

        } catch (Exception e) {
            System.out.println("Invalid");
        }
        System.out.println();
    }
}
