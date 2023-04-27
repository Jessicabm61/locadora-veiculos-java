package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class LocacaoModel {
    // MÈtodo para inserir um novo fabricante no banco de dados
    public static void create(LocacaoBean a, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO locacao (data, id_carro, id_funcionario, id_cliente) VALUES (?,?,?)");
        st.setDate(1, new java.sql.Date(a.getData().getTime())); 
        st.setInt(2, a.getId_carro());
        st.setInt(3, a.getId_funcionario());
        st.setInt(4, a.getId_cliente());
        st.execute();
        st.close();
    }
    
    //MÈtodo que imprime o que est· no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
	    Statement st; //Usa um statement para acessar o banco
	    HashSet list = new HashSet();
	    st = con.createStatement();
	    String sql = "SELECT contrato, data, id_carro, id_funcionario, id_cliente FROM fabricante";
	    ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
	    while(result.next()) {
	         list.add(new LocacaoBean(result.getInt(1), result.getDate(2), result.getInt(3), result.getInt(4), result.getInt(5))); //para cada elemento da lista cria um been do ambulat√≥rio (em mem√≥ria) est√° passando os par√¢metro pelo construtor
	    }
	    return list;
    }
}
