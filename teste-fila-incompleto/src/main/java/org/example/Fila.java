package org.example;

public class Fila {
    // Atributos
    private int tamanho;
    private String[] fila;

    // Construtor
    public Fila(int capaciade) {

    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return false;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return false;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Lançar IllegalStateException caso a fila esteja cheia
     */
    public void insert(String info) {

    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {
        return "";
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public String poll() {
        return "";
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {

    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho(){
        return 0;
    }
}

