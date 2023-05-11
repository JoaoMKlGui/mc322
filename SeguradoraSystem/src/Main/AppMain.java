package Main;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import Clientes.*;

public class AppMain {
    
    public static ClientePF criarClientePF() {
        Scanner scanner = new Scanner(System.in);


        String dataLic = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] partes_da_data = dataLic.split("_");
        int anoLicenca = Integer.parseInt(partes_da_data[0]);
        int mesLicenca = Integer.parseInt(partes_da_data[1]) - 1;
        int diaLicenca = Integer.parseInt(partes_da_data[2]);

        Calendar dataLicenca = Calendar.getInstance();
        dataLicenca.set(Calendar.YEAR, anoLicenca);
        dataLicenca.set(Calendar.MONTH, mesLicenca);
        dataLicenca.set(Calendar.DAY_OF_MONTH, diaLicenca);
        System.out.println("Digite o nome do cliente");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço");
        String endereco = scanner.nextLine();
        System.out.println("Digite o nível de educação");
        String nivelEducacao = scanner.nextLine();
        System.out.println("Digite o gênero");
        String genero = scanner.nextLine();
        System.out.println("Digite a classe econômica");
        String classeEco = scanner.nextLine();
            
        System.out.println("Digite a data de nascimento no formato DD/MM/YYYY");
        String data = scanner.nextLine();
        String[] infoNascimento = data.split("/");
        int diaNascimento = Integer.parseInt(infoNascimento[0]);
        int mesNascimento = Integer.parseInt(infoNascimento[1]) - 1; //convertendo de string para int para poder utilizar na classe calendar
        int anoNascimento = Integer.parseInt(infoNascimento[2]);
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR, anoNascimento);
        dataNascimento.set(Calendar.MONTH, mesNascimento);
        dataNascimento.set(Calendar.DAY_OF_MONTH, diaNascimento);

        System.out.println("Digite o cpf");
        String cpf = scanner.nextLine();
        
        ClientePF novoCliente = new ClientePF(nome, endereco, dataLicenca, nivelEducacao, genero, classeEco, cpf, dataNascimento);

        
    
        return novoCliente;
        
    }

    public static ClientePJ criarClientePJ() {
        Scanner scanner = new Scanner(System.in);
        String lixo;

        String dataLic = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] partes_da_data = dataLic.split("_");
        int anoLicenca = Integer.parseInt(partes_da_data[0]);
        int mesLicenca = Integer.parseInt(partes_da_data[1]) - 1;
        int diaLicenca = Integer.parseInt(partes_da_data[2]);

        Calendar dataLicenca = Calendar.getInstance();
        dataLicenca.set(Calendar.YEAR, anoLicenca);
        dataLicenca.set(Calendar.MONTH, mesLicenca);
        dataLicenca.set(Calendar.DAY_OF_MONTH, diaLicenca);
        System.out.println("Digite o nome do cliente");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço");
        String endereco = scanner.nextLine();
        System.out.println("Digite o nível de educação");
        String nivelEducacao = scanner.nextLine();
        System.out.println("Digite o gênero");
        String genero = scanner.nextLine();
        System.out.println("Digite a classe econômica");
        String classeEco = scanner.nextLine();



        System.out.println("Digite a data de fundação no formato DD/MM/YYYY");
        String data = scanner.nextLine();
        String[] infoFundacao = data.split("/");
        int diaFundacao = Integer.parseInt(infoFundacao[0]);
        int mesFundacao = Integer.parseInt(infoFundacao[1]) - 1; //convertendo de string para int para poder utilizar na classe calendar
        int anoFundacao = Integer.parseInt(infoFundacao[2]);
        Calendar dataFundacao = Calendar.getInstance();
        dataFundacao.set(Calendar.YEAR, anoFundacao);
        dataFundacao.set(Calendar.MONTH, mesFundacao);
        dataFundacao.set(Calendar.DAY_OF_MONTH, diaFundacao);

        System.out.println("Digite o cnpj");
        String cnpj = scanner.nextLine();
        System.out.println("Digite a quantidade de funcionários");
        int quantidadeDeFuncionarios = scanner.nextInt();
        lixo = scanner.nextLine();
        
        ClientePJ novoCliente = new ClientePJ(nome, endereco, dataLicenca, nivelEducacao, genero, classeEco, cnpj, dataFundacao, quantidadeDeFuncionarios);
        System.out.println(novoCliente.toString());
    
        return novoCliente;

    }


    public static Seguradora criarSeguradora() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da seguradora");
        String nomeSeguradora = scanner.nextLine();
        System.out.println("Digite o telefone");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email");
        String email = scanner.nextLine();
        System.out.println("Digite o endereço");
        String endereco = scanner.nextLine();
        
        Seguradora novaSeguradora = new Seguradora(nomeSeguradora, telefone, email, endereco);
        

        return novaSeguradora;
    }

    public static Veiculo criarNovoVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o modelo do veículo");
        String modelo = scanner.nextLine();
        System.out.println("Digite a marca");
        String marca = scanner.nextLine();
        System.out.println("Digite o ano de fabricação");
        int anoDeFabricacao = scanner.nextInt();
        String lixo = scanner.nextLine();
        System.out.println("Digite a placa");
        String placa = scanner.nextLine();

        Veiculo novoVeiculo = new Veiculo(placa, marca, modelo, anoDeFabricacao);
        

        return novoVeiculo;
    }

    public static void cadastrarCliente(ClientePJ cliente, Seguradora seguradora) {

        if(Validacao.validarNome(cliente.getNome()) && Validacao.validarCNPJ(cliente.getCNPJ())) {
            seguradora.cadastrarCliente(
                cliente
            );
        } else {
            System.out.println("Nome ou CNPJ inválidos!");
            System.out.println("Lembre-se que o nome não pode ter nenhum acento, cedilha ou caracteres especiais!");
        }
        
    }
    /*essas funções estão sobrecarregadas e recebem parâmetros de diferentes tipos, porém fazem a mesma coisa*/
    public static void cadastrarCliente(ClientePF cliente, Seguradora seguradora) {


        if(Validacao.validarNome(cliente.getNome()) && Validacao.validarCPF(cliente.getCPF())) {
            seguradora.cadastrarCliente(
                cliente
            );
        } else {
            System.out.println("Nome ou CPF inválidos!");
            System.out.println("Lembre-se que o nome não pode ter nenhum acento, cedilha ou caracteres especiais!");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operacao;
        String lixo;
        ArrayList<Seguradora> listaSeguradorasDoSistema = new ArrayList<Seguradora>();


        String dataLic = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] partes_da_data = dataLic.split("_");
        int anoLicenca = Integer.parseInt(partes_da_data[0]);
        int mesLicenca = Integer.parseInt(partes_da_data[1]) - 1;
        int diaLicenca = Integer.parseInt(partes_da_data[2]);

        Calendar dataLicenca = new GregorianCalendar(anoLicenca, mesLicenca, diaLicenca);


        Calendar data1 = new GregorianCalendar(2003, 11, 31); //lembrando que mês 11 é dezembro porque o calendar começa a contar do 0
        Calendar data2 = new GregorianCalendar(2001, 8, 11);

        System.out.println("****************");
        System.out.println("Bem vindo ao App SeguradorasSystem!");
        System.out.println("****************");


        Seguradora seguradoraPreCadastrado = new Seguradora("Ale Seixas", "(19) 993423301", "a260533@dac.unicamp.br", "campinas");
        listaSeguradorasDoSistema.add(seguradoraPreCadastrado);
        ClientePF clientePF = new ClientePF("joao", "unicamp", dataLicenca, "superior", "masculino","alta", "104.337.449-36", data1);
        ClientePJ clientePJ = new ClientePJ("Oficina Simas Turbo", "Unicamp", dataLicenca, "fundamental", "masculino", "alta", "55.889.662/0001-56", data2, 100);
        seguradoraPreCadastrado.cadastrarCliente(clientePJ);
        seguradoraPreCadastrado.cadastrarCliente(clientePF);
        Veiculo veiculo1 = new Veiculo("FDP-0000", "Ford", "Mustang Shelby", 2020);
        Veiculo veiculo2 = new Veiculo("OFF-0000", "Ford", "Maverick", 1975);
        clientePF.adicionarVeiculo(veiculo1);
        clientePJ.adicionarVeiculo(veiculo2);
        seguradoraPreCadastrado.gerarSinistro("01/05/2023", "Unicamp", seguradoraPreCadastrado, veiculo1, clientePF);
        seguradoraPreCadastrado.gerarSinistro("01/05/2023", "Unicamp", seguradoraPreCadastrado, veiculo2, clientePJ);

        System.out.println(clientePF);
        System.out.println(clientePJ);

        for(Cliente cliente : seguradoraPreCadastrado.listarClientes()) {
            System.out.println(cliente);
        }

        seguradoraPreCadastrado.visualizarSinistro("Oficina Simas Turbo");

        for(Sinistro sinistro : seguradoraPreCadastrado.listarSinistros()) {
            System.out.println(sinistro);
        }

        System.out.println(seguradoraPreCadastrado.calcularReceita());

        Veiculo veiculo3 = new Veiculo("OIE-0000", "Ferrari", "F40", 1995);
        clientePF.adicionarVeiculo(veiculo3);
        clientePF.setValorSeguro(seguradoraPreCadastrado.calculaPrecoSeguroCliente(clientePF));
        System.out.println(seguradoraPreCadastrado.calcularReceita());

        while(true) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - CADASTROS");
            System.out.println("2 - LISTAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - GERAR SINISTRO");
            System.out.println("5 - TRANSFERIR SEGURO");
            System.out.println("6 - CALCULAR RECEITA SEGURADORA");
            System.out.println("0 - SAIR");
            System.out.println();
            System.out.println("Digite o número da operação desejada");

            operacao = scanner.nextInt();
            lixo = scanner.nextLine();

            if(operacao == MenuOperacoes.CADASTRAR.operacao) {
                System.out.println("****************");
                System.out.println("MENU CADASTROS");
                System.out.println("1 - CADASTRAR CLIENTE PF/PJ");
                System.out.println("2 - CADASTRAR VEÍCULO");
                System.out.println("3 - CADASTRAR SEGURADORA");
                System.out.println("4 - VOLTAR");
                System.out.println("Digite o número da operação desejada");

                operacao = scanner.nextInt();
                lixo = scanner.nextLine();

                if (operacao == MenuCadastro.CADASTRAR_CLIENTE.operacao) {
                    int opcao = 0;
                    Seguradora seguradoraParaCadastrar = null;

                    System.out.println("****************");
                    System.out.println("Qual o nome da seguradora que você deseja cadastrar o cliente?");
                    String nomeSeguradora = scanner.nextLine();
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {

                        if(seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraParaCadastrar = seguradora;
                        }   

                    }

                    if(seguradoraParaCadastrar == null) {
                        System.out.println("Não existe nenhuma seguradora com esse nome na base de dados. Verifique o nome e tente novamente");
                    } else {
                    
                        while(opcao != 1 && opcao != 2) {
                            System.out.println("Você deseja criar um cliente PF ou um cliente PJ?");
                            System.out.println("Digite 1 para cliente PF");
                            System.out.println("Digite 2 para cliente PJ");
                            System.out.println("****************");
                            opcao = scanner.nextInt();
                            lixo = scanner.nextLine();

                            if(opcao != 1 && opcao != 2) {
                                System.out.println("Digite uma opção válida!");
                            }
                        }

                        if(opcao == 1) {
                            ClientePF clientePf = criarClientePF();
                            cadastrarCliente(clientePf, seguradoraParaCadastrar);
                            
                            
                        } else if (opcao == 2) {
                            ClientePJ clientePj = criarClientePJ();
                            cadastrarCliente(clientePj, seguradoraParaCadastrar);
                            
                        } 
                    }
            

                } else if (operacao == MenuCadastro.CADASTRAR_SEGURADORA.operacao) {
                    
                    Seguradora novaSeguradora = criarSeguradora();
                    listaSeguradorasDoSistema.add(novaSeguradora);
                    System.out.println("Seguradora cadastrada com sucesso ao sistema!");

                } else if (operacao == MenuCadastro.CADASTRAR_VEICULO.operacao) {
                    Seguradora seguradoraCliente = null;
                    Cliente clienteCadastrarVeiculo = null;

                    System.out.println("Digite o nome da seguradora do cliente");
                    String nomeSeguradora = scanner.nextLine();
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraCliente = seguradora;
                            break;
                        }
                    }

                    if(seguradoraCliente == null) {
                        System.out.println("Não existe nenhuma seguradora na base de dados com o nome dado. Por favor, digite um nome válido");
                    }
                    
                    if(seguradoraCliente == null) {
                        System.out.println("Seguradora não encontrada no sistema. Verifique o nome e tente novamente");
                    } else {
                        Veiculo novoVeiculo = criarNovoVeiculo();
                        System.out.println("Digite o nome do cliente que irá cadastrar o carro");
                        String nomeCliente = scanner.nextLine();

                        for(Cliente cliente : seguradoraCliente.listarClientes()) {
                            if(cliente.getNome().equals(nomeCliente)) {
                                clienteCadastrarVeiculo = cliente;
                            }
                        }

                        if(clienteCadastrarVeiculo == null) {
                            System.out.println("Cliente não encontrado na base de dados dessa seguradora. Tente novamente");
                        } else {
                            clienteCadastrarVeiculo.adicionarVeiculo(novoVeiculo);
                            clienteCadastrarVeiculo.setValorSeguro(seguradoraCliente.calculaPrecoSeguroCliente(clienteCadastrarVeiculo)); //atualiza o valor do seguro do cliente
                        }
                    }


                } else {
                    //ele vai sair do menu e na próxima iteração vai acabar indo pro menu principal de novo
                }

            } else if(operacao == MenuOperacoes.LISTAR.operacao) {
                System.out.println("****************");
                System.out.println("MENU LISTAGEM");
                System.out.println("1 - LISTAR CLIENTES POR SEGURADORA");
                System.out.println("2 - LISTAR SINISTROS POR SEGURADORA");
                System.out.println("3 - LISTAR SINISTROS POR CLIENTE");
                System.out.println("4 - LISTAR VEÍCULOS POR CLIENTE");
                System.out.println("5 - LISTAR VEÍCULOS POR SEGURADORA");
                System.out.println("6 - VOLTAR");
                System.out.println("Digite o número da operação desejada");

                operacao = scanner.nextInt();
                lixo = scanner.nextLine();

                if (operacao == MenuListar.LISTAR_CLIENTES.operacao) {
                    Seguradora seguradoraListar = null;

                    while(seguradoraListar == null) {
                        System.out.println("****************");
                        System.out.println("Por favor digite o nome da seguradora que você deseja listar os clientes");
                        String nomeSeguradora = scanner.nextLine();
                        for(Seguradora seguradora : listaSeguradorasDoSistema) {
                            if (seguradora.getNome().equals(nomeSeguradora)) {
                                seguradoraListar = seguradora;
                                break;
                            }
                        }

                        if(seguradoraListar == null) {
                            System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e tente novamente");
                        }
                    }

                    for(Cliente cliente : seguradoraListar.listarClientes()) {
                        System.out.println(cliente.toString());
                    }
                    

                } else if (operacao == MenuListar.LISTAR_SINISTROS_CLIENTE.operacao) {
                    Seguradora seguradoraListar = null;
                    Cliente clienteListar = null;

                    System.out.println("****************");
                    System.out.println("Por favor digite o nome da seguradora que você deseja listar os clientes");
                    String nomeSeguradora = scanner.nextLine();
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraListar = seguradora;
                            break;
                        }
                    }

                    if(seguradoraListar == null) {
                        System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e tente novamente");
                    } else {
                        System.out.println("Qual o nome do cliente que você deseja listar os sinistros?");
                        String nomeClienteListar = scanner.nextLine();

                        for(Cliente cliente : seguradoraListar.listarClientes()) {
                            if(cliente.getNome().equals(nomeClienteListar)) {
                                clienteListar = cliente;
                                break;

                            }
                        }

                        if(clienteListar == null) {
                            System.out.println("Cliente não encontrado na base de dados, tente outro nome ou verifique as informações");
                        } else {

                            for(Sinistro sinistroCliente : seguradoraListar.listarSinistrosPorCliente(clienteListar)) {
                                System.out.println(sinistroCliente.toString());
                            }

                        }
                    }

                } else if (operacao == MenuListar.LISTAR_SINISTROS_POR_SEGURADORA.operacao) {
                    Seguradora seguradoraListar = null;

                    while(seguradoraListar == null) {
                        System.out.println("****************");
                        System.out.println("Por favor digite o nome da seguradora que você deseja listar os clientes");
                        String nomeSeguradora = scanner.nextLine();
                        for(Seguradora seguradora : listaSeguradorasDoSistema) {
                            if (seguradora.getNome().equals(nomeSeguradora)) {
                                System.out.println(seguradora.toString());
                                System.out.println("****");
                                System.out.println("Confira as informações dessa seguradora. Caso seja ela, digite 1, caso não, digite 2");
                                int resposta = scanner.nextInt();
                                lixo = scanner.nextLine();

                                if(resposta == 1) {
                                    seguradoraListar = seguradora;
                                    break;
                                }
                            }
                        }

                        if(seguradoraListar == null) {
                            System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e digite novamente");
                        } 
                    }

                    for(Sinistro sinistro : seguradoraListar.listarSinistros()) {
                        System.out.println(sinistro.toString());
                    }

                    

                } else if (operacao == MenuListar.LISTAR_VEICULOS_CLIENTE.operacao) {
                    Seguradora seguradoraListar = null;
                    Cliente clienteListar = null;

                    while(seguradoraListar == null) {
                        System.out.println("****************");
                        System.out.println("Por favor digite o nome da seguradora do cliente");
                        String nomeSeguradora = scanner.nextLine();
                        for(Seguradora seguradora : listaSeguradorasDoSistema) {
                            if (seguradora.getNome().equals(nomeSeguradora)) {
                                System.out.println("Confirme os dados da seguradora");
                                System.out.println(seguradora.toString());
                                System.out.println("Digite 1 se essa for a seguradora desejada, digite 2 caso não");
                                int resposta = scanner.nextInt();
                                lixo = scanner.nextLine();
                                if(resposta == 1){
                                    seguradoraListar = seguradora;
                                    break;
                                }
                            
                            }
                        }

                        if(seguradoraListar == null) {
                            System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e tente novamente");
                        }
                    }
                        
                    
                    System.out.println("Qual o nome do cliente que você deseja listar os veículos?");
                    String nomeClienteListar = scanner.nextLine();

                    for(Cliente cliente : seguradoraListar.listarClientes()) {
                        if(cliente.getNome().equals(nomeClienteListar)) {
                            System.out.println(cliente.toString());
                            System.out.println("****");
                            System.out.println("Confira as informações desse cliente. Caso seja ele, digite 1, caso não, digite 2");
                            int resposta = scanner.nextInt();
                            lixo = scanner.nextLine();

                            if(resposta == 1) {
                                clienteListar = cliente;
                                break;
                            }

                        }
                    }

                    if(clienteListar == null) {
                        System.out.println("Cliente não encontrado na base de dados, tente outro nome ou verifique as informações");
                    } else {

                        for(Veiculo veiculo : clienteListar.getVeiculos()) {
                            System.out.println(veiculo.toString());
                        }

                    }
                } else if (operacao == MenuListar.LISTAR_VEICULOS_SEGURADORA.operacao) {
                    Seguradora seguradoraListar = null;

                    while(seguradoraListar == null) {
                        System.out.println("****************");
                        System.out.println("Por favor digite o nome da seguradora que você deseja listar os veículos");
                        String nomeSeguradora = scanner.nextLine();
                        for(Seguradora seguradora : listaSeguradorasDoSistema) {
                            if (seguradora.getNome().equals(nomeSeguradora)) {
                                System.out.println(seguradora.toString());
                                System.out.println("****");
                                System.out.println("Confira as informações dessa seguradora. Caso seja ela, digite 1, caso não, digite 2");
                                int resposta = scanner.nextInt();
                                lixo = scanner.nextLine();

                                if(resposta == 1) {
                                    seguradoraListar = seguradora;
                                    break;
                                }
                            }
                        }

                        if(seguradoraListar == null) {
                            System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e digite novamente");
                        } 
                    }

                    for(Veiculo veiculo : seguradoraListar.listarVeiculosSeguradora()) {
                        System.out.println(veiculo.toString());
                    }

                } else {
                    //faz nada
                }

            } else if (operacao == MenuOperacoes.REMOVER.operacao) {
                System.out.println("****************");
                System.out.println("MENU REMOÇÃO");
                System.out.println("1 - EXCLUIR CLIENTE");
                System.out.println("2 - EXCLUIR VEÍCULO");
                System.out.println("3 - EXCLUIR SINISTRO");
                System.out.println("4 - VOLTAR");
                System.out.println("Digite o número da operação desejada");

                operacao = scanner.nextInt();
                lixo = scanner.nextLine();

                if (operacao == MenuRemover.EXCLUIR_CLIENTE.operacao) {
                    Seguradora seguradoraRemover = null;
                    System.out.println("Digite o nome da seguradora do cliente a ser removido");
                    String nomeSeguradora = scanner.nextLine();
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if(seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraRemover = seguradora;
                            break;
                        }
                    }

                    if(seguradoraRemover == null) {
                        System.out.println("Seguradora não encontrada no sistema. Verifique o nome e tente novamente");
                    } else {

                        System.out.println("Digite o CPF/CNPJ do cliente a ser removido");
                        String cpf_OU_cnpj = scanner.nextLine();

                        if(!seguradoraRemover.removerCliente(cpf_OU_cnpj)) {
                            System.out.println("Tente novamente");
                        } 

                    }


                } else if (operacao == MenuRemover.EXCLUIR_SINISTRO.operacao) {
                    Seguradora seguradoraRemover = null;
                    System.out.println("Digite o nome da seguradora do sinistro a ser removido");
                    String nomeSeguradora = scanner.nextLine();

                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if(seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraRemover = seguradora;
                            break;
                        }
                        
                    }

                    if(seguradoraRemover == null) {
                        System.out.println("Seguradora não encontrada na base de dados. Verifique os dados e tente novamente"); 
                    } else {

                        System.out.println("Digite o ID do sinistro a ser removido");
                        int id = scanner.nextInt();
                        lixo = scanner.nextLine();

                        if(!seguradoraRemover.removerSinistro(id)) {
                            System.out.println("Tente novamente");
                        }
                    }


                } else if (operacao == MenuRemover.EXCLUIR_VEICULO.operacao) {
                    Seguradora seguradoraRemover = null;
                    Cliente clienteRemover = null;

                    System.out.println("Digite o nome da seguradora do cliente"); 
                    String nomeSeguradora = scanner.nextLine();

                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if(seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraRemover = seguradora;
                            break;
                        }
                    }

                    if(seguradoraRemover == null) {
                        System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e tente novamente");
                    } else {
                        System.out.println("Digite o nome do cliente que possui o veículo");
                        String nomeCliente = scanner.nextLine();

                        for(Cliente cliente : seguradoraRemover.listarClientes()) {
                            if(cliente.getNome().equals(nomeCliente)) {
                                clienteRemover = cliente;
                                break;
                            }
                        }

                        if(clienteRemover == null) {
                            System.out.println("Cliente não encontrado na base de dados. Verifique o nome e tente novamente"); 
                        } else {

                            System.out.println("Digite a placa do carro a ser removido");
                            String placa = scanner.nextLine();

                            clienteRemover.removerVeiculo(placa);
                        }
                        
                    }

                    

                } else {
                    //ele vai sair do menu e na próxima iteração vai acabar indo pro menu principal de novo
                }

            } else if(operacao == MenuOperacoes.GERAR_SINISTRO.operacao) {
                Seguradora seguradoraSinistro = null;
                System.out.println("Digite o nome da seguradora que deseja gerar e cadastrar o sinistro");
                String nomeSeguradora = scanner.nextLine();
                for(Seguradora seguradora : listaSeguradorasDoSistema) {
                    if(seguradora.getNome().equals(nomeSeguradora)) {
                        seguradoraSinistro = seguradora;
                        break;
                    }
                }

                if(seguradoraSinistro == null) {
                    System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e tente novamente");
                } else {

                    Cliente clienteSinistro = null;
                    System.out.println("Digite o nome do cliente");
                    String nomeCliente = scanner.nextLine();
                    for(Cliente cliente : seguradoraSinistro.listarClientes()) {
                        if(cliente.getNome().equals(nomeCliente)) {
                            clienteSinistro = cliente;
                            break;
                        }
                    }

                    if(clienteSinistro == null) {
                        System.out.println("Cliente não encontrado na base de dados. Verifique o nome ou a seguradora e tente novamente");
                    } else {
                        Veiculo veiculoSinistro = null;

                        System.out.println("Digite a data");
                        String data = scanner.nextLine();
                        System.out.println("Digite o endereço");
                        String endereco = scanner.nextLine();
                        System.out.println("Digite a placa do veículo");
                        String placa = scanner.nextLine();

                        for(Veiculo veiculo : clienteSinistro.getVeiculos()) {
                            if(veiculo.getPlaca().equals(placa)) {
                                veiculoSinistro = veiculo;
                                break;
                            }
                        }

                        if(veiculoSinistro == null) {
                            System.out.println("Veículo não cadastrado ainda. Por favor cadastre-o");

                        } else {

                            seguradoraSinistro.gerarSinistro(data, endereco, seguradoraSinistro, veiculoSinistro, clienteSinistro);
                        }
                    }
                    
                }

            } else if(operacao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
                Cliente clienteQueVaiTransferir = null;
                Cliente clienteQueVaiReceber = null;
                Seguradora seguradoraTransferir = null;

                System.out.println("Digite o nome da seguradora dos clientes que realizarão a transferência");
                String nomeSeguradoraTransferir = scanner.nextLine();

                for(Seguradora seguradora : listaSeguradorasDoSistema) {
                    if(seguradora.getNome().equals(nomeSeguradoraTransferir)) {
                        seguradoraTransferir = seguradora;
                        break;
                    }
                }

                if(seguradoraTransferir == null) {
                    System.out.println("Seguradora não encontrada na base de dados. Verifique o nome e tente novamente");
                } else {

                    System.out.println("Digite o nome do cliente que vai transferir o seguro");
                    String nomeClienteTransferir = scanner.nextLine();

                    for(Cliente cliente : seguradoraTransferir.listarClientes()) {
                        if(cliente.getNome().equals(nomeClienteTransferir)) {
                            clienteQueVaiTransferir = cliente;
                            break;
                        }
                    }

                    if(clienteQueVaiTransferir == null) {
                        System.out.println("Cliente não encontrado nessa seguradora. Verifique os dados e tente novamente");
                    } else {

                        System.out.println("Digite o nome do cliente que irá receber");
                        String nomeClienteReceber = scanner.nextLine();
                        
                        for(Cliente cliente : seguradoraTransferir.listarClientes()) {
                            if(cliente.getNome().equals(nomeClienteReceber)) {
                                clienteQueVaiReceber = cliente;
                                break;
                            }
                        }

                            if(clienteQueVaiReceber == null) {
                                System.out.println("Cliente não encontrado nessa seguradora. Verifique os dados e tente novamente");
                            } else {
                                seguradoraTransferir.transferirSeguro(clienteQueVaiTransferir, clienteQueVaiReceber);
                            }
                    }
                }
            

            } else if (operacao == MenuOperacoes.CALCULAR_RECEITA.operacao) {
                Seguradora seguradoraReceita = null;
                System.out.println("Digite o nome da seguradora a ser calculada a receita");

                String nomeSeguradora = scanner.nextLine();

                for(Seguradora seguradora : listaSeguradorasDoSistema) {
                    if(seguradora.getNome().equals(nomeSeguradora)) {
                        seguradoraReceita = seguradora;
                        break;
                    }
                }

                if(seguradoraReceita == null) {
                    System.out.println("Seguradora não encontrada no sistema");
                } else {
                    System.out.println("A receita da seguradora é: " + seguradoraReceita.calcularReceita());
                }
            } else if (operacao == MenuOperacoes.SAIR.operacao) {
                break;
            }
    
        }

        scanner.close();
        
    }
}