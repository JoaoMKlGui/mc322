package Menus;

public enum MenuListar {
    LISTAR_CLIENTES(1),
    LISTAR_SINISTROS_POR_SEGURADORA(2),
    LISTAR_SINISTROS_CONDUTOR(3),
    LISTAR_VEICULOS_CLIENTE(4),
    LISTAR_VEICULOS_SEGURADORA(5),
    LISTAR_SEGUROS(6),
    LISTAR_CONDUTORES(7),
    LISTAR_VEICULOS_FROTA(8),
    LISTAR_FROTAS(10),
    VOLTAR(11);


    public final int operacao;

    MenuListar(int operacao) {
        this.operacao = operacao;
    }
}
