package locadoradeveiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    case 1: new veiculoController().createVeiculo(con);
                            break;
                    
                    case 2: 
                            break;
                    
                    case 3:
                            new FabricanteController().createFabricante(con);
                            break;
                    case 4:
                            new FabricanteController().listarFabricantes(con);
                            break;
                    case 5:
                            new FabricanteController().listarFabricantes(con);
                            break;
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<8);  
        con.close();
    }    

    private static int menu() {
        System.out.println(" ");
        System.out.println("Informe o número da opção que deseja executar: ");
        System.out.println("1 - Registrar novo veiculo: ");
        System.out.println("2 - Exibir todos os veículos: ");
        System.out.println("3 - Registrar novo fabricante: ");
        System.out.println("4 - Exibir todos os fabricantes: ");
        System.out.println("5 - Deletar fabricante: ");
        System.out.println("5 - Mostrar Cliente: ");
        System.out.println("6 - Registrar Locacao: ");
        System.out.println("7 - Inserir um novo cliente: ");
        System.out.println("8 - Sair");
        System.out.println("Digite a opção: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

}
