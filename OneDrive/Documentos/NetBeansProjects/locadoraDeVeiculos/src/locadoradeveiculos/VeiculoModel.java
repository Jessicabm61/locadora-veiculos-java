/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jéssica
 */
public class VeiculoModel {
    public static void create(VeiculoBean a, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO carro (placa, portas, ano, combustivel, cambio, tracao, observacao) VALUES (?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, a.getPlaca());
        st.setInt(2, a.getPortas());
        st.setInt(3, a.getAno());
        st.setString(4, new String(a.getCombustivel()));
        st.setString(5, new String(a.getCambio()));
        st.setString(6, new String(a.getTracao()));
        st.setString(7, new String(a.getObservacao()));
        st.executeUpdate();
    }
}

