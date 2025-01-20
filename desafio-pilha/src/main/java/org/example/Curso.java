package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {

    public List<Aluno> listaAlunos;
    public Pilha<Integer> pilhaDesfazer;

    public Curso() {
        listaAlunos = new ArrayList<>();
        pilhaDesfazer = new Pilha(20);
    }

    public void cadastrarAluno() {
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        System.out.println("Insira o Id do aluno: ");
        Integer id = scInt.nextInt();
        System.out.println("Insira o nome do aluno: ");
        String nome = scString.nextLine();
        Aluno aluno = new Aluno(id, nome);
        listaAlunos.add(aluno);
        pilhaDesfazer.push(id);
        Main.menu();
    }

    public void deletarAluno(Integer id) {
        for (int i = 0; i < listaAlunos.size(); i++) {
            if (listaAlunos.get(i).getId() == id) {
                listaAlunos.remove(i);
            }
        }
        Main.menu();
    }

    public void desfazer() {
        Integer id = pilhaDesfazer.pop();
        deletarAluno(id);
    }

    public void exibirAluno() {
        if (listaAlunos.size() < 1) {
            System.out.println("Não há alunos cadastrados.");
            Main.menu();
        }else {
            String pattern = "|%5d|%20s|";
            for (Aluno aluno : listaAlunos) {
                System.out.println(pattern.formatted(aluno.getId(), aluno.getNome()));
            }
            Main.menu();
        }
    }
}
