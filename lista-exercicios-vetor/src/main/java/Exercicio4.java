import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        int[] vetorDeInteiros = new int[10];
        Scanner leitorDeInteiros = new Scanner(System.in);

        for (int i = 0; i < vetorDeInteiros.length; i++) {
            System.out.println("Digite qualquer numero para preencher o vetor: ");
            vetorDeInteiros[i] = leitorDeInteiros.nextInt();
        }
        int numeroDigitado = 0;
        int numeroDeOcorrencias = 0;
        System.out.println("Digite um numero qualquer:");
        numeroDigitado = leitorDeInteiros.nextInt();

        for (int i = 0; i < vetorDeInteiros.length; i++) {

            if (numeroDigitado == vetorDeInteiros[i]) {
                numeroDeOcorrencias++;
            }
        }

        System.out.printf("O numero %d ocorre %d vezes", numeroDigitado, numeroDeOcorrencias);
    }
}
