package Auxiliares;
import java.time.LocalDate;
import java.util.Calendar;

public class Datas {
    
    //classe feita para auxiliar na manipulação de datas com calendar

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

    public static String converteCalendarParaString(Calendar data) {
        String dia = String.valueOf(data.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(data.get(Calendar.MONTH + 1));
        String ano = String.valueOf(data.get(Calendar.YEAR));

        return ( dia + "/" + mes + "/" + ano );
    }

}
