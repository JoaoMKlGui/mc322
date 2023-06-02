package Main;
import Clientes.*;

public class SeguroPF extends Seguro {
    private ClientePF cliente;
    private Veiculo veiculo;


    public SeguroPF(Seguradora seguradora ,ClientePF cliente, Veiculo veiculo) {
        super(seguradora);
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.atualizarValorMensal();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }


    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return this.cliente;
    }


    public boolean autorizarCondutor(Condutor condutorAutorizar) {
        this.getListaCondutores().add(condutorAutorizar);
        this.atualizarValorMensal(); //como adicionamos um condutor ao seguro, o valor desse seguro deve ser atualizado também
        return true;
    }

    public boolean desautorizarCondutor(Condutor condutorDesautorizar) {
        this.getListaCondutores().remove(condutorDesautorizar);
        this.atualizarValorMensal(); //o valor do seguro deve ser atualizado
        return true;
    }

    public boolean gerarSinistro(String data, String endereco, Seguro seguro, Veiculo veiculo, Condutor condutor) {
        Sinistro novoSinistro = new Sinistro(data, endereco, seguro, veiculo, condutor);

        this.getListaSinistros().put(novoSinistro.getID(), novoSinistro); //adicionando o novo sinistro gerado à lista de sinistros da seguradora

        condutor.adicionarSinistro(novoSinistro);
        this.atualizarValorMensal();

        return true;
    }

    public int quantidadeSinistrosCondutores() {
        int contador = 0;

        for (Condutor condutor : this.getListaCondutores()) {
            contador += condutor.getListaSinistros().size();
        }
        return contador;
    }

    public double calculaValor() {
        int idadeCliente = this.cliente.calcularIdade();
        double fatorIdade = 0;
        double valorBase = 10;

        if (idadeCliente < 30) {
            fatorIdade = 1.25;
        } else if (idadeCliente >= 30 && idadeCliente <= 60) {
            fatorIdade = 1.0;
        } else {
            fatorIdade = 1.5;
        }

        return (valorBase * fatorIdade * (1 + 1/(this.cliente.getVeiculos().size() + 2)) * (2 + this.getListaSinistros().size()/10) * (5 + this.quantidadeSinistrosCondutores()/10));

    }

    public void transferirSeguro(ClientePF clienteQueVaiReceber) {
        this.cliente = clienteQueVaiReceber; //basicamente um setter, mas fazendo uma função dedicada a só isso pra facilitar a leitura do código
    }

}
