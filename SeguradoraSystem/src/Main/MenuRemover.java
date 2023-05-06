package Main;

public enum MenuRemover {
    EXCLUIR_CLIENTE(1),
    EXCLUIR_VEICULO(2),
    EXCLUIR_SINISTRO(3),
    VOLTAR(4);

    public final int operacao;

    MenuRemover(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }
}
