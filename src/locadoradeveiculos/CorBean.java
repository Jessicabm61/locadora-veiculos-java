package locadoradeveiculos;

public class CorBean {

    private int id_cor;
    private String nome_cor;

    public CorBean(String nome_cor) {
        this.nome_cor = nome_cor;
    }

    public CorBean(int id_cor) {
        this.id_cor = id_cor;
    }

    public CorBean(int id_cor, String nome_cor) {
        this.id_cor = id_cor;
        this.nome_cor = nome_cor;
    }

    public int getId_cor() {
        return id_cor;
    }

    public String getNome_cor() {
        return nome_cor;
    }

    public void setNome_cor(String nome_cor) {
        this.nome_cor = nome_cor;
    }

    //Imprime o objeto que está na memória
    public String toString() {
        return ("ID_Cor: " + id_cor + " Cor: " + nome_cor);
    }
}
