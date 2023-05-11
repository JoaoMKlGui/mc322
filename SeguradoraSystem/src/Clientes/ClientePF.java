package Clientes;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import Main.CalculoSeguro;
import Main.Datas;

public class ClientePF extends Cliente {
    final private String cpf;
    private Calendar dataNascimento;

    public ClientePF(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEco, String cpf, Calendar dataNascimento) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEco);
        this.cpf = cpf;
        this.setDataNascimento(dataNascimento);
    }

    private void setDataNascimento(Calendar dataNasicmento) {
        this.dataNascimento = dataNasicmento;
    }

    public String getCPF() {
        return this.cpf;
    }

    public Calendar getDataNascimento() {
        return this.dataNascimento;
    }

    private int calcularIdade() {

        String diaNascimento = Datas.pegarDiaDoNascimento(this.dataNascimento);
        String mesNascimento = Datas.pegarMesDoNascimento(this.dataNascimento); 
        String anoNascimento = Datas.pegarAnoDoNascimento(this.dataNascimento);
        String dataNascimentoString = anoNascimento + '-' + mesNascimento + '-' + diaNascimento;
        LocalDate dataNascimentoLocalDate = LocalDate.parse(dataNascimentoString); //converte a data de nascimento do cliente para um objeto localdate para utilizar na classe period

        LocalDate dataHoje = LocalDate.now(); 
        return Period.between(dataNascimentoLocalDate, dataHoje).getYears();
    }

    @Override
    public double calculaScore() {

        int idade = this.calcularIdade();

        if (idade >= 18 && idade < 30) {
            return (CalculoSeguro.VALOR_BASE.valor * 1.25 * this.getVeiculos().size());

        } else if (idade >= 30 && idade <= 60) {
            return (CalculoSeguro.VALOR_BASE.valor * 1 * this.getVeiculos().size());

        } else {
            return (CalculoSeguro.VALOR_BASE.valor * 1.5 * this.getVeiculos().size());
        }

    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + this.cpf + "\n" + "Data de Nascimento: " + String.valueOf(this.dataNascimento.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataNascimento.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataNascimento.get(Calendar.YEAR)) + "\n";
    }

}
