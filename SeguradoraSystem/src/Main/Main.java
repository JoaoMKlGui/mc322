package Main;
import java.util.Calendar;
import java.util.ArrayList;
import Clientes.*;

public class Main {
    public static void main(String[] args) {

        Calendar dataLicenca = Calendar.getInstance();
        Calendar dataFundacao = Calendar.getInstance();

        dataLicenca.set(Calendar.YEAR, 2023);
        dataLicenca.set(Calendar.MONTH, Calendar.MARCH);
        dataLicenca.set(Calendar.DAY_OF_MONTH, 30);

        dataFundacao.set(Calendar.YEAR, 2003);
        dataFundacao.set(Calendar.MONTH, Calendar.DECEMBER);
        dataFundacao.set(Calendar.DAY_OF_MONTH, 31);


        ClientePJ cliente = new ClientePJ("joao", "jacarandas", dataLicenca, "Ensino Superior", "Masculino", "Alta", "63.779.010/0001-97", dataFundacao);

        Veiculo novoVeiculo = new Veiculo("GIT-0000", "Ford", "Mustang", 2019);
        Seguradora seguradora = new Seguradora("Seguradora do joaozinho", "(19)90000-0000", "oi@gmail.com", "albert einstein");

        cliente.adicionarVeiculo(novoVeiculo);
        seguradora.cadastrarCliente(cliente);

        ArrayList<Cliente> listaDeClientes = seguradora.listarClientes();
        
        for(Cliente c : listaDeClientes) {
            System.out.println(c.toString());
        }

    }

    
}
