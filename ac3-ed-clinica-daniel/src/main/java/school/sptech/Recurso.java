package school.sptech;

//Classe completa (não é necessário alterar)
public class Recurso {
    // Atributos
    private int id;
    private String nome;
    private int quantidade;

    // Construtor
    public Recurso(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
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
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //toString
    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}

