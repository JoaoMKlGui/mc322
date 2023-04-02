package Main;
public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    public Veiculo(String placa, String marca, String modelo, int ano) {
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAnoFab(ano);
    }

    private void setPlaca(String placa) {
        this.placa = placa;
    }

    private void setAnoFab(int ano) {
        this.anoFabricacao = ano;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }
    
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getAnoFab() {
        return this.anoFabricacao;
    }

    @Override
    public String toString() {
        return "Placa: " + this.placa + "\n" + "Marca: " + this.marca + "\n" + "Modelo: " + this.modelo + "\n" + "Ano de Fabricação: " + String.valueOf(this.anoFabricacao) + "\n";
    }
}
