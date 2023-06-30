package Main;
public class Veiculo {
    private String placa; //alteracao feita pra veiculo ter somente placa, devido ao lab6

    public Veiculo(String placa) {
        this.setPlaca(placa);
    }

    private void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return this.placa;
    }

    @Override
    public String toString() {
        return "Placa: " + this.placa + "\n";
    }
}
