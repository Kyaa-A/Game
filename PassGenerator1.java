import java.util.Random;

public class PassGenerator1 {
    public static void main(String[] args) {

        Random rand = new Random();
        char[] password = new char[8];
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        System.out.println("=-=-=-=-=-=-=-[ Password ]-=-=-=-=-=-=-=");
        try {
            System.out.print("[x] Here is your password :\t");
            for (int i = 0; i < password.length; i++) {
                password[i] = character.charAt(rand.nextInt(character.length()));
            }
            System.out.println(password);
        } catch (Exception e) {
            System.out.println("Invalid");
        }
    }
}