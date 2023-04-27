package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class LocacaoModel {
    // Metodo para inserir um novo fabricante no banco de dados
    public static void create(LocacaoBean a, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO locacao (data, id_carro, id_cliente) VALUES (?,?,?)");
        st.setDate(1, new java.sql.Date(a.getData().getTime())); 
        st.setInt(2, a.getId_carro());
        st.setInt(3, a.getId_cliente());
        st.execute();
        st.close();
    }
              
    static HashSet listAll(Connection con) throws SQLException {
    Statement st; //Usa um statement para acessar o banco
    HashSet list = new HashSet();
    st = con.createStatement();
    String sql = "SELECT contrato, data, id_carro, id_cliente FROM locacao";
    ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
    while(result.next()) {
         int contrato = result.getInt(1);
         java.util.Date data = new java.util.Date(result.getDate(2).getTime());
         int id_carro = result.getInt(3);
         int id_cliente = result.getInt(4);
         list.add(new LocacaoBean(contrato, data, id_carro, id_cliente)); //para cada elemento da lista cria um been do ambulatório (em memória) está passando os parâmetro pelo construtor
    }
    return list;
    }
    
}
