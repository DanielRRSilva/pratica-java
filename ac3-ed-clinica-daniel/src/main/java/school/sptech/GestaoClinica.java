package school.sptech;

import school.sptech.estruturas.PilhaObj;

import java.util.ArrayList;
import java.util.List;

public class GestaoClinica {
    // Atributos (completos, não é necessário alterar)
    private List<Recurso> lista;
    private PilhaObj<Integer> pilhaDesfazer;
    private PilhaObj<Integer> pilhaRefazer;

    //Construtor (completo, não é necessário alterar)
    public GestaoClinica() {
        lista = new ArrayList();
        pilhaDesfazer = new PilhaObj(10);
        pilhaRefazer = new PilhaObj(10);
    }

    // Métodos (completar)
    public void salvar(Recurso r) {
        lista.add(r);
    }

    public void aumentaRecurso(int valorAumento) {
        for (Recurso recurso : lista) {
            recurso.setQuantidade(recurso.getQuantidade() + valorAumento);
        }
    }

    public void diminuiRecurso(int valorDiminuicao) {
        for (Recurso recurso : lista) {
            recurso.setQuantidade(recurso.getQuantidade() - valorDiminuicao);
        }
        pilhaDesfazer.push(valorDiminuicao);
    }

    public void desfazer() {
        if (pilhaDesfazer.isEmpty()) throw new IllegalStateException();
        Integer valor = pilhaDesfazer.pop();
        aumentaRecurso(valor);
        pilhaRefazer.push(valor);
    }

    public void refazer() {
        if (pilhaRefazer.isEmpty()) throw new IllegalStateException();
        diminuiRecurso(pilhaRefazer.pop());
    }

    // Getters (não remover)
    public List<Recurso> getLista() {
        return lista;
    }

    public PilhaObj<Integer> getPilhaDesfazer() {
        return pilhaDesfazer;
    }

    public PilhaObj<Integer> getPilhaRefazer() {
        return pilhaRefazer;
    }
}
