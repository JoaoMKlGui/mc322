package Main;
import java.util.ArrayList;

import Clientes.Cliente;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

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

    public boolean cadastrarCliente(Cliente cliente) {
        if(listaClientes.contains(cliente)) {
            return false; //o cliente já existe na base de dados e não faz sentido adicioná-lo nela
        }

        listaClientes.add(cliente); //cliente ainda não existia e foi adicionado à base de dados com sucesso
        return true;
    }

    public boolean removerCliente(String nomeCliente) {
        //iteração pela lista de clientes para encontrar o 
        for(Cliente cliente : listaClientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                listaClientes.remove(cliente);
                return true; //o client existe e foi removido
            }
        }

        return false; //caso retorne false significa que o cliente não existe na base de dados
    }   
    
    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        Sinistro novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        listaSinistros.add(novoSinistro); //adicionando o novo sinistro gerado à lista de sinistros da seguradora

        return true;
    }

    public boolean visualizarSinistro(String nomeCliente) {
        
        for(Sinistro sinistro : listaSinistros) {
            if (sinistro.getCliente().getNome().equals(nomeCliente)) {
                System.out.println(sinistro.toString()); //existe um sinistro no nome do cliente passado e esse sinistro foi visualizado com sucesso
                return true;
            }
        }

        return false; //não existe nenhum sinistro no nome do cliente passado e, portanto, nada foi visualizado
    }

    public ArrayList<Sinistro> listarSinistros() {
        return this.listaSinistros;
    }
}
