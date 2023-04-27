/*
 Cria o objeto a ser construido na memória
 */
package locadoradeveiculos;

/**
 *
 * @author Jéssica
 */
public class VeiculoBean {
    private String placa;
    private int portas;
    private int ano;
    private String combustivel;
    private String cambio;
    private String tracao;
    private String observacao;
    private int id_modelo;
    private int id_cor;
    
	public VeiculoBean(String placa, int portas, int ano, String combustivel, String cambio, String tracao, String observacao, int id_modelo, int id_cor){
	    this.placa       = placa;
	    this.portas      = portas;
	    this.ano         = ano;
	    this.combustivel = combustivel;
	    this.cambio      = cambio;
	    this.tracao      = tracao;
	    this.observacao  = observacao;
	    this.setId_modelo(id_modelo);
	    this.setId_cor(id_cor);
	}

    /**
     * @return the placas
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placas the placas to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the portas
     */
    public int getPortas() {
        return portas;
    }

    /**
     * @param portas the portas to set
     */
    public void setPortas(int portas) {
        this.portas = portas;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the combustivel
     */
    public String getCombustivel() {
        return combustivel;
    }

    /**
     * @param combustivel the combustivel to set
     */
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    /**
     * @return the cambio
     */
    public String getCambio() {
        return cambio;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    /**
     * @return the tracao
     */
    public String getTracao() {
        return tracao;
    }

    /**
     * @param tracao the tracao to set
     */
    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
	public String toString() {
	    return "Veículo{" +
	            "placa='" + placa + '\'' +
	            ", portas=" + portas +
	            ", ano=" + ano +
	            ", combustivel='" + combustivel + '\'' +
	            ", cambio='" + cambio + '\'' +
	            ", tracao='" + tracao + '\'' +
	            ", observacao='" + observacao + '\'' +
	            ", modelo='" + id_modelo + '\'' +
	            ", cor='" + id_cor + '\'' +
	            '}';
	}

	public int getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}

	public int getId_cor() {
		return id_cor;
	}

	public void setId_cor(int id_cor) {
		this.id_cor = id_cor;
	}

}
