import java.util.Scanner;
import java.util.Random;

public class Name_Of_Fortune {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String[] studNames = listName();

        int randomizer = rand.nextInt(33);
        System.out.print("Do you want to spin? 1 = Y/ 2 = N: ");
        String spin = scan.nextLine();

        System.out.println("\n" + studNames[randomizer] + " will be Oral Reciting! ");
    }

    private static String[] listName() {
        String studNames[] = { "Ryan", "Ace", "Asnari", "Fernyl", "Arjay", "Prince", "Bueno", "Christian", "Rovic",
                "Renz", "Gwenn", "John Ghlen", "Stephen", "Angelyn", "Sophia", "Gretchel", "Aliazer", "Roderick",
                "Juana", "Christine", "Justine", "Fritzie", "Kenric", "Edsel", "Brent", "Nelven", "Khiane", "Nixel",
                "Mariano", "Rosalijos", "Allan", "Roel", "John Carlo" };
        return studNames;
    }
}
