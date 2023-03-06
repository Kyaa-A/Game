import java.util.Scanner;
import java.util.Random;

public class Name_Of_Fortune {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String[] studNames = listName();
        boolean valid = false;

        do {
            valid = true;
            try {
                System.out.print("[!] Do you want to spin?\n\t1 = Y\n\t2 = N\nSelect one: ");
                int spin = scan.nextInt();

                if (spin == 1) {
                    System.out.println("\n[ " + studNames[rand.nextInt(33)] + " will be Oral Reciting! ]");
                }
                valid = false;
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("[!] Invalid Input, Please Try Again\n");
                valid = true;
            }
        } while (valid);
    }

    private static String[] listName() {
        String studNames[] = { "Ryan", "Ace", "Asnari", "Fernyl", "Arjay", "Prince", "Bueno", "Christian", "Rovic",
                "Renz", "Gwenn", "John Ghlen", "Stephen", "Angelyn", "Sophia", "Gretchel", "Aliazer", "Roderick",
                "Juana", "Christine", "Justine", "Fritzie", "Kenric", "Edsel", "Brent", "Nelven", "Khiane", "Nixel",
                "Mariano", "Rosalijos", "Allan", "Roel", "John Carlo" };
        return studNames;
    }
}
