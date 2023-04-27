package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Jéssica
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new VeiculoController().createVeiculo(con);
                            break;
                    
                    case 2: new VeiculoController().listarVeiculos(con);
                            break;      
                    
                    case 3:
                            new FabricanteController().createFabricante(con);
                            break;
                    case 4:
                            new FabricanteController().listarFabricantes(con);
                            break;
                    case 5:
                            new FabricanteController().deletarFabricantes(con);
                            break;
                    case 6:
                            new FabricanteController().updateFabricante(con);
                            break;
                    case 7:
                            new CidadeController().createCidade(con);
                            break;
                    case 8:
                            new CidadeController().listarCidade(con);
                            break;
                    case 9:
                            new CidadeController().deletarCidade(con);
                            break;
                    case 10:
                            new CidadeController().updateCidade(con);
                            break;
                    case 11:
                            new CorController().createCor(con);
                            break;
                    case 12:
                            new CorController().listarCores(con);
                            break;
                    case 13:
                            new CorController().deletarCores(con);
                            break;
                    case 14:
                            new CorController().updateCor(con);
                            break;
                    case 15:
                            new ClienteController().createCliente(con);
                            break;
                    case 16:
                            new ClienteController().listarClientes(con);
                            break;
                    case 17:
                            new ClienteController().deletarCliente(con);
                            break;
                    case 18:
                            new ClienteController().updateCliente(con);
                            break;  
                            
                            
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<100);  
        
        con.close();
    }    

    private static int menu() {
        System.out.println(" ");
        System.out.println("Informe o número da opção que deseja executar: ");
        System.out.println("1 - Registrar novo veiculo: ");
        System.out.println("2 - Exibir todos os veículos: ");
        
        System.out.println("3  - Registrar novo fabricante");
        System.out.println("4  - Exibir todos os fabricantes");
        System.out.println("5  - Deletar fabricante");
        System.out.println("6  - Editar fabricante");
        
        System.out.println("7  - Registrar nova cidade");
        System.out.println("8  - Exibir todas as cidades");
        System.out.println("9  - Deletar cidade");
        System.out.println("10 - Editar cidade");

        System.out.println("11 - Registrar nova cor");
        System.out.println("12 - Exibir todas as cores");
        System.out.println("13 - Deletar cor");
        System.out.println("14 - Editar cor");
        
        System.out.println("15 - Registrar novo cliente");
        System.out.println("16 - Exibir todos os clientes");
        System.out.println("17 - Deletar cliente");
        System.out.println("18 - Editar cliente");

        System.out.println("19 - Registrar Locacao: ");
        System.out.println("20 - Sair");
        System.out.println("Digite a opção: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

}