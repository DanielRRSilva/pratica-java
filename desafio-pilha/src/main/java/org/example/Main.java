package org.example;

import java.util.Scanner;

import static org.example.Curso.*;

public class Main {
    static Curso curso = new Curso();
    static Scanner scInt = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);


    public static void menu() {
        System.out.println("""
                1- Cadastrar Aluno
                2- Deletar Aluno
                3- Exibir Alunos
                4- Desfazer Ultima Ação
                5- Encerrar Programa
                """);
        int option = scInt.nextInt();
        switch (option) {
            case 1:
                curso.cadastrarAluno();
                break;
            case 2:
                System.out.println("Insira o Id do aluno: ");
                Integer id = scInt.nextInt();
                curso.deletarAluno(id);
                break;
            case 3:
                curso.exibirAluno();
                break;
            case 4:
                curso.desfazer();
                break;
            case 5:
                System.out.println("Encerrando programa...");
                break;
            default:
                menu();
                break;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}