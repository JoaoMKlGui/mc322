package Main;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import Clientes.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calendar dataFundacao = Calendar.getInstance();

        System.out.println("Você quer adicionar um cliente PJ ou PF? Digite sua resposta");

        String tipoCliente = scanner.nextLine();
        tipoCliente = tipoCliente.toUpperCase();

        String dataLic = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] partes_da_data = dataLic.split("_");
        int anoLicenca = Integer.parseInt(partes_da_data[0]);
        int mesLicenca = Integer.parseInt(partes_da_data[1]) - 1;
        int diaLicenca = Integer.parseInt(partes_da_data[2]);

        Calendar dataLicenca = Calendar.getInstance();
        dataLicenca.set(Calendar.YEAR, anoLicenca);
        dataLicenca.set(Calendar.MONTH, mesLicenca);
        dataLicenca.set(Calendar.DAY_OF_MONTH, diaLicenca);
        if(tipoCliente.equals("PF")) {
            System.out.println("Digite o nome do cliente");
            String nome = scanner.nextLine();
            System.out.println("Digite o endereço");
            String endereco = scanner.nextLine();
            System.out.println("Digite o nível de educação");
            String nivelEducacao = scanner.nextLine();
            System.out.println("Digite o gênero");
            String genero = scanner.nextLine();
            System.out.println("Digite a classe econômica");
            String classeEco = scanner.nextLine();
            System.out.println("Digite a data de nascimento no formato DD/MM/YYYY");
            String data = scanner.nextLine();
            String[] infoNascimento = data.split("/");
            int diaNascimento = Integer.parseInt(infoNascimento[0]);
            int mesNascimento = Integer.parseInt(infoNascimento[1]) - 1;
            int anoNascimento = Integer.parseInt(infoNascimento[2]);
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.set(Calendar.YEAR, anoNascimento);
            dataNascimento.set(Calendar.MONTH, mesNascimento);
            dataNascimento.set(Calendar.DAY_OF_MONTH, diaNascimento);

            System.out.println("Digite o cpf");
            String cpf = scanner.nextLine();
            
            Cliente novoCliente = new ClientePF(nome, endereco, dataLicenca, nivelEducacao, genero, classeEco, cpf, dataNascimento);
            System.out.println(novoCliente.toString());
        } else {

            System.out.println("n pode pj, foi mal");

        }

        scanner.close();

    }

    
}
