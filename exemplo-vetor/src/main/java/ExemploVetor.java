import java.util.Scanner;

public class ExemploVetor {
    public static void exibiVetorDeInteiro(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
    }

    public static void main(String[] args) {
        String[] palavras = new String[50];

        int[] vetorComValor = {10, 20, 30, 40, 50};

        int[] vetor = new int[5];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i+1;
            System.out.println(vetor[i]);
        }

        Scanner leitor = new Scanner(System.in);
        int[] vetorUsuario = new int[7];
        for (int i = 0; i < vetorUsuario.length; i++) {
            System.out.println("Preencha o vetor[" + i + "]:");
            vetorUsuario[i] = leitor.nextInt();
        }

        exibiVetorDeInteiro(vetorUsuario);
    }
}
