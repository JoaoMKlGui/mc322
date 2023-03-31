package Main;
import java.util.Calendar;

import Clientes.*;

public class Main {
    public static void main(String[] args) {
        
        Calendar dataLicenca = Calendar.getInstance();
        Calendar dataNascimento = Calendar.getInstance();

        dataLicenca.set(Calendar.YEAR, 2023);
        dataLicenca.set(Calendar.MONTH, Calendar.MARCH);
        dataLicenca.set(Calendar.DAY_OF_MONTH, 30);

        dataNascimento.set(Calendar.YEAR, 2003);
        dataNascimento.set(Calendar.MONTH, Calendar.DECEMBER);
        dataNascimento.set(Calendar.DAY_OF_MONTH, 31);


        ClientePJ cliente = new ClientePJ("joao", "jacarandas", dataLicenca, "Ensino Superior", "Masculino", "Alta", "63.779.010/0001-97", dataNascimento);
        System.out.println(cliente.toString());
        System.out.println(cliente.validarCNPJ());

    }

    
}
