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
 * @author Jéssica
 */
public class VeiculoModel {
    public static void create(VeiculoBean a, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO carro (placa, portas, ano, combustivel, cambio, tracao, observacao, id_modelo, id_cor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, a.getPlaca());
        st.setInt(2, a.getPortas());
        st.setInt(3, a.getAno());
        st.setString(4, new String(a.getCombustivel()));
        st.setString(5, new String(a.getCambio()));
        st.setString(6, new String(a.getTracao()));
        st.setString(7, new String(a.getObservacao()));
        st.setInt(8, a.getId_modelo());
        st.setInt(9, a.getId_cor());
        st.executeUpdate();
    }
    
    //Método que imprime o que está no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
        Statement st; //Usa um statement para acessar o banco
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT placa, portas, ano, combustivel, cambio, tracao, observacao, id_modelo, id_cor FROM carro";
        ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
        while(result.next()) {
            list.add(new VeiculoBean(result.getString(1), result.getInt(2), result.getInt(3),
            		result.getString(4), result.getString(5), result.getString(6), result.getString(7),
            		result.getInt(8), result.getInt(9))); //para cada elemento da lista cria um been do modelo (em memória) e passa os parâmetros pelo construtor
        }
        return list;
    }
}

