package school.sptech;

import school.sptech.estruturas.FilaObj;

//Classe completa (não é necessário alterar)
public class Atendimento {

    private FilaObj<Pet> filaPrioritaria;
    private FilaObj<Pet> filaNormal;

    public Atendimento() {
        this.filaPrioritaria = new FilaObj(10);
        this.filaNormal = new FilaObj(10);
    }

    public void triagem(Pet p) {
        if (p.getMotivo().equalsIgnoreCase("Hemorragia") ||
            p.getMotivo().equalsIgnoreCase("Envenenamento")
        ) {
            filaPrioritaria.insert(p);
        }else filaNormal.insert(p);
    }

    public  Pet[] atender(int qtdPacienteChamado) {
        if (filaPrioritaria.isEmpty() && filaNormal.isEmpty()) throw new IllegalStateException();
        if (qtdPacienteChamado <= 0 ) throw new IllegalArgumentException();
        Pet[] pacientes = new Pet[qtdPacienteChamado];
        if (qtdPacienteChamado > (filaPrioritaria.getTamanho() + filaNormal.getTamanho())) throw new IllegalArgumentException();
        for (int i = 0; i < qtdPacienteChamado; i++) {
            if (!filaPrioritaria.isEmpty()) {
                pacientes[i] = filaPrioritaria.poll();
            }else pacientes[i] = filaNormal.poll();
        }
        return pacientes;
    }


    // Getters - Não remover
    public FilaObj<Pet> getFilaPrioritaria() {
        return filaPrioritaria;
    }

    public FilaObj<Pet> getFilaNormal() {
        return filaNormal;
    }

}