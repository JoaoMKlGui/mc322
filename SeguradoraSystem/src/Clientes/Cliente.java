package Clientes;
import java.util.Calendar;
import java.util.ArrayList;
import Main.Veiculo;

public class Cliente {
    private String nome;
    private String endereco;
    private Calendar dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos;

    public Cliente(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEconomica) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setDataLicenca(dataLicenca);
        this.setEducacao(educacao);
        this.setGenero(genero);
        this.setClasseEco(classeEconomica);
    }

    private void setDataLicenca(Calendar dataLicenca) {
        this.dataLicenca = dataLicenca;
    }
    
    private void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    private void setGenero(String genero) {
        this.genero = genero;
    }

    private void setClasseEco(String classeEco) {
        this.classeEconomica = classeEco;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public Calendar getDataLicenca() {
        return this.dataLicenca;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getClasseEco() {
        return this.classeEconomica;
    }

    public String visualizarVeiculos() {
        String veiculos = "";
        for(Veiculo veiculo : listaVeiculos) {
            veiculos = veiculo + veiculo.getModelo() + "\n"; //poderia utilizar o toString, mas como o cliente já sabe como cada carro que ele possui é, então pego só o modelo para facilitar
        }

        return veiculos;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" + "Endereço: " + this.endereco + "\n" + "Data da Licença: " + String.valueOf(this.dataLicenca.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataLicenca.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataLicenca.get(Calendar.YEAR)) + "\n" + "Educação: " + this.educacao + "\n" + "Genero: " + this.genero + "\n" + "Classe Economica: " + this.classeEconomica + "\n";
    }
}