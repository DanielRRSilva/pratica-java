package org.example;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static Fila<Operacao> filaAgendamento = new Fila<>(50);

    private static Pilha<Operacao> pilhaDesfazer = new Pilha<>(50);

    private static Integer contadorOperacoes = 0;

    private static List<ContaBancaria> contas = List.of(new ContaBancaria(123,200.50),new ContaBancaria(456,5340.63));

    private static Scanner scanner = new Scanner(System.in);

    private static Scanner scannerTexto = new Scanner(System.in);

    public static void menu() {
        Integer escolha;
        System.out.println("""
                \n
                1- Debitar
                2- Creditar
                3- Desfazer operação
                4- Agendar operação
                5- Executar operações agendadas
                6- Sair
                """);
        escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                debitar();
                break;
            case 2:
                creditar();
                break;
            case 3:
                desfazer();
                break;
            case 4:
                agendar();
                break;
            case 5:
                executarAgenda();
                break;
            case 6:
                sair();
                break;
            default:
                menu();
                break;
        }
    }

    public static void debitar() {
        Integer numeroConta;
        Double valorDebitar;
        System.out.println("Insira o numero da conta:");
        numeroConta = scanner.nextInt();
        System.out.println("Insira o valor a debitar:");
        valorDebitar = scanner.nextDouble();
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta.getNumero().equals(numeroConta)) {
            if (conta.debitar(valorDebitar)) {
                Operacao operacao = new Operacao(conta, "debito", valorDebitar);
                try {
                    pilhaDesfazer.push(operacao);
                    contadorOperacoes++;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        menu();
    }

    public static void creditar() {
        Integer numeroConta;
        Double valorDepositar;
        System.out.println("Insira o numero da conta:");
        numeroConta = scanner.nextInt();
        System.out.println("Insira o valor a depositar:");
        valorDepositar = scanner.nextDouble();
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta.getNumero().equals(numeroConta)) {
            conta.creditar(valorDepositar);
            Operacao operacao = new Operacao(conta, "credito", valorDepositar);
            try {
                pilhaDesfazer.push(operacao);
                contadorOperacoes++;
            }catch (IllegalStateException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        menu();
    }

    public static void desfazer() {
        Integer numeroOperacoesDesfazer;
        System.out.println("Insira o numero de operações a serem desfeitas:");
        numeroOperacoesDesfazer = scanner.nextInt();
        if (numeroOperacoesDesfazer > contadorOperacoes) System.out.println("Quantidade de operações inválida!");
        for (int i = 0; i < numeroOperacoesDesfazer; i++) {
            Operacao operacao = pilhaDesfazer.pop();
            ContaBancaria conta = operacao.getObjConta();
            if (operacao.getTipoOperacao().equals("debito")) {
                conta.creditar(operacao.getValor());
            }else if (operacao.getTipoOperacao().equals("credito")) {
                conta.debitar(operacao.getValor());
            }
            contadorOperacoes--;
        }
        menu();
    }

    public static void agendar() {
        String tipoOperacao;
        Integer numeroConta;
        Double valor;
        System.out.println("Insira qual o tipo de operação (débito ou crédito):");
        tipoOperacao = scannerTexto.nextLine();
        System.out.println("Insira o numero de conta:");
        numeroConta = scanner.nextInt();
        System.out.println("Insira o valor:");
        valor = scanner.nextDouble();
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta == null) return;
        Operacao operacao = new Operacao(conta,tipoOperacao,valor);
        try {
            filaAgendamento.insert(operacao);
        }catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        menu();
    }

    public static void executarAgenda() {
        Integer tamanhoFila;
        if (filaAgendamento.isEmpty()) {
            System.out.println("Não há operações agendadas");
            return;
        }
        tamanhoFila = filaAgendamento.getTamanho();
        for (int i = 0; i < tamanhoFila; i++) {
            Operacao operacao = filaAgendamento.poll();
            ContaBancaria conta = operacao.getObjConta();
            if (operacao.getTipoOperacao().equals("credito")) {
                conta.creditar(operacao.getValor());
            }else if (operacao.getTipoOperacao().equals("debito")) {
                conta.debitar(operacao.getValor());
            }
            try {
                pilhaDesfazer.push(operacao);
            }catch (IllegalStateException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        menu();
    }

    public static ContaBancaria buscarConta(Integer numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        throw new NoSuchElementException("conta");
    }

    public static void sair() {
        System.out.println("Obrigado, até a próxima!");
    }

    public static void main(String[] args) {
        menu();
    }
}