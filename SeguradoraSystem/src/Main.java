public class Main {
    public static void main(String[] args) {

        Cliente clienteNovo = new Cliente("joao", "092.855.859-22", "15/12/2004", 18, "jacarandas");

        System.out.println(clienteNovo.validarCPF());
        System.out.println(clienteNovo.toString());

        Sinistro sinistroNovo = new Sinistro("21/03/2023", "princesa d'oeste");

        System.out.println(sinistroNovo.getData()); 
        System.out.println(sinistroNovo.getID()); 
        System.out.println(sinistroNovo.getEndereco());
        
        Seguradora seguradoraNova = new Seguradora("seguradora do bairro", "(19) 91111-1111", "seguradora@gmail.com", "unicamp");

        System.out.println(seguradoraNova.getEmail());

        Veiculo carro = new Veiculo("AAA-0000", "ford", "shelby");

        System.out.println(carro.getModelo());


    }

    
}
