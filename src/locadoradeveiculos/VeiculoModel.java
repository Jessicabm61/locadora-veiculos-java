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
    
    //Metodo que imprime o que esta no banco de dados
    static HashSet listAll(Connection con) throws SQLException {
        Statement st; //Usa um statement para acessar o banco
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_carro, placa, portas, ano, combustivel, cambio, tracao, observacao, id_modelo, id_cor FROM carro";
        ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
        while(result.next()) {
            list.add(new VeiculoBean(result.getInt(1),result.getString(2), result.getInt(3), result.getInt(4),
            		result.getString(5), result.getString(6), result.getString(7), result.getString(8),
            		result.getInt(9), result.getInt(10))); //para cada elemento da lista cria um been do modelo (em mem�ria) e passa os par�metros pelo construtor
        }
        return list;
    }
    
    static HashSet listAllFilterModel(Connection con, String modelo) throws SQLException {
        Statement st; //Usa um statement para acessar o banco
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT placa, portas, ano, combustivel, cambio, tracao, observacao, carro.id_modelo, id_cor, modelo.nome_modelo FROM carro "
        		+ "JOIN modelo ON modelo.id_modelo = carro.id_modelo AND modelo.nome_modelo = '" + modelo + "'";
        ResultSet result = st.executeQuery(sql); //retorna uma lista e salva no Resultset result
        while(result.next()) {
            VeiculoBean vb = new VeiculoBean(result.getString(1), result.getInt(2), result.getInt(3),
            				 result.getString(4), result.getString(5), result.getString(6), result.getString(7),
            				 result.getInt(8), result.getInt(9)); 
            ModeloBean mb = new ModeloBean(result.getString(10));
            vb.setMb(mb);
            list.add(vb);            
        }
        return list;	
    }
}

