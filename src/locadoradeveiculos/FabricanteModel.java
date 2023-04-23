package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FabricanteModel {
    
    // Método para inserir um novo fabricante no banco de dados
    public static void create(FabricanteBean a, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO fabricante (nome_fabricante) VALUES (?)");
        st.setString(1, a.getNome_fabricante());
        st.execute();
        st.close();
    }

     // Método para excluir um fabricante do banco de dados
    public static void deleteFabricante(Connection con, int id_fabricante) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("DELETE FROM fabricante WHERE id_fabricante = ?");
        st.setInt(1, id_fabricante);
        st.execute();
        st.close();   
    }
    
    public static void updateFabricante(FabricanteBean fb, Connection con) throws SQLException {
    PreparedStatement st;
    st = con.prepareStatement("UPDATE fabricante SET nome_fabricante = ? WHERE id_fabricante = ?");
    st.setString(1, fb.getNome_fabricante());
    st.setInt(2, fb.getId_fabricante());
    st.executeUpdate();
    st.close();
    }

    
    //Método que imprime o que está no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
    Statement st; //Usa um statement para acesar o banco
    HashSet list = new HashSet();
    st = con.createStatement();
    String sql = "SELECT id_fabricante, nome_fabricante FROM fabricante";
    ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
    while(result.next()) {
         list.add(new FabricanteBean(result.getInt(1), result.getString(2))); //para cada elemento da lista cria um been do ambulatório (em memória) está passando os parâmetro pelo construtor
    }
    return list;
}
    
}
