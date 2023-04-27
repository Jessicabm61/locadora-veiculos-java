/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculos;

/**
 *
 * @author Jéssica
 */
public class ModeloBean {
    private Integer id_modelo;
    private String nome_modelo;
    private Integer id_fabricante;
    
	public Integer getId_modelo() {
		return id_modelo;
	}
	public void setId_modelo(Integer id_modelo) {
		this.id_modelo = id_modelo;
	}
	public Integer getId_fabricante() {
		return id_fabricante;
	}
	public void setId_fabricante(Integer id_fabricante) {
		this.id_fabricante = id_fabricante;
	}
	public String getNome_modelo() {
		return nome_modelo;
	}
	public void setNome_modelo(String nome_modelo) {
		this.nome_modelo = nome_modelo;
	}
    
}
