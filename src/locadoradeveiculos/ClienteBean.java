package locadoradeveiculos;

public class ClienteBean {

    private int id_cliente;
    private String nome;
    private String cpf;
    private String email;
    private String rua;
    private String bairro;
    private String telefone;
    private CidadeBean id_cidade;

    public ClienteBean(String nome, String cpf, String email, String rua, String bairro, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.telefone = telefone;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CidadeBean getId_cidade() {
        return id_cidade;
    }

    public CidadeBean setId_cidade(CidadeBean id_cidade) {
        this.id_cidade = id_cidade;
    }

    // Imprime o objeto que está na memória
    public String toString() {
        return ("ID_Cliente: " + id_cliente + " Nome: " + nome + " CPF: " + cpf + " E-mail: " + email + " Rua: " + rua
                + " Bairro: " + bairro + " Telefone: " + telefone + " ID_Cidade: " + id_cidade);
    }
}
