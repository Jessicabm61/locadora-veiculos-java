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
 * @author Jessica
 */
public class ModeloController {
	
    // Metodo para criar um modelo no banco de dados
    public void createModelo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do modelo: ");
        String nome_modelo = input.nextLine();
        ModeloBean mb = new ModeloBean(nome_modelo);
        ModeloModel.create(mb, con);
        System.out.println("Modelo criado com sucesso!!");   
    }
    
    public void listAll(Connection con) throws SQLException {
        HashSet all = ModeloModel.listAll(con); 
        Iterator<ModeloBean> it = all.iterator();
        while(it.hasNext()) {
             System.out.println(it.next().toString());
        }
    }
    
    void listModeloPorFabricante(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Filtro pelo fabricante: ");
        String fabricante = input.next();
        
        HashSet all = ModeloModel.listAllFilterFabricante(con, fabricante);
        Iterator<ModeloBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toStringDetails());
        }
    }
}


