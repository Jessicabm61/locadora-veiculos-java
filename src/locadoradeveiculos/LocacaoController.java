package locadoradeveiculos;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LocacaoController {
    // Método para criar um modelo no banco de dados
    public void createLocacao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira a data da locação: ");
        String dt_locacao = input.nextLine();
        System.out.println("Insira o id do carro: ");
        String carro = input.nextLine();
        System.out.println("Insira o id do funcionario: ");
        String funcionario = input.nextLine();
        System.out.println("Insira o id do cliente: ");
        String cliente = input.nextLine();
        
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dt_locacao);
        
        LocacaoBean mb = new LocacaoBean(date, Integer.parseInt(carro), Integer.parseInt(funcionario), Integer.parseInt(cliente));
        LocacaoModel.create(mb, con);
        System.out.println("Modelo criado com sucesso!!");   
    }
}
