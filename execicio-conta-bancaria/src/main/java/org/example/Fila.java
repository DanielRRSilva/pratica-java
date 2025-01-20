package org.example;

public class Fila<T> {

    private int tamanho;

    private T[] fila;

    public Fila(int capaciade) {
        tamanho=0;
        fila = (T[]) new Object[capaciade];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T info) {
        if (isFull()) throw new IllegalStateException("Fila cheia");
        fila[tamanho] = info;
        tamanho++;
    }

    public T peek() {
        if (isEmpty()) return null;
        return fila[0];
    }

    public T poll() {
        if (isEmpty()) return null;
        T info = fila[0];
        tamanho--;
        for (int i = 0; i < tamanho; i++) {
            fila[i] = fila[i+1];
        }
        return info;
    }

    public void exibe() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < tamanho; i++) {
            str.append(fila[i]);
            if (i+1 < tamanho) str.append(',').append(' ');
        }
        str.append("]");
        System.out.println(str);
    }

    public int getTamanho(){
        return tamanho;
    }
}