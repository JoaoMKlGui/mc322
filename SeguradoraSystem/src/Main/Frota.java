package Main;
import java.util.ArrayList;

public class Frota {
    int code;
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(int code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public int getCode() {
        return this.code;
    }
    
    public void adicionarVeiculo(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.listaVeiculos.remove(veiculo);
    }

    public String toString() {
        return "Código: " + this.code + "\n";
    }
}
