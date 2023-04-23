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

public class CidadeController {

    // Método para criar uma nova cidade no banco de dados
    public void createCidade(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome da cidade: ");
        String nome_cidade = input.nextLine();
        System.out.println("Insira o estado da cidade: ");
        String estado_cidade = input.nextLine();
        
        CidadeBean cb = new CidadeBean(nome_cidade, estado_cidade);
        CidadeModel.create(cb, con);
        System.out.println("Cidade criada com sucesso!!");   
    }
    
    //Método para deletar uma cidade do banco de dados
    public void deletarCidade(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o código da cidade que deseja deletar: ");
        int id_cidade = input.nextInt();

        try {
            // Verifica se o id da cidade informado é válido
            boolean cidadeExiste = false;
            HashSet all = CidadeModel.listAll(con);
            Iterator<CidadeBean> it = all.iterator();
            while (it.hasNext()) {
                CidadeBean fb = it.next();
                if (fb.getId_cidade() == id_cidade) {
                    cidadeExiste = true;
                    break;
                }
            }

            if (!cidadeExiste) {
                System.out.println("a cidade informada não existe!");
            } else {
                CidadeModel.deleteCidade(con, id_cidade);
                System.out.println("Cidade deletada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
    
    //Método para editar a cidade
    public void updateCidade(Connection con) throws SQLException {
    Scanner input = new Scanner(System.in);
    System.out.println("Insira o código da cidade que deseja atualizar: ");
    int id_cidade = input.nextInt();
    input.nextLine();
    System.out.println("Insira o novo nome da cidade: ");
    String nome_cidade = input.nextLine();
    System.out.println("Insira o novo estado da cidade:: ");
    String estado_cidade = input.nextLine();    
    CidadeBean cb = new CidadeBean(id_cidade, nome_cidade, estado_cidade);
    CidadeModel.updateCidade(cb, con);
    System.out.println("Cidade atualizada com sucesso!!");
}
    /*Chama todos as cidades do método listAll do model passando a conexão
    e salva no HashSet all 
    */   
    public void listarCidade(Connection con) throws SQLException {
        HashSet all = CidadeModel.listAll(con); 
        Iterator<CidadeBean> it = all.iterator();
        while(it.hasNext()) {
             System.out.println(it.next().toString());
        }
    }

}