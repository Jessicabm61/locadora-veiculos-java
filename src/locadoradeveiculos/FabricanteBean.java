package locadoradeveiculos;

public class FabricanteBean {

    private int id_fabricante;
    private String nome_fabricante;

    public FabricanteBean(String nome_fabricante) {
        this.nome_fabricante = nome_fabricante;
    }

    public FabricanteBean(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }
    
    public FabricanteBean(int id_fabricante, String nome_fabricante) {
        this.id_fabricante = id_fabricante;
        this.nome_fabricante = nome_fabricante;
}

     public int getId_fabricante() {
        return id_fabricante;
    }
     
     public void setId_fabricante(int id_fabricante) {
         this.id_fabricante = id_fabricante;
     }
     
    
    public String getNome_fabricante() {
        return nome_fabricante;
    }

    public void setNome_fabricante(String nome_fabricante) {
        this.nome_fabricante = nome_fabricante;
    }
        
        //Imprime o objeto que está na memória
       public String toString(){
         return ("ID_Fabricante: " + id_fabricante + " Fabricante: " + nome_fabricante);
    }
}
