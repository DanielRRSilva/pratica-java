package org.example;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {1,25,7,8,-3,-6,-84,5,-20};
        separaPositivoNegativoEmOrdem(vetor);
        System.out.println();
        separaPositivoNegativoOrdemDiferente(vetor);
    }

    public static void separaPositivoNegativoEmOrdem(int[] vetor) {
        Fila<Integer> filaPositivo = new Fila<>(vetor.length);
        Fila<Integer> filaNegativo = new Fila<>(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] < 0) filaNegativo.insert(vetor[i]);
            else filaPositivo.insert(vetor[i]);
        }

        exibirRemoverFila(filaPositivo);
        exibirRemoverFila(filaNegativo);
    }

    private static void exibirRemoverFila(Fila<Integer> fila) {
        int tamanho = fila.getTamanho();
        for (int i = 0; i < tamanho; i++) {
            System.out.print(fila.poll() + " ");
        }
    }

    private static void exibirRemoverPilha(Pilha<Integer> pilha) {
        int tamanho = pilha.getTopo();
        for (int i = 0; i <= tamanho; i++) {
            System.out.print(pilha.pop() + " ");
        }
    }

    public static void separaPositivoNegativoOrdemDiferente(int[] vetor) {
        Fila<Integer> filaPositivo = new Fila<>(vetor.length);
        Pilha<Integer> pilhaNegativo = new Pilha<>(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] < 0) pilhaNegativo.push(vetor[i]);
            else filaPositivo.insert(vetor[i]);
        }
        exibirRemoverFila(filaPositivo);
        exibirRemoverPilha(pilhaNegativo);
    }
}