package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Jessica
 */
public class Principal {

    public static void main(String[] args) throws SQLException, ParseException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                	case 0: break; 
                    case 1: new VeiculoController().createVeiculo(con);
                            break;
                    
                    case 2: new VeiculoController().listarVeiculos(con);
                            break;      
                    case 3:
                            new CidadeController().createCidade(con);
                            break;
                    case 4:
                            new CidadeController().listarCidade(con);
                            break;
                    case 5:
                            new CidadeController().deletarCidade(con);
                            break;
                    case 6:
                            new CidadeController().updateCidade(con);
                            break;
                    case 7:
                            new CorController().createCor(con);
                            break;
                    case 8:
                            new CorController().listarCores(con);
                            break;
                    case 9:
                            new CorController().deletarCores(con);
                            break;
                    case 10:
                            new CorController().updateCor(con);
                            break;
                    case 11:
                            new ClienteController().createCliente(con);
                            break;
                    case 12:
                            new ClienteController().listarClientes(con);
                            break;
                    case 13:
                            new ClienteController().deletarCliente(con);
                            break;
                    case 14:
                            new ClienteController().updateCliente(con);
                            break;    
                    case  15:
                            new LocacaoController().createLocacao(con);
                            break;  
                    case  16:
                            new LocacaoController().listarLocacao(con);
                            break;
                    case  17:
                            new ModeloController().createModelo(con);
                            break;                             
                    case 18:                            
                            new ModeloController().listAll(con);
                            break;
                    case 19:
                            new ClienteController().listarClientesLocacao(con);
                            break;   
                    case 20:
                    		new VeiculoController().listarVeiculoPorModelo(con);
                    		break;
                    		
                }
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<23);  
        
        con.close();
    }    

    private static int menu() {
        System.out.println("--------------------------------------");
        System.out.println(" ");
        System.out.println("VEÍCULOS");
        System.out.println("1 - Registrar novo veiculo ");
        System.out.println("2 - Exibir todos os veiculos ");

        System.out.println(" ");
        System.out.println("CIDADES");
        System.out.println("3  - Registrar nova cidade");
        System.out.println("4  - Exibir todas as cidades");
        System.out.println("5  - Deletar cidade");
        System.out.println("6  - Editar cidade");

        System.out.println(" ");
        System.out.println("CORES");
        System.out.println("7  - Registrar nova cor");
        System.out.println("8  - Exibir todas as cores");
        System.out.println("9  - Deletar cor");
        System.out.println("10 - Editar cor");

        System.out.println(" ");
        System.out.println("CLIENTES");
        System.out.println("11 - Registrar novo cliente");
        System.out.println("12 - Exibir todos os clientes");
        System.out.println("13 - Deletar cliente");
        System.out.println("14 - Editar cliente");
        
        System.out.println(" ");
        System.out.println("LOCAÇÃO");
        System.out.println("15 - Registrar Locacao ");
        System.out.println("16 - Exibir todas as Locacoes");
        
        System.out.println(" ");
        System.out.println("MODELO CARRO");
        System.out.println("17 - Registrar modelo ");
        System.out.println("18 - Exibir todos os modelos ");
        
        System.out.println(" ");
        System.out.println("RELATORIOS");
        System.out.println("19 - Exibir todos os clientes e seus respectivos carros locados");
        System.out.println("20 - Veiculos por modelo");
        
        System.out.println("0 - Sair");
        System.out.println("Digite a opção: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}