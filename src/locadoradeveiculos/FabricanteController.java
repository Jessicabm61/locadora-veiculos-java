package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FabricanteController {

    // Método para criar um fabricante no banco de dados
    public void createFabricante(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do fabricante: ");
        String nome_fabricante = input.nextLine();
        FabricanteBean fb = new FabricanteBean(nome_fabricante);
        FabricanteModel.create(fb, con);
     System.out.println("Fabricante criado com sucesso!!");   
    }
    
    public void deletarFabricantes(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o código do fabricante que deseja deletar: ");
        int id_fabricante = input.nextInt();

        try {
            // Verifica se o id do fabricante informado é válido
            boolean fabricanteExiste = false;
            HashSet all = FabricanteModel.listAll(con);
            Iterator<FabricanteBean> it = all.iterator();
            while (it.hasNext()) {
                FabricanteBean fb = it.next();
                if (fb.getId_fabricante() == id_fabricante) {
                    fabricanteExiste = true;
                    break;
                }
            }

            if (!fabricanteExiste) {
                System.out.println("O fabricante informado não existe!");
            } else {
                FabricanteModel.deleteFabricante(con, id_fabricante);
                System.out.println("Fabricante deletado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
    
    /*Chama todos os fabricantes do método listAll do model passando a conexão
    e salva no HashSet all 
    */   
    public void listarFabricantes(Connection con) throws SQLException {
        HashSet all = FabricanteModel.listAll(con); 
        Iterator<FabricanteBean> it = all.iterator();
        while(it.hasNext()) {
             System.out.println(it.next().toString());
        }
    }

}