package Main;
import java.util.ArrayList;

public class Frota {
    private final String code;
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(String nomeFrota) {
        this.code = geradorHashCode(nomeFrota);
    }
    
    private String geradorHashCode(String nomeFrota) {
        return Integer.toString(nomeFrota.hashCode());
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public String getCode() {
        return this.code;
    }
    
    public void adicionarVeiculo(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.listaVeiculos.remove(veiculo);
    }
}
