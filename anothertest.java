import java.util.Random;

public class anothertest {
    public static void main(String[] args) {

        Random rand = new Random();
        /*
         * String name[] = { "Racho", "Kim", "Daclison" };
         * 
         * for (int i = 0; i < 10; i++) {
         * int randomizer = rand.nextInt(3);
         * System.out.print(name[randomizer] + " ");
         * }
         */
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println(character.charAt(rand.nextInt(character.length())));

    }
}