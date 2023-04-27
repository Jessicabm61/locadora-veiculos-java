/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculos;

/**
 *
 * @author Jessica
 */
public class ModeloBean {
    private Integer id_modelo;
    private String nome_modelo;
    private FabricanteBean fb;
    
    public ModeloBean(Integer id_modelo, String nome_modelo) {
        this.id_modelo = id_modelo;
        this.nome_modelo = nome_modelo;
    }
  
    public ModeloBean(Integer id_modelo, String nome_modelo, int id_fabricante) {
        this.id_modelo = id_modelo;
        this.nome_modelo = nome_modelo;
        this.fb.setId_fabricante(id_fabricante);
    }
    
    
    public ModeloBean (String nome_modelo) {
        this.nome_modelo = nome_modelo;
    }
        
	public Integer getId_modelo() {
		return id_modelo;
	}
	public void setId_modelo(Integer id_modelo) {
		this.id_modelo = id_modelo;
        }
        
	public String getNome_modelo() {
		return nome_modelo;
	}
	public void setNome_modelo(String nome_modelo) {
		this.nome_modelo = nome_modelo;
	}

	public FabricanteBean getFb() {
		return fb;
	}

	public void setFb(FabricanteBean fb) {
		this.fb = fb;
	}
    
	public String toStringDetails() {
	    return "Modelo{ ID Modelo=" + id_modelo +
	            ", nome='" + nome_modelo + '\'' +
	            ", fabricante='" + fb.getId_fabricante() + '\'' +
	            ", nome fabricante='" + fb.getNome_fabricante() + '\'' +
	            '}';		
	}
}
