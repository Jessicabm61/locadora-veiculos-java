/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jéssica
 */
public class Conexao {
    private Connection con;
    
    public Conexao(){
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String senha  = "admin";
        String url    = "jdbc:postgresql://localhost:5432/postgres";
        
        try{
            Class.forName(driver);
            this.con = (Connection) DriverManager.getConnection(url, user, senha);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }

    Connection getConnection() {
        return con;
    }
}