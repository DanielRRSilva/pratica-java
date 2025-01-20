package org.example;

public class Main {
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha(5);
        pilha.push(5);
        pilha.push(5);
        pilha.push(5);
        pilha.push(5);
        pilha.push(5);
        pilha.print();
        pilha.pop();
        pilha.print();
    }
}