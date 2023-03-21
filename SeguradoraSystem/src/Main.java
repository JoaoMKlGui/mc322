public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("joao", "527.903.908-00", "31/12/2003", 19, "jacarandas");

        System.out.println(c1.validarCPF());
        System.out.println(c1.toString());
    }

    
}
