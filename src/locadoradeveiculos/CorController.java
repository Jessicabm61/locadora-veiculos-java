package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CorController {

    // M�todo para criar uma cor no banco de dados
    public void createCor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome da cor: ");
        String nome_cor = input.nextLine();
        CorBean cb = new CorBean(nome_cor);
        CorModel.create(cb, con);
        System.out.println("Cor criada com sucesso!!");   
    }
    
    //Método para deletar uma cor do banco de dados
    public void deletarCores(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o c�digo da cor que deseja deletar: ");
        int id_cor = input.nextInt();

        try {
            // Verifica se o id da cor informada é válido
            boolean corExiste = false;
            HashSet all = CorModel.listAll(con);
            Iterator<CorBean> it = all.iterator();
            while (it.hasNext()) {
                CorBean cb = it.next();
                if (cb.getId_cor() == id_cor) {
                    corExiste = true;
                    break;
                }
            }

            if (!corExiste) {
                System.out.println("A cor informada não existe!");
            } else {
                CorModel.deleteCor(con, id_cor);
                System.out.println("Cor deletada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
    
    //Método para editar a cor
    public void updateCor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o código da cor que deseja atualizar: ");
        int id_cor = input.nextInt();
        input.nextLine();
        System.out.println("Insira o novo nome da cor: ");
        String nome_cor = input.nextLine();
        CorBean cb = new CorBean(id_cor, nome_cor);
        CorModel.updateCor(cb, con);
        System.out.println("Cor atualizada com sucesso!!");
    }

    
    /*Chama todas as cores do método listAll do model passando a conexão
    e salva no HashSet all 
    */   
    public void listarCores(Connection con) throws SQLException {
        HashSet all = CorModel.listAll(con); 
        Iterator<CorBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
