package locadoradeveiculos;

public class CidadeBean {

    private int id_cidade;
    private String nome_cidade;
    private String estado_cidade;
   
    public CidadeBean(int id_cidade, String nome_cidade, String estado_cidade) {
        this.id_cidade = id_cidade;
        this.nome_cidade = nome_cidade;
        this.estado_cidade = estado_cidade;
    }
    
    public CidadeBean(String nome_cidade, String estado_cidade) {
        this.nome_cidade = nome_cidade;
        this.estado_cidade = estado_cidade;
    }
    
    /**
     * @return the id_cidade
     */
    public int getId_cidade() {
        return id_cidade;
    }

    /**
     * @param id_cidade the id_cidade to set
     */
    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    /**
     * @return the nome_cidade
     */
    public String getNome_cidade() {
        return nome_cidade;
    }

    /**
     * @param nome_cidade the nome_cidade to set
     */
    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    /**
     * @return the estado_cidade
     */
    public String getEstado_cidade() {
        return estado_cidade;
    }

    /**
     * @param estado_cidade the estado_cidade to set
     */
    public void setEstado_cidade(String estado_cidade) {
        this.estado_cidade = estado_cidade;
    }

         //Imprime o objeto que está na memória
     public String toString() {
         return "ID Cidade: " + id_cidade + " | Nome: " + nome_cidade + " | Estado: " + estado_cidade;
}

}
