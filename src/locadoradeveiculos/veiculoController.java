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
 * @author Jï¿½ssica
 */
public class VeiculoController {
    
    public void createVeiculo(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um veículo: ");
        System.out.println("Placa do veículo: ");
        String placa = input.next();
        
        System.out.println("Quantidade de portas: ");
        int portas;
        while (!input.hasNextInt()) {
            System.out.println("Por favor, digite um número inteiro para portas:");
            input.next(); // limpar o valor invÃ¡lido do scanner
        }
        portas = input.nextInt();
        
        System.out.println("Ano do veículo: ");
        int ano = input.nextInt();
        input.nextLine(); //limpa o buffer do teclado
        System.out.println("Tipo de combustível: ");
        String combustivel = input.nextLine();
        System.out.println("Tipo de câmbio: ");
        String cambio = input.nextLine();
        System.out.println("Tipo de tração: ");
        String tracao = input.nextLine();
        System.out.println("ObservaÃ§Ã£o: ");
        String observacao = input.nextLine();
        
        System.out.println("Modelo: (Codigo do modelo) ");
        int modelo;
        while (!input.hasNextInt()) {
            System.out.println("Por favor, digite um numero inteiro para o modelo:");
            input.next(); // limpar o valor invÃ¡lido do scanner
        }
        modelo = input.nextInt();

        System.out.println("Cor: (Codigo da cor)");
        int cor;
         while (!input.hasNextInt()) {
            System.out.println("Por favor, digite um nÃºmero inteiro para cor:");
            input.next(); // limpar o valor invÃ¡lido do scanner
        }
        cor = input.nextInt();
        

        VeiculoBean vb = new VeiculoBean(placa, portas, ano, combustivel, cambio, tracao, observacao, modelo, cor);
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
    
    void listarVeiculoPorModelo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Filtro pelo modelo: ");
        String modelo = input.next();
        
        HashSet all = VeiculoModel.listAllFilterModel(con, modelo);
        Iterator<VeiculoBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toStringDetails());
        }
    }
}
