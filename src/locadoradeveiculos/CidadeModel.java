package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CidadeModel {
    
    // Método para inserir uma nova cidade no banco de dados
    public static void create(CidadeBean a, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO cidade (nome, uf) VALUES (??)");
        st.setString(1, a.getNome_cidade());
        st.setString(1, a.getEstado_cidade());
        st.execute();
        st.close();
    }

     // Método para excluir uma cidade do banco de dados
    public static void deleteCidade(Connection con, int id_cidade) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("DELETE FROM cidade WHERE id_cidade = ?");
        st.setInt(1, id_cidade);
        st.execute();
        st.close();   
    }
    
    public static void updateCidade(CidadeBean cb, Connection con) throws SQLException {
    PreparedStatement st;
    st = con.prepareStatement("UPDATE cidade SET nome = ?, uf = ? WHERE id_cidade = ?");
    st.setString(1, cb.getNome_cidade());
    st.setString(2, cb.getEstado_cidade());
    st.setInt(3, cb.getId_cidade());
    st.executeUpdate();
    st.close();
    }

    //Método que imprime o que está no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
    Statement st; //Usa um statement para acesar o banco
    HashSet list = new HashSet();
    st = con.createStatement();
    String sql = "SELECT id_cidade, nome, uf FROM cidade";
    ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
    while(result.next()) {
         list.add(new CidadeBean(result.getInt(1), result.getString(2), result.getString(3))); //para cada elemento da lista cria um been do ambulatório (em memória) está passando os parâmetro pelo construtor
    }
    return list;
    }   
    
}
