package Main;
import Clientes.*;

public class SeguroPJ extends Seguro {
    private ClientePJ cliente;
    private Frota frota;


    public SeguroPJ(Seguradora seguradora, ClientePJ cliente, Frota frota) {
        super(seguradora);
        this.cliente = cliente;
        this.frota = frota;
        this.atualizarValorMensal();
    }

    public Frota getFrota() {
        return frota;
    }

    public ClientePJ getCliente() {
        return this.cliente;
    }

    public boolean autorizarCondutor(Condutor condutorAutorizar) {
        this.getListaCondutores().add(condutorAutorizar);
        this.atualizarValorMensal();
        return true;
    }

    public boolean desautorizarCondutor(Condutor condutorDesautorizar) {
        this.getListaCondutores().remove(condutorDesautorizar);
        this.atualizarValorMensal();
        return true;
    }

    public boolean gerarSinistro(String data, String endereco, Seguro seguro, Veiculo veiculo, Condutor condutor) {
        Sinistro novoSinistro = new Sinistro(data, endereco, seguro, veiculo, condutor);

        this.getListaSinistros().put(novoSinistro.getID(), novoSinistro); //adicionando o novo sinistro gerado à lista de sinistros da seguradora
        condutor.adicionarSinistro(novoSinistro);
        this.atualizarValorMensal(); //atualiza o valor mensal do seguro

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
        int idadeEmpresa = this.cliente.calcularIdade();
        double valorBase = 10;

        return (valorBase * (10 + this.cliente.getQuantidadeFuncionarios()/10) * (1 + 1/(this.cliente.quantidadeVeiculos() + 2) * (1 + 1/(idadeEmpresa + 2))) * (2 + this.getListaSinistros().size()/ 10) * (5 + this.quantidadeSinistrosCondutores()/10));

    }

    public void transferirSeguro(ClientePJ clienteQueVaiReceber) {
        this.cliente = clienteQueVaiReceber;
    }
}
