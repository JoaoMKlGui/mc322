package Main;
import java.util.Calendar;

public class Datas {
    
    public static String pegarDiaDoNascimento(Calendar dataNascimento) {
        return String.valueOf(dataNascimento.get(Calendar.DAY_OF_MONTH));
    }

    public static String pegarMesDoNascimento(Calendar dataNascimento) {
        return String.valueOf(dataNascimento.get(Calendar.MONTH) + 1);
    }

    public static String pegarAnoDoNascimento(Calendar dataNascimento) {
        return String.valueOf(dataNascimento.get(Calendar.YEAR));
    }

}
