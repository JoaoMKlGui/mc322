package Main;

public enum MenuOperacoes {
    CADASTRAR(1),
    LISTAR(2),
    REMOVER(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA(6),
    SAIR(0);



    public final int operacao;

    MenuOperacoes(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }
}

