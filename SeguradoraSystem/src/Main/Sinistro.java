package Main;
import java.util.Random;
import Clientes.Cliente;;

public class Sinistro {
    final private int id = geradorID();
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.setData(data);
        this.setEndereco(endereco);
        this.setCliente(cliente);
        this.setVeiculo(veiculo);
        this.setSeguradora(seguradora);
    }

    private void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    private int geradorID() {
        //utilizando a classe Random para gerar um ID randômico entre 1 e 2 milhões
        Random random = new Random();
        return random.nextInt(1, 2000000);
    }

    @Override 
    public String toString() {
        return "Nome do cliente: " + this.cliente.getNome() + "\n" + "Modelo do veículo: " + this.veiculo.getModelo() + "\n" + "Placa do veículo: " + this.veiculo.getPlaca() + "\n" + "Seguradora: " + this.seguradora.getNome() + "\n" + "Data: " + this.data + "\n"  + "Endereço: " + this.endereco + "\n" + "ID do sinistro: " + this.id + "\n";
    }

}
