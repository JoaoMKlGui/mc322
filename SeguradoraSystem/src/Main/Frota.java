package Main;
import java.util.ArrayList;

public class Frota {
    private final String code;
    private final String nomeFrota;
    private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(String nome) {
        this.nomeFrota = nome;
        this.code = geradorHashCode(nome);
    }
    
    private String geradorHashCode(String nomeFrota) {
        return Integer.toString(nomeFrota.hashCode());
    }

    public String getNomeFrota() {
        return this.nomeFrota;
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

    public String toString() {
        return "Código: " + this.code + "\n" + "Nome Frota: " + this.nomeFrota + "\n";
    }
}
