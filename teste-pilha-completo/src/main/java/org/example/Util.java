package org.example;

public class Util {

    public static boolean isPalindromo(int[] vetor) {

        Pilha pilha = new Pilha(vetor.length/2);
        int i;
        for (i = 0; i < vetor.length/2; i++) {
            pilha.push(vetor[i]);
        }
        if (vetor.length % 2 != 0) i++;
        for (;i < vetor.length; i++) {
            if (vetor[i] != pilha.pop()) {
                    return false;
            }
        }
        return true;
    }

    public static void toBinario(int number){
        Pilha pilha = new Pilha(number);
        while (number != 0) {
            pilha.push(number%2);
            number/=2;
        }
        pilha.exibe();
    }
}
