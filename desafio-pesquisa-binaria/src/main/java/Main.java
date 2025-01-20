import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int[] vetorInt = new int[ThreadLocalRandom.current().nextInt(500, 1000)];
        for (int i = 0; i < vetorInt.length; i++) {
            vetorInt[i] = i*10;
        }
    }
}
