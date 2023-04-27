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
 * @author Jessica
 */
public class ModeloModel {
	
    // Metodo para inserir um novo modelo no banco de dados
    public static void create(ModeloBean m, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO modelo (nome_modelo) VALUES (?)");
        st.setString(1, m.getNome_modelo());
        st.execute();
        st.close();
    }
    
    //MÈtodo que imprime o que est· no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
        Statement st; //Usa um statement para acessar o banco
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_modelo, nome_modelo, id_fabricante FROM cor";
        ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
        while(result.next()) {
            list.add(new ModeloBean(result.getInt(1), result.getString(2), result.getInt(3))); //para cada elemento da lista cria um been da cor (em mem√≥ria) e passa os par√¢metros pelo construtor
        }
        return list;
    }
}
