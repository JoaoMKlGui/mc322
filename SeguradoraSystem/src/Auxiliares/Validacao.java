package Auxiliares;

public class Validacao {
    
    public static boolean validarCPF(String cpf) {
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
            digito = Character.getNumericValue(novoCPF.charAt(i));
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

    public static boolean validarCNPJ(String cnpj) {
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
        for(int i = 0; i < 4; i++) {
            sum += Character.getNumericValue(novoCNPJ.charAt(i)) * (5- i);
        }

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

        for(int i = 0; i < 5; i++) {
            sum += Character.getNumericValue(novoCNPJ.charAt(i)) * (6 - i);
        }

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

    public static boolean validarNome(String nome) {
        char[] letrasNome = nome.toCharArray();

        for (char letra : letrasNome) {
            if(!Character.isLetter(letra) && letra != ' ') {
                return false;
            }
        }
        
        return true;
    }

}
