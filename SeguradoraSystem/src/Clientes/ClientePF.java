package Clientes;

import java.util.Calendar;

public class ClientePF extends Cliente {
    final private String cpf;
    private Calendar dataNascimento;

    public ClientePF(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEco, String cpf, Calendar dataNascimento) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEco);
        this.cpf = cpf;
        this.setDataNascimento(dataNascimento);
    }

    private void setDataNascimento(Calendar dataNasicmento) {
        this.dataNascimento = dataNasicmento;
    }

    public String getCPF() {
        return this.cpf;
    }

    public Calendar getDataNascimento() {
        return this.dataNascimento;
    }

    public boolean validarCPF() {
        int primeiroDigitoVerificador;
        int segundoDigitoVerificador;
        int sum = 0;
        int digito;
        boolean todosCharIguais = true;
        String novoCPF;

        novoCPF = cpf.replaceAll("[^0-9]+", ""); //formatando o CPF de XXX.XXX.XXX-XX para XXXXXXXXXXX

        if(novoCPF.length() != 11) {
            //todo novoCPF é formado por 11 números, logo, se ele tiver um numero diferente de digitos, não será válido
            return false;
        }

        //aqui verificando se todos os dígitos são iguais
        for(int i = 0; i < novoCPF.length(); i++) {
            if(novoCPF.charAt(i) != novoCPF.charAt(0)) {
                todosCharIguais = false;
            } 
        }

        if(todosCharIguais) {
            return false;
        }
    
        primeiroDigitoVerificador = Character.getNumericValue(novoCPF.charAt(novoCPF.length() - 2));
        segundoDigitoVerificador = Character.getNumericValue(novoCPF.charAt(novoCPF.length() - 1));
        
        //esse primeiro for vai verificar o primeiro digito verificador
        for(int i = 0; i < novoCPF.length() - 2; i++) {
            digito = Character.getNumericValue(novoCPF.charAt(i));
            sum += digito * (10 - i); 
        }

        sum = 11 - (sum % 11); //utiliza a conta para a formação do dígito verificador
        
        if(sum == 10 || sum == 11) {
            sum = 0;
        }
        
        if(sum != primeiroDigitoVerificador) {
            return false;
        }

        sum = 0; //reseta a variavel sum

        //esse segundo for calcula o segundo dígito verificador 
        for(int i = 0; i < novoCPF.length() - 1; i++) {
            digito = Character.getNumericValue(cpf.charAt(i));
            sum += digito * (11 - i); 
        }

        sum = 11 - (sum % 11); //utiliza a conta para a formação do dígito verificador

        if(sum == 10 || sum == 11) {
            sum = 0;
        }

        if(sum != segundoDigitoVerificador) {
            return false;
        }

        //se a função chegou até aqui, quer dizer que todos os requisitos foram satisfeitos e o cpf é válido
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + this.cpf + "\n" + "Data de Nascimento: " + String.valueOf(this.dataNascimento.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataNascimento.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataNascimento.get(Calendar.YEAR)) + "\n";
    }

}
