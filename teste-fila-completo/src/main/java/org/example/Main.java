package org.example;

public class Main {
    public static void main(String[] args) {
        FilaCircular filaCircular = new FilaCircular(5);
        filaCircular.insert("a");
        filaCircular.insert("b");
        filaCircular.insert("c");
        filaCircular.insert("d");
        filaCircular.insert("e");

        filaCircular.exibe();
    }
}