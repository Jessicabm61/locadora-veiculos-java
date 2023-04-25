/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jéssica
 */
public class ModeloController {
	
    // Método para criar um modelo no banco de dados
    public void createModelo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do modelo: ");
        String nome_modelo = input.nextLine();
        ModeloBean mb = new ModeloBean();
        ModeloModel.create(mb, con);
        System.out.println("Modelo criado com sucesso!!");   
    }
    
    //Método para deletar um modelo no banco de dados
    public void deletarModelo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o código do modelo que deseja deletar: ");
        int id_cor = input.nextInt();

        try {
            // Verifica se o id do modelo informado é válido
            boolean modeloExiste = false;
            HashSet all = ModeloModel.listAll(con);
            Iterator<ModeloBean> it = all.iterator();
            while (it.hasNext()) {
                ModeloBean mb = it.next();
                if (mb.getId_modelo() == id_cor) {
                    modeloExiste = true;
                    break;
                }
            }

            if (!modeloExiste) {
                System.out.println("O modelo informado não existe!");
            } else {
                CorModel.deleteCor(con, id_cor);
                System.out.println("Modelo deletado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   	
    }
}


