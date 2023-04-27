/*
 //Coleta os dados a inserir na tabela e manda para o Bean
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
        String combustivel = input.next();
        System.out.println("Tipo de câmbio: ");
        String cambio = input.next();
        System.out.println("Tipo de tracao: ");
        String tracao = input.next();
        System.out.println("Observação: ");
        String observacao = input.next();
        System.out.println("Modelo: ");
        String modelo = input.next();
        System.out.println("Cor: ");
        String cor = input.next();
        VeiculoBean vb = new VeiculoBean(placa, portas, ano, combustivel, cambio, tracao, observacao, Integer.parseInt(modelo), Integer.parseInt(cor));
        VeiculoModel.create(vb, con);
        System.out.println("Veiculo Registrado com Sucesso");
    }
    
    public void listarVeiculos(Connection con) throws SQLException {
        HashSet all = VeiculoModel.listAll(con); 
        Iterator<VeiculoBean> it = all.iterator();
        while(it.hasNext()) {
             System.out.println(it.next().toString());
        }
    }
}
