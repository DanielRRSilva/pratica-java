package org.example;

public class Fila {

    private int tamanho;

    private String[] fila;

    public Fila(int capaciade) {
        tamanho = 0;
        fila = new String[capaciade];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(String info) {
        if (isFull()) throw new IllegalStateException("Fila cheia");
        fila[tamanho] = info;
        tamanho++;
    }

    public String peek() {
        if (isEmpty()) return "";
        return fila[0];
    }

    public String poll() {
        if (isEmpty()) return "";
        String info = fila[0];
        tamanho--;
        for (int i = 0; i < tamanho; i++) {
            fila[i] = fila[i+1];
        }
        return info;
    }

    public void exibe() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i >= tamanho; i++) {
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

