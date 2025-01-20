import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] atualizarVetor(String[] vetor, String nome) {
        if (vetor[0] == null) {
            vetor[0] = nome;
            return vetor;
        }
        String[] vetorAux = new String[vetor.length+1];
        for (int i = 0; i < vetor.length; i++) {
            vetorAux[i] = vetor[i];
        }
        vetorAux[vetor.length] = nome;
        return vetorAux;
    }

    public static void main(String[] args) {
        Scanner leitorTexto = new Scanner(System.in);
        int i = 0;
        String nome, turma;
        String[] T1 = new String[1];
        String[] T2 = new String[1];
        while (i < 3) {
            System.out.println("Digite o nome do aluno:");
            nome = leitorTexto.nextLine();
            System.out.println("Digite a turma do aluno:");
            turma = leitorTexto.nextLine();
            if (turma.equalsIgnoreCase("T1")) {
                T1 = atualizarVetor(T1, nome);
            }else {
                T2 = atualizarVetor(T2, nome);
            }
            i++;
        }
        System.out.println(Arrays.toString(T1));
        System.out.println(Arrays.toString(T2));
    }
}
