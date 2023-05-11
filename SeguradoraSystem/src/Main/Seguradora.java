package Main;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import Clientes.Cliente;
import Clientes.ClientePF;
import Clientes.ClientePJ;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Map<Integer, Sinistro> listaSinistros = new HashMap<Integer, Sinistro>(); //a chave do HashMap será o ID do sinistro 
    private Map<String, Cliente> listaClientes = new HashMap<String, Cliente>(); //a chave deste map será o cpf ou cnpj do cliente

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEmail(email);
        this.setEndereco(endereco);
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    
    private void setTelefone(String telefone) {
        this.telefone = telefone;
    } 

    private void setEmail(String email) {
        this.email = email;
    } 

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    } 

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public boolean cadastrarCliente(ClientePF cliente) {
        if(listaClientes.containsKey(cliente.getCPF())) {
            System.out.println("O cliente já existe na base de dados!");
            return false; //o cliente já existe na base de dados e não faz sentido adicioná-lo nela
        }

        
        listaClientes.put(cliente.getCPF(), cliente); //cliente ainda não existia e foi adicionado à base de dados com sucesso
        System.out.println("Cliente adicionado com sucesso!");
        return true;
    }

    //a função acima e a abaixo desse comentário são uma sobrecarga de métodos

    public boolean cadastrarCliente(ClientePJ cliente) {
        if(listaClientes.containsKey(cliente.getCNPJ())) {
            System.out.println("O cliente já existe na base de dados!");
            return false; //o cliente já existe na base de dados e não faz sentido adicioná-lo nela
        }


        listaClientes.put(cliente.getCNPJ(), cliente); //cliente ainda não existia e foi adicionado à base de dados com sucesso
        System.out.println("Cliente adicionado com sucesso!");
        return true;
    }

    public boolean removerCliente(String CPFouCNPJ) {
        if (listaClientes.containsKey(CPFouCNPJ)) {
            listaClientes.remove(CPFouCNPJ);
            
            System.out.println("Cliente removido da base de dados com sucesso!");
            return true;
        } 
        
        System.out.println("O cliente não existe na base de dados!");
        return false; 
    }

    public void visualizarClientePF(String cpf) {
        Cliente cliente = this.listaClientes.get(cpf);
        System.out.println(cliente.toString());
    }

    public void visualizarClientePJ(String cnpj) {
        Cliente cliente = this.listaClientes.get(cnpj);
        System.out.println(cliente.toString());
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> novaListaClientes = new ArrayList<Cliente>();
        for(Cliente cliente : listaClientes.values()) {
            novaListaClientes.add(cliente);
        }
        
        return novaListaClientes;
    }
    
    public ArrayList<Cliente> listarClientesPorGenero(String tipoGenero) { 
        ArrayList<Cliente> listaFiltrada = new ArrayList<Cliente>(); 

        for (Cliente cliente : listaClientes.values()) {
            if (cliente.getGenero().equals(tipoGenero)) {
                listaFiltrada.add(cliente);
            }
        }

        return listaFiltrada;
    }

    public ArrayList<Cliente> listarClientesPorClasseEco(String tipoClasseEco) { 
        ArrayList<Cliente> listaFiltrada = new ArrayList<Cliente>(); 

        for (Cliente cliente : listaClientes.values()) {
            if (cliente.getClasseEco().equals(tipoClasseEco)) {
                listaFiltrada.add(cliente);
            }
        }

        return listaFiltrada;
    }

    public ArrayList<Cliente> listarClientesPorEducacao(String tipoEducacao) { 
        ArrayList<Cliente> listaFiltrada = new ArrayList<Cliente>(); 

        for (Cliente cliente : listaClientes.values()) {
            if (cliente.getEducacao().equals(tipoEducacao)) {
                listaFiltrada.add(cliente);
            }
        }

        return listaFiltrada;
    }
    
    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        Sinistro novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);

        listaSinistros.put(novoSinistro.getID(), novoSinistro); //adicionando o novo sinistro gerado à lista de sinistros da seguradora

        cliente.setValorSeguro(this.calculaPrecoSeguroCliente(cliente));

        return true;
    }

    public boolean removerSinistro(int id) {
        if (this.listaSinistros.containsKey(id)) {
            listaSinistros.remove(id);
            System.out.println("Sinistro removido com sucesso!");
            return true;
        } else {
            System.out.println("Não existe nenhum sinistro com esse ID");
            return false;
        }
    }

    public boolean visualizarSinistro(String nomeCliente) {
        
        for(Sinistro sinistro : listaSinistros.values()) {
            if (sinistro.getCliente().getNome().equals(nomeCliente)) {
                System.out.println(sinistro.toString()); //existe um sinistro no nome do cliente passado e esse sinistro foi visualizado com sucesso
                return true;
            }
        }

        System.out.println("Não existe nenhum sinistro no nome de " + nomeCliente);
        return false; //não existe nenhum sinistro no nome do cliente passado e, portanto, nada foi visualizado
    }

    public ArrayList<Sinistro> listarSinistros() {
        ArrayList<Sinistro> novaListaSinistros = new ArrayList<Sinistro>();
        
        for(Sinistro sinistro : listaSinistros.values()) {
            novaListaSinistros.add(sinistro);
        }

        return novaListaSinistros;
    }

    public ArrayList<Sinistro> listarSinistrosPorCliente(Cliente cliente) {

        ArrayList<Sinistro> listaSinistrosDoCliente = new ArrayList<Sinistro>();

        for (Sinistro sinistro : listaSinistros.values()) {
            if (sinistro.getCliente().equals(cliente)) {
                listaSinistrosDoCliente.add(sinistro);
            }
        }

        return listaSinistrosDoCliente;
    }

    public ArrayList<Veiculo> listarVeiculosSeguradora() {
        ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();

        for (Cliente cliente : this.listaClientes.values()) {
            listaDeVeiculos.addAll(cliente.getVeiculos());
        }

        return listaDeVeiculos;
    }

    public double calculaPrecoSeguroCliente(Cliente cliente) {
    
        return (cliente.calculaScore() * (1 + this.listarSinistrosPorCliente(cliente).size()));
    }

    public double calcularReceita() {
        double receita = 0;

        for(Cliente cliente : listaClientes.values()) {

            receita+= cliente.getValorSeguro();
            
        }

        return receita;
    }

    public void transferirSeguro(Cliente clienteQueVaiTransferir, Cliente clienteQueVaiReceber) {
        ArrayList<Veiculo> veiculosClienteQueVaiTransferir = clienteQueVaiTransferir.getVeiculos();
        
        for(Veiculo veiculo : veiculosClienteQueVaiTransferir) { /* essa parte vai transferir os veiculos segurados por um cliente para outro */
            clienteQueVaiReceber.adicionarVeiculo(veiculo); 
        }

        clienteQueVaiTransferir.apagarListaVeiculos();

        clienteQueVaiTransferir.setValorSeguro(0); //setando como zero já que ele não segura mais nenhum carro
        clienteQueVaiReceber.setValorSeguro(this.calculaPrecoSeguroCliente(clienteQueVaiReceber));
    }

}
