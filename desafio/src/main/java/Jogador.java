public class Jogador {

    private String nome;
    private Integer qtdTesouro;
    private  Boolean ativo;

    public Jogador(String nome) {
        this.nome = nome;
        this.qtdTesouro = 0;
        this.ativo = true;
    }

    public void inativar() {
        ativo = false;
    }

    public void addTesouro() {
        qtdTesouro++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdTesouro() {
        return qtdTesouro;
    }

    public void setQtdTesouro(Integer qtdTesouro) {
        this.qtdTesouro = qtdTesouro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return """
                ==========================================
                            🎮 Player Stats 🎮            \s
                ==========================================
            
                        Nome do Jogador: %s
                           🌟 Pontuação: %d🌟
           
            
            """.formatted(nome, qtdTesouro);
    }
}
