import java.util.Random;

public class testfile {
    public static void main(String[] args) {
        
        Random rand = new Random();
        
        for (int i = 0; i < 30; i++) {
            int randomizer = rand.nextInt(10)+5;
            System.out.print(randomizer + " ");
        }
    }
}
