package Main;
import java.util.HashMap;
import java.util.Map;

import Auxiliares.Datas;

import java.time.LocalDate;
import java.util.ArrayList;
import Clientes.Cliente;
import Clientes.ClientePF;
import Clientes.ClientePJ;

public class Seguradora {
    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private Map<String, Cliente> listaClientes = new HashMap<String, Cliente>(); //a chave deste map será o cpf ou cnpj do cliente

    public Seguradora(String nome, String telefone, String email, String endereco, String cnpj) {
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEmail(email);
        this.setEndereco(endereco);
        this.cnpj = cnpj; //a string cnpj já passou pela validação de cnpj
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
    
    public String getCnpj() {
        return cnpj;
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

    public ArrayList<Sinistro> listarSinistros() {
        return this.listaSinistros;
    }

    public Sinistro procurarSinistro(int id) {
        Sinistro sinistro = null;

        for (Sinistro s : listaSinistros) {
            if (s.getID() == id) {
                sinistro = s;
                break;
            }
        }

        return sinistro;
    }

    public boolean removerSinistro(int id) {
        Sinistro sinistro = procurarSinistro(id);

        if (sinistro == null) {
            return false;
        } 

        this.listaSinistros.remove(sinistro);
        return true;
    
    }

    public ArrayList<Sinistro> listarSinistrosPorCondutor(String cpf) {

        ArrayList<Sinistro> listaSinistrosDoCondutor = new ArrayList<Sinistro>();

        for (Sinistro sinistro : listaSinistros) {
            if (sinistro.getCondutor().getCpf().equals(cpf)) {
                listaSinistrosDoCondutor.add(sinistro);
            }
        }

        return listaSinistrosDoCondutor;
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

    public Cliente procurarCliente(String cpfOUcnpj) {
        cpfOUcnpj = cpfOUcnpj.replaceAll("[^0-9]+", ""); //formatando para não dar conflito 
        return this.listaClientes.get(cpfOUcnpj);
    }

    public void visualizarClientePJ(String cnpj) {
        Cliente cliente = this.listaClientes.get(cnpj);
        System.out.println(cliente.toString());
    }

    public void gerarSeguro(ClientePF clientePf, Veiculo veiculo) {
        SeguroPF novoSeguro = new SeguroPF(this, clientePf, veiculo);

        this.listaSeguros.add(novoSeguro);

    }

    //sobrecarga do metodo gerar seguro
    public void gerarSeguro(ClientePJ clientePj, Frota frota) {
        SeguroPJ novoSeguro = new SeguroPJ(this, clientePj, frota);
        this.listaSeguros.add(novoSeguro);
    }

    public void cancelarSeguro(Seguro seguro) {
        seguro.setDataFim(Datas.converteLocalDateParaCalendar(LocalDate.now()));
        this.listaSeguros.remove(seguro);
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


    public ArrayList<Seguro> listarSeguros() {
        return this.listaSeguros;
    }

    public ArrayList<Veiculo> listarVeiculosSeguradora() {
        ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();

        for (Cliente cliente : this.listaClientes.values()) {
            listaDeVeiculos.addAll(cliente.getVeiculos());
        }

        return listaDeVeiculos;
    }

    public double calcularReceita() {
        double receita = 0;

        for(Seguro seguro: listaSeguros) {

            receita+= seguro.getValorMensal();
            
        }

        return receita;
    }

    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();
        
        for (Seguro seguro : this.listaSeguros) {
            if(seguro.getCliente().equals(cliente)) {
                segurosCliente.add(seguro);
            }
        }

        return segurosCliente;

    }

    public String toString() {
        return "Nome: " + this.nome + "\n" + "CNPJ: " + this.cnpj + "\n" + "Email: " + this.email + "\n" + "Telefone: " + this.telefone + "\n" + "Endereco: " + this.telefone + "\n";
    }

}
