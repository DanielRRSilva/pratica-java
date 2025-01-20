import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        int[] vetorInteiros = {10,20,30,40,50,60,70};

//        Scanner leitorInteiros = new Scanner(System.in);
//        for (int i = 0; i < vetorInteiros.length; i++) {
//            System.out.println("Preencha o vetor:");
//            vetorInteiros[i] = leitorInteiros.nextInt();
//        }
        System.out.println("Exibindo o vetor do começo ao fim:");
        for (int i = 0; i < vetorInteiros.length; i++) {
            System.out.println(vetorInteiros[i]);
        }

        System.out.println("Exibindo o vetor do fim ao começo:");
        for (int i = vetorInteiros.length; i > 0 ; i--) {
            System.out.println(vetorInteiros[i-1]);
        }
    }
}
