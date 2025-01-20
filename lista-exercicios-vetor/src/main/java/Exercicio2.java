import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        int[] vetorDeInteiros = new int[10];
        Scanner leitorInteiro = new Scanner(System.in);
        for (int i = 0; i < vetorDeInteiros.length; i++) {
            System.out.printf("Preencha o vetor na posição %d:%n", i+1);
            vetorDeInteiros[i] = leitorInteiro.nextInt();
        }
        double somaTotal = 0;
        double media = 0;
        for (int i = 0; i < vetorDeInteiros.length; i++) {
            somaTotal += vetorDeInteiros[i];
        }
        media = somaTotal/vetorDeInteiros.length;
        System.out.println("A média é " + media);
        for (int i = 0; i < vetorDeInteiros.length; i++) {
            if (vetorDeInteiros[i] > media) {
                System.out.println(vetorDeInteiros[i]);
            }
        }
    }
}
