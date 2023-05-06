package Main;

public enum MenuListar {
    LISTAR_CLIENTES(1),
    LISTAR_SINISTROS_POR_SEGURADORA(2),
    LISTAR_SINISTROS_CLIENTE(3),
    LISTAR_VEICULOS_CLIENTE(4),
    LISTAR_VEICULOS_SEGURADORA(5),
    VOLTAR(6);


    public final int operacao;

    MenuListar(int operacao) {
        this.operacao = operacao;
    }
}
