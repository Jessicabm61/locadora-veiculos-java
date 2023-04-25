/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 *
 * @author J�ssica
 */
public class ModeloModel {
	
    // M�todo para inserir um novo modelo no banco de dados
    public static void create(ModeloBean m, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO modelo (nome_modelo, id_fabricante) VALUES (?)");
        st.setString(1, m.getNome_modelo());
        st.setInt(2, m.getId_fabricante());
        st.execute();
        st.close();
    }

     // M�todo para excluir um modelo do banco de dados
    public static void deleteModelo(Connection con, int id_modelo) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("DELETE FROM modelo WHERE id_modelo = ?");
        st.setInt(1, id_modelo);
        st.execute();
        st.close();   
    }
    
    //M�todo para atualizar um modelo do banco de dados
    public static void updateModelo(ModeloBean mb, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("UPDATE modelo SET nome_modelo = ?, id_fabricante = ? WHERE id_modelo = ?");
        st.setString(1, mb.getNome_modelo());
        st.setInt(2, mb.getId_fabricante());
        st.setInt(3, mb.getId_modelo());
        st.executeUpdate();
        st.close();
    }

    
    //M�todo que imprime o que est� no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
        Statement st; //Usa um statement para acessar o banco
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_modelo, nome_modelo, id_fabricante FROM modelo";
        ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
        while(result.next()) {
            list.add(new CorBean(result.getInt(1), result.getString(2))); //para cada elemento da lista cria um been do modelo (em mem�ria) e passa os par�metros pelo construtor
        }
        return list;
    }
}
