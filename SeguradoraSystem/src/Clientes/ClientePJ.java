package Clientes;
import java.util.Calendar;

public class ClientePJ extends Cliente {
    final private String cnpj;
    private Calendar dataFundacao;

    public ClientePJ(String nome, String endereco, Calendar dataLicenca, String educacao, String genero, String classeEco, String cnpj, Calendar dataFundacao) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEco);
        this.cnpj = cnpj;
        this.setDataFundacao(dataFundacao);
    }

    private void setDataFundacao(Calendar dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public Calendar getDataFund() {
        return this.dataFundacao;
    }

    public boolean validarCNPJ() {
        int primeiroDigitoVerificador;
        int segundoDigitoVerificador;
        int sum = 0;
        int digito;
        boolean todosCharIguais = true;
        String novoCNPJ;

        novoCNPJ = cnpj.replaceAll("[^0-9]+", ""); //formatando o CPF de XXX.XXX.XXX-XX para XXXXXXXXXXX

        if(novoCNPJ.length() != 14) {
            //todo CNPJ é formado por 14 números, logo, se ele tiver um numero diferente de digitos, não será válido
            return false;
        }

        //aqui verificando se todos os dígitos são iguais
        for(int i = 0; i < novoCNPJ.length(); i++) {
            if(novoCNPJ.charAt(i) != novoCNPJ.charAt(0)) {
                todosCharIguais = false;
            } 
        }

        if(todosCharIguais) {
            return false;
        }
    
        primeiroDigitoVerificador = Character.getNumericValue(novoCNPJ.charAt(novoCNPJ.length() - 2));
        segundoDigitoVerificador = Character.getNumericValue(novoCNPJ.charAt(novoCNPJ.length() - 1));
        
        //esse primeiro bloco vai somar e fazer as multiplicações base dos dígitos com 5, 4, 3, 2;
        sum += (Character.getNumericValue(novoCNPJ.charAt(0)) * 5);
        sum += (Character.getNumericValue(novoCNPJ.charAt(1)) * 4); 
        sum += (Character.getNumericValue(novoCNPJ.charAt(2)) * 3);
        sum += (Character.getNumericValue(novoCNPJ.charAt(3)) * 2);

        //esse for irá realizar as multiplicações restantes;
        for(int i = 4; i < novoCNPJ.length() - 2; i++) {
            digito = Character.getNumericValue(novoCNPJ.charAt(i));
            sum += digito * (13 - i); 
        }

        sum = sum % 11; 
        
        if(sum == 0 || sum == 1) {
            sum = 0;
        } else {                   //esse bloco condicional faz as contas necessárias para a formação do primeiro dígito verificador
            sum = 11 - sum;
        }
        
        if(sum != primeiroDigitoVerificador) {
            return false;
        }

        sum = 0; //reseta a variavel sum

        sum += (Character.getNumericValue(novoCNPJ.charAt(0)) * 6);
        sum += (Character.getNumericValue(novoCNPJ.charAt(1)) * 5);
        sum += (Character.getNumericValue(novoCNPJ.charAt(2)) * 4); 
        sum += (Character.getNumericValue(novoCNPJ.charAt(3)) * 3);
        sum += (Character.getNumericValue(novoCNPJ.charAt(4)) * 2);

        //esse segundo for calcula o segundo dígito verificador 
        for(int i = 5; i < novoCNPJ.length() - 1; i++) {
            digito = Character.getNumericValue(novoCNPJ.charAt(i));
            sum += digito * (14 - i); 
        }

        sum = sum % 11;

        if(sum == 0 || sum == 1) {
            sum = 0;
        } else {                   //esse bloco condicional faz as contas necessárias para a formação do segundo dígito verificador
            sum = 11 - sum;
        }

        if(sum != segundoDigitoVerificador) {
            return false;
        }

        //se a função chegou até aqui, quer dizer que todos os requisitos foram satisfeitos e o cpf é válido
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "CNPJ: " + this.cnpj + "\n" + "Data de Fundação: " + String.valueOf(this.dataFundacao.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(this.dataFundacao.get(Calendar.MONTH) + 1) + "/" + String.valueOf(this.dataFundacao.get(Calendar.YEAR)) + "\n";
    }

}
