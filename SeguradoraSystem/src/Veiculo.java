public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;

    public Veiculo(String placa, String marca, String modelo) {
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    private void setPlaca(String placa) {
        this.placa = placa;
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
}
