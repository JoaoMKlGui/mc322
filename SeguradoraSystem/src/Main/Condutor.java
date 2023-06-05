package Main;
import java.util.ArrayList;
import java.util.Calendar;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Calendar dataNascimento;
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Calendar dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void adicionarSinistro(Sinistro sinistro) {
        this.listaSinistros.add(sinistro);
    }

    public String toString() {
        return "CPF: " + this.cpf + "\n" + "Nome: " + this.nome + "\n" + "Telefone: " + this.telefone + "\n" + "Endereco: " + this.endereco + "\n" + "Email: " + this.email + "\n";
    }
    
}

