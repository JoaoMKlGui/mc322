public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

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
    
}
