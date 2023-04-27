package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CorModel {
    
    // MÈtodo para inserir uma nova cor no banco de dados
    public static void create(CorBean c, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO cor (nome_cor) VALUES (?)");
        st.setString(1, c.getNome_cor());
        st.execute();
        st.close();
    }

     // MÈtodo para excluir uma cor do banco de dados
    public static void deleteCor(Connection con, int id_cor) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("DELETE FROM cor WHERE id_cor = ?");
        st.setInt(1, id_cor);
        st.execute();
        st.close();   
    }
    
    public static void updateCor(CorBean cb, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("UPDATE cor SET nome_cor = ? WHERE id_cor = ?");
        st.setString(1, cb.getNome_cor());
        st.setInt(2, cb.getId_cor());
        st.executeUpdate();
        st.close();
    }

    
    //MÈtodo que imprime o que est· no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
        Statement st; //Usa um statement para acessar o banco
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_cor, nome_cor FROM cor";
        ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
        while(result.next()) {
            list.add(new CorBean(result.getInt(1), result.getString(2))); //para cada elemento da lista cria um been da cor (em mem√≥ria) e passa os par√¢metros pelo construtor
        }
        return list;
    }
}
