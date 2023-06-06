package Menus;

public enum MenuListar {
    LISTAR_CLIENTES(1),
    LISTAR_SINISTROS_POR_SEGURADORA(2),
    LISTAR_SINISTROS_CONDUTOR(3),
    LISTAR_VEICULOS_CLIENTE(4),
    LISTAR_VEICULOS_SEGURADORA(5),
    LISTAR_SEGUROS(6),
    LISTAR_CONDUTORES(7),
    VOLTAR(8);


    public final int operacao;

    MenuListar(int operacao) {
        this.operacao = operacao;
    }
}
