package Menus;

public enum MenuCadastro {
    CADASTRAR_CLIENTE(1),
    CADASTRAR_VEICULO(2),
    CADASTRAR_SEGURADORA(3),
    VOLTAR(4);

    public final int operacao;

    MenuCadastro(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return this.operacao;
    }
}
