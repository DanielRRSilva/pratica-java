public class Programa {
    private Integer id;
    private String nome;
    private String genero;
    private double audienciaMedia;
    private Integer numeroDeTemporadas;
    private Integer anoDeLancamento;

    public Programa(Integer id, String nome, String genero, double audienciaMedia, Integer numeroDeTemporadas, Integer anoDeLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.audienciaMedia = audienciaMedia;
        this.numeroDeTemporadas = numeroDeTemporadas;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Programa() {
        this.id = 0;
        this.nome = "";
        this.genero = "";
        this.audienciaMedia = 0;
        this.numeroDeTemporadas = 0;
        this.anoDeLancamento = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAudienciaMedia() {
        return audienciaMedia;
    }

    public void setAudienciaMedia(double audienciaMedia) {
        this.audienciaMedia = audienciaMedia;
    }

    public Integer getNumeroDeTemporadas() {
        return numeroDeTemporadas;
    }

    public void setNumeroDeTemporadas(Integer numeroDeTemporadas) {
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public String toString() {
        return "Programa {id: "+id+", nome: "+nome+", genero: "+genero+", audienciaMedia: "+audienciaMedia+", numeroDeTemporadas: "+numeroDeTemporadas+", anoDeLancamento: " +anoDeLancamento+"}";
    }
}
