import java.util.Random;

public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    Sinistro(String data, String endereco) {
        this.setID();
        this.setData(data);
        this.setEndereco(endereco);
    }

    private void setID() {
        this.id = geradorID();
    }

    private void setData(String data) {
        this.data = data;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public int getID() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    private int geradorID() {
        //utilizando a classe Random para gerar um ID randômico entre 1 e 2 milhões
        Random random = new Random();
        return random.nextInt(1, 2000000);
    }

}
