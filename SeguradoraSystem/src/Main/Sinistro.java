package Main;
import java.util.Random;

public class Sinistro {
    final private int id = geradorID();
    private String data;
    private String endereco;
    private Seguro seguro;
    private Veiculo veiculo;
    private Condutor condutor;

    Sinistro(String data, String endereco, Seguro seguro, Veiculo veiculo, Condutor condutor) {
        this.setData(data);
        this.setEndereco(endereco);
        this.setCondutor(condutor);
        this.setVeiculo(veiculo);
        this.setSeguro(seguro);
    }

    private void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    private void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    private void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    private void setData(String data) {
        this.data = data;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public int getID() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public Seguro getSeguro() {
        return this.seguro;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public Condutor getCondutor() {
        return this.condutor;
    }

    private int geradorID() {
        //utilizando a classe Random para gerar um ID randômico entre 1 e 2 milhões
        Random random = new Random();
        return random.nextInt(1, 2000000);
    }

    @Override 
    public String toString() {
        return "Nome do cliente: " + this.condutor.getNome() + "\n" + "Modelo do veículo: " + this.veiculo.getModelo() + "\n" + "Placa do veículo: " + this.veiculo.getPlaca() + "\n" + "Seguradora: " + this.seguro.getSeguradora().getNome() + "\n" + "Data: " + this.data + "\n"  + "Endereço: " + this.endereco + "\n" + "ID do sinistro: " + this.id + "\n";
    }

}
