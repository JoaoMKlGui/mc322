package Main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Auxiliares.Datas;
import Clientes.Cliente;

public abstract class Seguro {
    private final int id;
    private Calendar dataInicio;
    private Calendar dataFim = null;
    private Seguradora seguradora;
    private Map<Integer, Sinistro> listaSinistros = new HashMap<Integer, Sinistro>(); //o id do sinistro é a chave, o sinistro é o valor
    private ArrayList<Condutor> listaCondutoresAutorizados = new ArrayList<Condutor>();
    private double valorMensal;

    public Seguro(Seguradora seguradora) {
        this.id = geradorID();
        this.dataInicio = Datas.converteLocalDateParaCalendar(LocalDate.now());
        this.seguradora = seguradora;
        this.valorMensal = calculaValor();
    }


    private int geradorID() {
        //utilizando a classe Random para gerar um ID randômico entre 1 e 2 milhões
        Random random = new Random();
        return random.nextInt(1, 2000000);
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public int getID() {
        return this.id;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }


    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }


    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return this.listaCondutoresAutorizados;
    }

    public Map<Integer, Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public void atualizarValorMensal() {
        this.valorMensal = calculaValor();
    }

    public ArrayList<Sinistro> listarSinistros() {
        ArrayList<Sinistro> novaListaSinistros = new ArrayList<Sinistro>();
        
        for(Sinistro sinistro : listaSinistros.values()) {
            novaListaSinistros.add(sinistro);
        }

        return novaListaSinistros;
    }

    public ArrayList<Sinistro> listarSinistrosPorCondutor(Condutor condutor) {

        ArrayList<Sinistro> listaSinistrosDoCondutor = new ArrayList<Sinistro>();

        for (Sinistro sinistro : listaSinistros.values()) {
            if (sinistro.getCondutor().equals(condutor)) {
                listaSinistrosDoCondutor.add(sinistro);
            }
        }

        return listaSinistrosDoCondutor;
    }

    public String toString() {
        return "ID: " + this.id + "\n" + "Seguradora: " + this.seguradora.getNome() + "\n" + "Valor mensal: " + this.valorMensal + "\n";
    }

    protected abstract double calculaValor();  
    protected abstract boolean autorizarCondutor(Condutor condutorAutorizar);
    protected abstract boolean desautorizarCondutor(Condutor condutorDesautorizar);
    protected abstract boolean gerarSinistro(String data, String endereco, Seguro seguro, Veiculo veiculo, Condutor condutor);
    protected abstract Cliente getCliente();
}
