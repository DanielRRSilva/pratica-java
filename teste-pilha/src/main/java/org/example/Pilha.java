package org.example;

public class Pilha <T> {
    private int topo;
    private T[] pilha;

    public Pilha(int tamanho) {
        pilha = (T[]) new Object[tamanho];
        topo = -1;
    }

    public boolean isEmpty() {
        if (topo == -1) return true;
        return false;
    }

    public boolean isFull() {
        if (topo == pilha.length - 1) return true;
        return false;
    }

    public void push(T info) {
        if (isFull()) throw new IllegalStateException("Pilha cheia");
        pilha[++topo] = info;
    }

    public T pop() {
        if (topo == -1) return null;
        T info = pilha[topo];
        pilha[topo] = null;
        topo--;
        return info;
    }

    public T peek() {
        if(isEmpty()) return null;
        return pilha[topo];
    }

    public void print() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = topo; i >= 0; i--) {
            str.append(pilha[i]);
        }
        str.append("]");
        System.out.println(str.toString());
    }
}
