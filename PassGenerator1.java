import java.util.Random;

public class PassGenerator1 {
    public static void main(String[] args) {
        
        Random rand = new Random();
        
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";
        int length = 8;

        char[] password = new char[length];

        try {
            
            System.out.print("[1] Here is your password:\t");
            for (int i = 0; i < password.length; i++) {
                password[i] = character.charAt(rand.nextInt(character.length()));
            }
            System.out.println(password);
        } catch (Exception e) {
            System.out.println("Invalid");
        }

    }
}