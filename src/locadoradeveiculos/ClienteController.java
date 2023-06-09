package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClienteController {

    // M�todo para criar um cliente no banco de dados
    public void createCliente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("Insira o CPF do cliente: ");
        String cpf = input.nextLine();
        System.out.println("Insira o e-mail do cliente: ");
        String email = input.nextLine();
        System.out.println("Insira a rua do cliente: ");
        String rua = input.nextLine();
        System.out.println("Insira o bairro do cliente: ");
        String bairro = input.nextLine();
        System.out.println("Insira o telefone do cliente: ");
        String telefone = input.nextLine();
        int cidade = 0;
        while (true) {
            System.out.println("Insira o c�digo cidade do cliente: ");
            String inputStr = input.nextLine();

            try {
                cidade = Integer.parseInt(inputStr);
                break; // Se a entrada � v�lida, sair do loop
            } catch (NumberFormatException e) {
                System.out.println("Entrada inv�lida. Insira um valor inteiro.");
            }
        }
        
        
        ClienteBean cb = new ClienteBean(nome, cpf, email, rua, bairro, telefone, cidade);
        ClienteModel.create(cb, con);
        System.out.println("Cliente criado com sucesso!!");
    }

    // Metodo para deletar um cliente do banco de dados
    public void deletarCliente(Connection con) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o codigo do cliente que deseja deletar: ");
        int id_cliente = input.nextInt();

        try {
            // Verifica se o id do cliente informado eh valido
            boolean clienteExiste = false;
            HashSet all = ClienteModel.listAll(con);
            Iterator<ClienteBean> it = all.iterator();
            while (it.hasNext()) {
                ClienteBean cb = it.next();
                if (cb.getId_cliente() == id_cliente) {
                    clienteExiste = true;
                    break;
                }
            }

            if (!clienteExiste) {
                System.out.println("O cliente informado no existe!");
            } else {
                ClienteModel.deleteCliente(con, id_cliente);
                System.out.println("Cliente deletado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo para atualizar um cliente do banco de dados
    public void updateCliente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o c�digo do cliente que deseja atualizar: ");
        int id_cliente = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado
        System.out.println("Insira o novo nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("Insira o novo CPF do cliente: ");
        String cpf = input.nextLine();
        System.out.println("Insira o novo e-mail do cliente: ");
        String email = input.nextLine();
        System.out.println("Insira a nova rua do cliente: ");
        String rua = input.nextLine();
        System.out.println("Insira o novo bairro do cliente: ");
        String bairro = input.nextLine();
        System.out.println("Insira o novo telefone do cliente: ");
        String telefone = input.nextLine();
        System.out.println("Insira a nova cidade do cliente: ");
        String cidade = input.nextLine();
        
        ClienteBean cb = new ClienteBean(nome, cpf, email, rua, bairro, telefone, Integer.parseInt(cidade));
        ClienteModel.updateCliente(cb, con);
        System.out.println("Cliente atualizado com sucesso!");
    }
    
    public void listarClientes(Connection con) throws SQLException {
        HashSet all = ClienteModel.listAll(con); 
        Iterator<ClienteBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    void listarClientesLocacao(Connection con) throws SQLException {
        HashSet all = ClienteModel.listAllWithLocacao(con);
        Iterator<ClienteBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toStringDetails());
        }
    }
    

}    
