package org.example;

public class ContaBancaria {

    private Integer numero;

    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public ContaBancaria() {
        this.numero = 0;
        this.saldo = 0.0;
    }

    public Boolean debitar(Double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        this.saldo -= valor;
        System.out.printf("\nSaldo atual: R$%.2f".formatted(this.saldo));
        return true;
    }

    public void creditar(Double valor) {
        this.saldo += valor;
        System.out.println("Saldo atual: R$%.2f".formatted(this.saldo));
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        String pattern = "|%5d|%5.2f|";
        return pattern.formatted(this.numero, this.saldo);
    }
}
