package Clientes;
import java.util.ArrayList;
import java.util.Calendar;
import Auxiliares.*;
import Main.Frota;
import Main.Seguradora;
import Main.Veiculo;

import java.time.LocalDate;
import java.time.Period;


public class ClientePJ extends Cliente {
    final private String cnpj;
    private Calendar dataFundacao;
    private int quantidadeFuncionarios;
    private ArrayList<Frota> listaFrotas = new ArrayList<Frota>();

    public ClientePJ(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEco, String cnpj, Calendar dataFundacao, int quantidadeFuncionarios, Seguradora seguradora) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEco, seguradora);
        this.cnpj = cnpj.replaceAll("[^0-9]+", "");
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

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public int quantidadeVeiculos() {
        int contador = 0;

        for (Frota frota : this.listaFrotas) {
            contador += frota.getListaVeiculos().size();
        }

        return contador;
    }

    public void cadastrarFrota(Frota frotaNova) {
        this.listaFrotas.add(frotaNova);
    }

    public void cadastraVeiculoNovoFrota(Veiculo veiculo, Frota frota) {
        frota.adicionarVeiculo(veiculo); //adicionando o veículo à frota desejada
        this.getVeiculos().add(veiculo); //colocando esse veículo na lista de todos os veículos que estão na responsabilidade do cliente PJ
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(Frota frotaVeiculos) {
        ArrayList<Veiculo> veiculosFrota = new ArrayList<Veiculo>();

        for (Frota frota : this.listaFrotas) {
            if (frota.equals(frotaVeiculos)) {
                veiculosFrota.addAll(frota.getListaVeiculos());
                break;
            }
        }

        return veiculosFrota;
    }

    public int calcularIdade() {

        String diaFundacao;

        if(Integer.parseInt(Datas.pegarDiaDoNascimento(dataFundacao)) < 10) {
            diaFundacao = "0" + Datas.pegarDiaDoNascimento(this.dataFundacao);
        } else {
            diaFundacao = Datas.pegarDiaDoNascimento(dataFundacao);
        }

        String mesFundacao = Datas.pegarMesDoNascimento(this.dataFundacao); 
        String anoFundacao = Datas.pegarAnoDoNascimento(this.dataFundacao);
        String dataFundacaoString = anoFundacao + '-' + mesFundacao + '-' + diaFundacao;
        LocalDate dataFundacaoLocalDate = LocalDate.parse(dataFundacaoString); //converte a data de nascimento do cliente para um objeto localdate para utilizar na classe period

        LocalDate dataHoje = LocalDate.now(); 
        return Period.between(dataFundacaoLocalDate, dataHoje).getYears();
    }
    
    @Override
    public double calculaScore() {
        return CalculoSeguro.VALOR_BASE.valor * (1 + (this.getQuantidadeFuncionarios()/100)) * this.getVeiculos().size();
    }

    @Override
    public String toString() {
        return super.toString() + "CNPJ: " + this.cnpj + "\n" + "Data de Fundação: " + String.valueOf(this.dataFundacao.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataFundacao.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataFundacao.get(Calendar.YEAR)) + "\n" + "Quantidade de funcionários: " + this.quantidadeFuncionarios + "\n";
    }

}
