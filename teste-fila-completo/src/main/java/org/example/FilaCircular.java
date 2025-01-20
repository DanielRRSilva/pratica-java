package org.example;

public class FilaCircular {

    private int tamanho;

    private String[] fila;

    private Integer inicio;

    private Integer fim;

    public FilaCircular(int capaciade) {
        tamanho = 0;
        fila = new String[capaciade];
        inicio = 0;
        fim = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(String info) {
        if (isFull()) throw new IllegalStateException("Fila cheia");
        fila[fim] = info;
        fim = (fim + 1) % fila.length;
        tamanho++;
    }

    public String peek() {
        if (isEmpty()) return "";
        return fila[inicio];
    }

    public String poll() {
        if (isEmpty()) return null;
        String elementoInicio = peek();
        inicio = (inicio + 1) % fila.length;
        tamanho--;
        return elementoInicio;
    }

    public void exibe() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = inicio, count = 0; count < tamanho; count++,  i = (i + 1) % fila.length) {
            str.append(fila[i]);
            if (i+1 < fila.length) str.append(',').append(' ');

        }
        str.append("]");
        System.out.println(str);
    }

    public int getTamanho(){
        return tamanho;
    }
}

