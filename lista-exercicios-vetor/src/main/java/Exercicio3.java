import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        String[] vetorDeString = new String[10];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetorDeString.length; i++) {
            System.out.println("Digite qualquer nome para preencher o vetor: ");
            vetorDeString[i] = leitor.nextLine();
        }

        System.out.println("Digite um nome para pesquisar no vetor: ");
        String nomeDigitado = leitor.nextLine();
        boolean nomeEncontrado = false;
        int posicaoDoNome= 0;
        for (int i = 0; i < vetorDeString.length; i++) {
            if (nomeDigitado.equals(vetorDeString[i])) {
              nomeEncontrado = true;
              posicaoDoNome = i;
            }
        }

        if (nomeEncontrado) {
            System.out.printf("Nome encontrado no indice %d", posicaoDoNome);
        }else {
            System.out.println("Nome não encontrado");
        }
    }
}
