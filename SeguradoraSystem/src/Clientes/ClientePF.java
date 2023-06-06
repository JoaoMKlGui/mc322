package Clientes;
import java.util.Calendar;
import Auxiliares.CalculoSeguro;
import Auxiliares.Datas;
import java.time.LocalDate;
import java.time.Period;

import Main.Seguradora;

public class ClientePF extends Cliente {
    final private String cpf;
    private Calendar dataNascimento;

    public ClientePF(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEco, String cpf, Calendar dataNascimento, Seguradora seguradora) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEco, seguradora);
        this.cpf = cpf.replaceAll("[^0-9]+", "");
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

    public int calcularIdade() {

        String diaNascimento;

        if(Integer.parseInt(Datas.pegarDiaDoNascimento(dataNascimento)) < 10) {
            diaNascimento = "0" + Datas.pegarDiaDoNascimento(this.dataNascimento);
        } else {
            diaNascimento = Datas.pegarDiaDoNascimento(dataNascimento);
        }

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
            return (CalculoSeguro.VALOR_BASE.valor * CalculoSeguro.FATOR_18_30.valor * this.getVeiculos().size());

        } else if (idade >= 30 && idade <= 60) {
            return (CalculoSeguro.VALOR_BASE.valor * CalculoSeguro.FATOR_30_60.valor * this.getVeiculos().size());

        } else {
            return (CalculoSeguro.VALOR_BASE.valor * CalculoSeguro.FATOR_60_90.valor * this.getVeiculos().size());
        }

    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + this.cpf + "\n" + "Data de Nascimento: " + String.valueOf(this.dataNascimento.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataNascimento.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataNascimento.get(Calendar.YEAR)) + "\n";
    }

}
