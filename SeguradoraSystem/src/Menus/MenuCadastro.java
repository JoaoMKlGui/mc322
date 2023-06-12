package Menus;

public enum MenuCadastro {
    CADASTRAR_CLIENTE(1),
    CADASTRAR_VEICULO(2),
    CADASTRAR_SEGURADORA(3),
    CADASTRAR_FROTA(4),
    ATUALIZAR_FROTA(5),
    VOLTAR(6);

    public final int operacao;

    MenuCadastro(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }
}
