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
    private char[] combustivel;
    private char[] cambio;
    private char[] tracao;
    private char[] observacao;
    
public VeiculoBean(String placa, int portas, int ano, char[] combustivel, char[] cambio, char[] tracao, char[] observacao){
    this.placa       = placa;
    this.portas      = portas;
    this.ano         = ano;
    this.combustivel = combustivel;
    this.cambio      = cambio;
    this.tracao      = tracao;
    this.observacao  = observacao;
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
    public char[] getCombustivel() {
        return combustivel;
    }

    /**
     * @param combustivel the combustivel to set
     */
    public void setCombustivel(char[] combustivel) {
        this.combustivel = combustivel;
    }

    /**
     * @return the cambio
     */
    public char[] getCambio() {
        return cambio;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setCambio(char[] cambio) {
        this.cambio = cambio;
    }

    /**
     * @return the tracao
     */
    public char[] getTracao() {
        return tracao;
    }

    /**
     * @param tracao the tracao to set
     */
    public void setTracao(char[] tracao) {
        this.tracao = tracao;
    }

    /**
     * @return the observacao
     */
    public char[] getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(char[] observacao) {
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
            '}';
}

}
