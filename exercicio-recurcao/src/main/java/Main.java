import java.util.Arrays;

public class Main {
    public static int somar(int numero) {
        if (numero <= 0) return numero;
        return numero += somar(numero-1);
    }

    public static int somarVetor(int[] numeros, int i) {
        if (i == numeros.length) return 0;
        return numeros[i] + somarVetor(numeros, i+1);
    }

    public static int somarParesVetor(int[] numeros, int i) {
        if (i == numeros.length) return 0;
        if (numeros[i] % 2 == 0)  return numeros[i] + somarParesVetor(numeros, i+1);
        return somarParesVetor(numeros, i+1);
    }

    public static int contarImparesVetor(int[] numeros, int i) {
        if (i == numeros.length) return 0;
        if (numeros[i] % 2 != 0)  return 1 + somarParesVetor(numeros, i+1);
        return contarImparesVetor(numeros, i + 1);
    }

    public static int contarRepticaoNumeroVetor(int[] numeros, int numero, int i) {
        if (i == numeros.length) return 0;
        if (numeros[i] == numero) return 1 + contarRepticaoNumeroVetor(numeros, numero, i+1);
        return contarRepticaoNumeroVetor(numeros, numero,i+1);
    }

    public static int mdcRecursivo(int a, int b) {
        if (b == 0) return a;
        return mdcRecursivo(b, a % b);
    }

    public static int mdcIterativo(int a, int b) {
        while (b != 0) {
            int resto = b;
            b = a % b;
            a = resto;
        }
        return a;
    }

    public static int maiorElementoIterativo(int[] vetor) {
        int maior = vetor[0];
        for (int valor : vetor) {
            if (valor > maior) maior = valor;
        }
        return maior;
    }
    public static int maiorElementoRecursivo(int[] numeros, int i, int maior) {
        if (i == numeros.length) return maior;
        if (numeros[i] > maior) return maiorElementoRecursivo(numeros, i+1, numeros[i]);
        return maiorElementoRecursivo(numeros, i+1, maior);
    }

    public static int somaDigitos(int numero) {
        if (numero == 0) return 0;
        return numero % 10 + somaDigitos(numero / 10);
    }

    public static String binario(int numero) {
        if (numero == 0) return "";
        return binario(numero / 2) + (numero % 2);
    }

    public static void main(String[] args) {
        int[] numeros = {7,3,5,2};
        int[] numeros2 = {7,3,5,3};
        System.out.println(somar(5));
        System.out.println(somarVetor(numeros, 0));
        System.out.println(somarParesVetor(numeros, 0));
        System.out.println(contarImparesVetor(numeros, 0));
        System.out.println(contarRepticaoNumeroVetor(numeros2, 5, 0));
        System.out.println(mdcIterativo(90,54));
        System.out.println(mdcRecursivo(90,54));
        System.out.println(maiorElementoIterativo(numeros));
        System.out.println(maiorElementoRecursivo(numeros,0,2));
        System.out.println(somaDigitos(132));
        System.out.println(binario(9));
    }
}
