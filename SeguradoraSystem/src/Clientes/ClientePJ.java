package Clientes;
import java.util.Calendar;

import Main.CalculoSeguro;

public class ClientePJ extends Cliente {
    final private String cnpj;
    private Calendar dataFundacao;
    private int quantidadeFuncionarios;

    public ClientePJ(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEco, String cnpj, Calendar dataFundacao, int quantidadeFuncionarios) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEco);
        this.cnpj = cnpj;
        this.setDataFundacao(dataFundacao);
        this.setQuantidadeFuncionarios(quantidadeFuncionarios);
    }

    private void setDataFundacao(Calendar dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public Calendar getDataFund() {
        return this.dataFundacao;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    @Override
    public double calculaScore() {
        return CalculoSeguro.VALOR_BASE.valor * (1 + (this.getQuantidadeFuncionarios()/100)) * this.getVeiculos().size();
    }

    @Override
    public String toString() {
        return super.toString() + "CNPJ: " + this.cnpj + "\n" + "Data de Fundação: " + String.valueOf(this.dataFundacao.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataFundacao.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataFundacao.get(Calendar.YEAR)) + "\n";
    }

}
