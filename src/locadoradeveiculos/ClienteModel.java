package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClienteModel {
    
    // M�todo para inserir um novo cliente no banco de dados
    public static void create(ClienteBean c, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO cliente (nome, cpf, email, rua, bairro, telefone) VALUES (?, ?, ?, ?, ?, ?)");
        st.setString(1, c.getNome());
        st.setString(2, c.getCpf());
        st.setString(3, c.getTelefone());
        st.setString(4, c.getRua());
        st.setString(5, c.getBairro());
        st.setString(6, c.getTelefone());
        st.setInt(7, c.getId_cidade());
        st.execute();
        st.close();
    }

    // M�todo para excluir um cliente do banco de dados
    public static void deleteCliente(Connection con, int id_cliente) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
        st.setInt(1, id_cliente);
        st.execute();
        st.close();   
    }

    // M�todo para atualizar as informa��es de um cliente no banco de dados
    public static void updateCliente(ClienteBean cb, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, email = ?, rua = ?, bairro = ?, telefone = ?");
        st.setString(1, cb.getNome());
        st.setString(2, cb.getCpf());
        st.setString(3, cb.getEmail());
        st.setString(4, cb.getRua());
        st.setString(5, cb.getBairro());
        st.setString(6, cb.getTelefone());
        st.executeUpdate();
        st.close();
    }

    // M�todo que retorna uma lista de todos os clientes cadastrados no banco de dados
        static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_cliente, nome, cpf, email, rua, bairro, telefone, id_cidade";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            ClienteBean cb = new ClienteBean(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
            result.getString(6), result.getInt(7));
            list.add(cb);
        }
        return list;
    }
}
