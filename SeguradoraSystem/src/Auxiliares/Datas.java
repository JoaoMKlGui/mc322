package Auxiliares;
import java.time.LocalDate;
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

    public static LocalDate dataHoje() {
        return LocalDate.now();
    }

    public static Calendar converteLocalDateParaCalendar(LocalDate data) {
        Calendar novoCalendar = Calendar.getInstance();
        novoCalendar.set(Calendar.YEAR, data.getYear());
        novoCalendar.set(Calendar.MONTH, data.getMonthValue() - 1);
        novoCalendar.set(Calendar.DAY_OF_MONTH, data.getDayOfMonth());

        return novoCalendar;
    }
}
