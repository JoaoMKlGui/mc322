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

    public boolean removerCliente(String nomeCliente) {
        if (listaClientes.containsKey(nomeCliente)) {
            listaClientes.remove(nomeCliente);
            
            System.out.println("Cliente removido da base de dados com sucesso!");
            return true;
        } 
        
        System.out.println("O cliente não existe na base de dados!");
        return false; 
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

        return true;
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
}
