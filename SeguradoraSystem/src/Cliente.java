public class Cliente {
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private int idade;
    private String endereco;

    public Cliente(String nome, String cpf, String dataDeNascimento, int idade, String endereco) {
        this.setNome(nome);
        this.setCPF(cpf);
        this.setNascimento(dataDeNascimento);
        this.setIdade(idade);
        this.setEndereco(endereco);
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCPF(String cpf) {
        this.cpf = cpf;
    }

    private void setNascimento(String nascimento) {
        this.dataDeNascimento = nascimento;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getNascimento() {
        return this.dataDeNascimento;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getEndereco() {
        return this.endereco;
    }


    public boolean validarCPF() {
        int primeiroDigitoVerificador;
        int segundoDigitoVerificador;
        int sum = 0;
        int digito;
        boolean todosCharIguais = true;
        String novoCPF;

        novoCPF = cpf.replaceAll("[^0-9]+", ""); //formatando o CPF de XXX.XXX.XXX-XX para XXXXXXXXXXX
        this.setCPF(novoCPF); //formata e atualiza o atributo cpf do cliente

        if(cpf.length() != 11) {
            //todo cpf é formado por 11 números, logo, se ele tiver um numero diferente de digitos, não será válido
            return false;
        }

        //aqui verificando se todos os dígitos são iguais
        for(int i = 0; i < cpf.length(); i++) {
            if(cpf.charAt(i) != cpf.charAt(0)) {
                todosCharIguais = false;
            } 
        }

        if(todosCharIguais) {
            return false;
        }
    
        primeiroDigitoVerificador = Character.getNumericValue(cpf.charAt(cpf.length() - 2));
        segundoDigitoVerificador = Character.getNumericValue(cpf.charAt(cpf.length() - 1));
        
        //esse primeiro for vai verificar o primeiro digito verificador
        for(int i = 0; i < cpf.length() - 2; i++) {
            digito = Character.getNumericValue(cpf.charAt(i));
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
        for(int i = 0; i < cpf.length() - 1; i++) {
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
        return "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Data de Nascimento: " + dataDeNascimento + "\n" + "Idade: " + idade + "\n" + "Endereco: " + endereco + "\n";
    }
}
