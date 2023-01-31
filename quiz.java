import javax.sound.midi.Soundbank;

public class quiz {
    public static void main(String[] args) {

        int[][] items = { { 0, 1, 3, 4 },
                { 4, 3, 99, 0, 7 },
                { 3, 2 } };

        int[] temp = { 8, 12, 6 };
        items[0] = temp;

        for (int i = 0; i <= items.length; i++) {
            for (int j = 0; j <= items.length; j++) {
                System.out.print(items[i][j] + " ");

            }
            System.out.println();
        }
    }
}