package locadoradeveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LocacaoController {
    // M�todo para criar um modelo no banco de dados
    public void createLocacao(Connection con) throws SQLException, ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira a data da locação no formato dd/MM/yyyy: ");
        String dt_locacao = input.nextLine();
        System.out.println("Insira o id do carro: ");
        String carro = input.nextLine();
        System.out.println("Insira o id do cliente: ");
        String cliente = input.nextLine();
        
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dt_locacao);
        
        LocacaoBean mb = new LocacaoBean(date, Integer.parseInt(carro), Integer.parseInt(cliente));
        LocacaoModel.create(mb, con);
        System.out.println("Modelo criado com sucesso!!");   
    }
    
    public void listarLocacao(Connection con) throws SQLException {
        HashSet all = LocacaoModel.listAll(con); 
        Iterator<LocacaoBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    }