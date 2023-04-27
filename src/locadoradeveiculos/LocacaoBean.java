package locadoradeveiculos;

import java.util.Date;

public class LocacaoBean {
	private int contrato;
	private Date data;
	private int id_carro;
	private int id_cliente;
	private int id_funcionario;
	
	public LocacaoBean(int contrato, Date data, int id_carro, int id_cliente, int id_funcionario){
	    this.contrato       = contrato;
	    this.data           = data;
	    this.id_carro       = id_carro;
	    this.id_cliente     = id_cliente;
	    this.id_funcionario = id_funcionario;
	}
	
	public LocacaoBean(Date data, int id_carro, int id_cliente, int id_funcionario){
	    this.data           = data;
	    this.id_carro       = id_carro;
	    this.id_cliente     = id_cliente;
	    this.id_funcionario = id_funcionario;
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
	public int getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}	
}
