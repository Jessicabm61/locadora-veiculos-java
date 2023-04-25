/*
 //Coleta os dados a inserir na tabela e manda para o Bean
 */
package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Jéssica
 */
public class VeiculoController {
    
    public void createVeiculo(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um veículo: ");
        System.out.println("Placa do veiculo: ");
        String placa = input.next();
        System.out.println("Quantidade de portas: ");
        int portas = input.nextInt();
        System.out.println("Ano do veiculo: ");
        int ano = input.nextInt();
        System.out.println("Tipo de combustível: ");
        char[] combustivel = input.next().toCharArray();
        System.out.println("Tipo de câmbio: ");
        char[] cambio = input.next().toCharArray();
        System.out.println("Tipo de tracao: ");
        char[] tracao = input.next().toCharArray();
        System.out.println("Observação: ");
        char[] observacao = input.next().toCharArray();
        VeiculoBean vb = new VeiculoBean(placa, portas, ano, combustivel, cambio, tracao, observacao);
        VeiculoModel.create(vb, con);
        System.out.println("Veiculo Registrado com Sucesso");
    }
}
