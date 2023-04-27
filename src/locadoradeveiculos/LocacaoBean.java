package locadoradeveiculos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocacaoBean {
	private int contrato;
	private Date data;
	private int id_carro;
	private int id_cliente;
        
        
	
	public LocacaoBean(int contrato, java.util.Date data, int id_carro, int id_cliente){
	    this.contrato       = contrato;
	    this.data           = data;
	    this.id_carro       = id_carro;
	    this.id_cliente     = id_cliente;
	}
	
	public LocacaoBean(java.util.Date data, int id_carro, int id_cliente){
	    this.data           = data;
	    this.id_carro       = id_carro;
	    this.id_cliente     = id_cliente;
	}
        
	public LocacaoBean(int id_carro){
	    this.id_carro       = id_carro;
	}
	
	
	public int getContrato() {
		return contrato;
	}
	public void setContrato(int contrato) {
		this.contrato = contrato;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getId_carro() {
		return id_carro;
	}
	public void setId_carro(int id_carro) {
		this.id_carro = id_carro;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}	
        
	public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatter.format(data);
        return "Contrato: " + contrato + ", data: " + dataFormatada + ", id_carro: " + id_carro + ", id_cliente:" + id_cliente;
	}

    String getId_locacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
