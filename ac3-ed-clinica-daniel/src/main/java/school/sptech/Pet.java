package school.sptech;

//Classe completa (não é necessário alterar)
public class Pet {
    // Atributos
    private int id;
    private String nome;
    private String raca;
    private String motivo;

    // Construtor
    public Pet(int id, String nome, String raca, String motivo) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.motivo = motivo;
    }

    // toString()

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
