package Main;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Arquivos.ArquivoClientePF;
import Auxiliares.Datas;
import Auxiliares.Validacao;

import java.util.ArrayList;
import Clientes.*;
import Menus.*;

public class AppMain {

    public static Scanner scanner = new Scanner(System.in);
    public static String lixo;// no scanner, quando eu recolho um número, ele não recolhe o \n, então o lixo serve pra recolher até a próxima linha 

    
    public static ClientePF criarClientePF(Seguradora seguradora) {


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
        
        ClientePF novoCliente = new ClientePF(nome, endereco, dataLicenca, nivelEducacao, genero, classeEco, cpf.replaceAll("[^0-9]+", ""), dataNascimento, seguradora);
        
        //usar o replace all no cpf do atributo gera uma padronização a ser seguida, o que facilita muita coisa

        return novoCliente;
        
    }

    public static ClientePJ criarClientePJ(Seguradora seguradora) {

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
        
        ClientePJ novoCliente = new ClientePJ(nome, endereco, dataLicenca, nivelEducacao, genero, classeEco, cnpj.replaceAll("[^0-9]+", ""), dataFundacao, quantidadeDeFuncionarios, seguradora);
        System.out.println(novoCliente.toString());
        
        //usando o replaceAll no cnpj para criar uma padronização

        return novoCliente;

    }


    public static Seguradora criarSeguradora() {

        System.out.println("Digite o nome da seguradora");
        String nomeSeguradora = scanner.nextLine();
        System.out.println("Digite o telefone");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email");
        String email = scanner.nextLine();
        System.out.println("Digite o endereço");
        String endereco = scanner.nextLine();
        System.out.println("Digite o cnpj da seguradora");
        String cnpj = scanner.nextLine();

        if (Validacao.validarCNPJ(cnpj)) {
            Seguradora novaSeguradora = new Seguradora(nomeSeguradora, telefone, email, endereco, cnpj);
            return novaSeguradora;
        }
        
        return null;
    }

    public static Veiculo criarNovoVeiculo() {

        System.out.println("Digite o modelo do veículo");
        String modelo = scanner.nextLine();
        System.out.println("Digite a marca");
        String marca = scanner.nextLine();
        System.out.println("Digite o ano de fabricação");
        int anoDeFabricacao = scanner.nextInt();
        lixo = scanner.nextLine();
        System.out.println("Digite a placa");
        String placa = scanner.nextLine();

        Veiculo novoVeiculo = new Veiculo(placa);
        

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

    public static Calendar leData() {

        System.out.println("Digite a data no formato DD/MM/YYYY");
        String[] partesDataString = scanner.nextLine().split("/");

        int ano = Integer.parseInt(partesDataString[0]);
        int mes = Integer.parseInt(partesDataString[1]) - 1;
        int dia = Integer.parseInt(partesDataString[2]);

        Calendar dataFinal = new GregorianCalendar(ano, mes, dia);

        return dataFinal;
    }


    public static void main(String[] args) {
        int operacao; //operação escolhida pelo usuário


        ArrayList<Seguradora> listaSeguradorasDoSistema = new ArrayList<Seguradora>();


        String dataLic = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] partes_da_data = dataLic.split("_");
        int anoLicenca = Integer.parseInt(partes_da_data[0]);
        int mesLicenca = Integer.parseInt(partes_da_data[1]) - 1;
        int diaLicenca = Integer.parseInt(partes_da_data[2]);

        Calendar dataLicenca = new GregorianCalendar(anoLicenca, mesLicenca, diaLicenca);


        Calendar data1 = new GregorianCalendar(2003, 11, 31); //lembrando que mês 11 é dezembro porque o calendar começa a contar do 0
        Calendar data2 = new GregorianCalendar(2001, 8, 11);

        Seguradora seguradoraPreCadastrado = new Seguradora("Ale Seixas", "(19) 993423301", "a260533@dac.unicamp.br", "campinas", "28.884.061/0001-88");
        listaSeguradorasDoSistema.add(seguradoraPreCadastrado);
        ClientePF clientePF = new ClientePF("joao", "unicamp", dataLicenca, "superior", "masculino","alta", "104.337.449-36", data1, seguradoraPreCadastrado);
        ClientePJ clientePJ = new ClientePJ("Oficina Simas Turbo", "Unicamp", dataLicenca, "fundamental", "masculino", "alta", "55.889.662/0001-56", data2, 100, seguradoraPreCadastrado);
        seguradoraPreCadastrado.cadastrarCliente(clientePJ);
        seguradoraPreCadastrado.cadastrarCliente(clientePF);
        Veiculo veiculo1 = new Veiculo("FDP-0000");
        Veiculo veiculo2 = new Veiculo("OFF-0000");
        clientePF.adicionarVeiculo(veiculo1);
        clientePJ.adicionarVeiculo(veiculo2);
    
        System.out.println(clientePF);
        System.out.println(clientePJ);

        for(Cliente cliente : seguradoraPreCadastrado.listarClientes()) {
            System.out.println(cliente);
        }

        System.out.println("Digite o caminho");
        String caminho = scanner.nextLine();

        String dados = ArquivoClientePF.lerArquivo(caminho);
        ArrayList<ClientePF> clientes = ArquivoClientePF.transformarDadosParaObjetos(dados);

        for (ClientePF cliente : clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println(seguradoraPreCadastrado.calcularReceita());


        System.out.println("****************");
        System.out.println("Bem vindo ao App SeguradorasSystem!");
        System.out.println("****************");

        while(true) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - CADASTROS");
            System.out.println("2 - LISTAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - GERAR SINISTRO");
            System.out.println("5 - TRANSFERIR SEGURO");
            System.out.println("6 - CALCULAR RECEITA SEGURADORA");
            System.out.println("7 - GERENCIAR SEGUROS");
            System.out.println("0 - SAIR");
            System.out.println();
            System.out.println("Digite o número da operação desejada");

            operacao = scanner.nextInt();
            lixo = scanner.nextLine();

            if(operacao == MenuOperacoes.CADASTRAR.operacao) {
                System.out.println("****************");
                System.out.println("MENU CADASTROS");
                System.out.println("1 - CADASTRAR CLIENTE PF/PJ");
                System.out.println("2 - CADASTRAR VEÍCULO DE CLIENTE PF");
                System.out.println("3 - CADASTRAR SEGURADORA");
                System.out.println("4 - CADASTRAR NOVA FROTA");
                System.out.println("5 - CADASTRAR NOVO VEÍCULO EM UMA FROTA");
                System.out.println("6 - VOLTAR");
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
                            ClientePF clientePf = criarClientePF(seguradoraParaCadastrar);
                            cadastrarCliente(clientePf, seguradoraParaCadastrar);
                            
                            
                        } else if (opcao == 2) {
                            ClientePJ clientePj = criarClientePJ(seguradoraParaCadastrar);
                            cadastrarCliente(clientePj, seguradoraParaCadastrar);
                            
                        } 
                    }
            

                } else if (operacao == MenuCadastro.CADASTRAR_SEGURADORA.operacao) {
                    
                    Seguradora novaSeguradora = criarSeguradora();
                    if(novaSeguradora != null) {
                        listaSeguradorasDoSistema.add(novaSeguradora);
                        System.out.println("Seguradora cadastrada com sucesso ao sistema!");
                    } else {
                        System.out.println("CNPJ inválido. Tente novamente");
                    }
                    

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
                        }
                    }


                } else if (operacao == MenuCadastro.CADASTRAR_FROTA.operacao) {
                    Seguradora seguradoraFrota = null;
                    

                    System.out.println("Digite o nome da seguradora do cliente que possuirá tal frota");
                    String nomeSeguradora = scanner.nextLine();

                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraFrota = seguradora;
                            break;
                        }
                    }

                    if (seguradoraFrota == null) {
                        System.out.println("Nenhuma seguradora com tal nome achada no sistema. Verifique o nome e tente novamente");
                    } else {

                        System.out.println("Digite o CNPJ do cliente que possuirá a frota");
                        String cnpj = scanner.nextLine();

                        Cliente clienteFrota = seguradoraFrota.procurarCliente(cnpj); //não preciso formatar utilizando o replaceAll pois o método procurar cliente já faz isso 
                        
                        if (clienteFrota == null) {
                            System.out.println("Cliente não encontrado");
                        } else {

                            System.out.println("Digite o nome da nova frota ser cadastrada");

                            String nomeNovaFrota = scanner.nextLine();
                            Random random = new Random();
                            Frota novaFrota = new Frota(random.nextInt(0, 2000000000));

                            ((ClientePJ) clienteFrota).cadastrarFrota(novaFrota); 

                            System.out.println("Segue abaixo as informações da nova frota. Guarde tais infos, pois elas poderão ser requisitadas futuramente");
                            System.out.println(novaFrota.toString());
                            System.out.println("Frota cadastrada com sucesso");

                        }

                    }

                } else if (operacao == MenuCadastro.ATUALIZAR_FROTA.operacao) {
                    //primeiro passo : saber a seguradora que o cliente está
                    
                    Seguradora seguradoraFrota = null;
                    

                    System.out.println("Digite o nome da seguradora do cliente que possui tal frota");
                    String nomeSeguradora = scanner.nextLine();

                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraFrota = seguradora;
                            break;
                        }
                    }

                    if (seguradoraFrota == null) {
                        System.out.println("Nenhuma seguradora com tal nome achada no sistema. Verifique o nome e tente novamente");
                    } else {
                        //segundo passo: saber qual o cliente da frota

                        System.out.println("Digite o CNPJ do cliente que possui a frota");
                        String cnpj = scanner.nextLine();

                        Cliente clienteFrota = seguradoraFrota.procurarCliente(cnpj); //não preciso formatar utilizando o replaceAll pois o método procurar cliente já faz isso 
                        
                        if (clienteFrota == null) {
                            System.out.println("Cliente não encontrado");
                        } else {
                            //terceiro passo: saber a frota

                            System.out.println("Digite o código da frota");

                            int codigoFrota = scanner.nextInt();
                            lixo = scanner.nextLine();
                            Frota frotaAtualizacao = null;

                            for(Frota frota : ((ClientePJ)clienteFrota).getListaFrotas()) {
                                if (frota.getCode() == codigoFrota) {
                                    frotaAtualizacao = frota;
                                    break;
                                }
                            }
                            
                            if (frotaAtualizacao == null) {
                                System.out.println("Nenhuma frota com esse código encontrada");
                            } else {
                                //quarto passo: criar o veículo a ser adicionado na frota
                                
                                System.out.println("Digite a placa do veículo a ser adicionado");
                                String placa = scanner.nextLine();
                                System.out.println("Digite o modelo do veículo");
                                String modelo = scanner.nextLine();
                                System.out.println("Digite a marca do veículo");
                                String marca = scanner.nextLine();
                                System.out.println("Digite o ano de fabricação do veículo");
                                int anoFab = scanner.nextInt();
                                lixo = scanner.nextLine();

                                Veiculo veiculoNovo = new Veiculo(placa);

                                frotaAtualizacao.adicionarVeiculo(veiculoNovo);
                                System.out.println("Veículo adicionado com sucesso");
                            }


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
                System.out.println("6 - LISTAR SEGUROS DA SEGURADORA");
                System.out.println("7 - LISTAR CONDUTORES DE UM SEGURO");
                System.out.println("8 - VOLTAR");
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
                    

                } else if (operacao == MenuListar.LISTAR_SINISTROS_CONDUTOR.operacao) {
                    Seguradora seguradoraListar = null;

                    System.out.println("****************");
                    System.out.println("Por favor digite o nome da seguradora que você deseja listar os sinistros do condutor");
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
                        System.out.println("Qual o nome do cpf que você deseja listar os sinistros?");
                        String cpf = scanner.nextLine();

                        seguradoraListar.listarSinistrosPorCondutor(cpf.replaceAll("[^0-9]+", ""));

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

                } else if (operacao == MenuListar.LISTAR_SEGUROS.operacao) {
                    Seguradora seguradoraListar = null;
                    System.out.println("Digite o nome da seguradora");
                    String nomeSeguradora = scanner.nextLine();
                    
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraListar = seguradora;
                            break;
                        }
                    }

                    if(seguradoraListar == null) {
                        System.out.println("Seguradora não encontrada");
                    } else {

                        for(Seguro seguro : seguradoraListar.listarSeguros()) {
                            System.out.println(seguro.toString());
                        }

                    }   

                } else if (operacao == MenuListar.LISTAR_CONDUTORES.operacao) {
                    Seguradora seguradoraListar = null;
                    System.out.println("Digite o nome da seguradora");
                    String nomeSeguradora = scanner.nextLine();
                    
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraListar = seguradora;
                            break;
                        }
                    }

                    if(seguradoraListar == null) {
                        System.out.println("Seguradora não encontrada");
                    } else {

                        for(Seguro seguro : seguradoraListar.listarSeguros()) {
                            for (Condutor condutor : seguro.getListaCondutores()) {
                                System.out.println(condutor.toString());
                            }
                        }

                    }   
                } else if (operacao == MenuListar.LISTAR_VEICULOS_FROTA.operacao) {
                    Seguradora seguradoraListar = null;
                    System.out.println("Digite o nome da seguradora do cliente que possui a frota");
                    String nomeSeguradora = scanner.nextLine();

                    for (Seguradora seguradora : listaSeguradorasDoSistema) {
                        if(seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraListar = seguradora;
                            break;
                        }
                    }

                    if (seguradoraListar == null) {
                        System.out.println("Seguradora não encontrada no sistema");
                    } else {
                        System.out.println("Digite o CNPJ do cliente que possui a frota");

                        String cnpj = scanner.nextLine();
                        Cliente clienteListar = seguradoraListar.procurarCliente(cnpj);

                        if (clienteListar == null) {
                            System.out.println("Cliente com o CNPJ dado não encontrado");
                        } else {

                            System.out.println("Digite o código da frota");
                            int codigoFrota = scanner.nextInt();
                            lixo = scanner.nextLine();
                            Frota frotaListar = null;
                            
                            for (Frota frota : ((ClientePJ)clienteListar).getListaFrotas()) {
                                if (frota.getCode() == codigoFrota) {
                                    frotaListar = frota;
                                    break;
                                }
                            }

                            if (frotaListar == null) {
                                System.out.println("Frota não encontrada. Verifique o código");
                            } else {
                                for (Veiculo veiculo : frotaListar.getListaVeiculos()) {
                                    System.out.println(veiculo.toString());
                                }
                            }

                        }
                        
                    }

                } else if (operacao == MenuListar.LISTAR_FROTAS.operacao) {
                    Seguradora seguradoraListar = null;
                    System.out.println("Digite o nome da seguradora do cliente que possui a frota");
                    String nomeSeguradora = scanner.nextLine();

                    for (Seguradora seguradora : listaSeguradorasDoSistema) {
                        if(seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraListar = seguradora;
                            break;
                        }
                    }

                    if (seguradoraListar == null) {
                        System.out.println("Seguradora não encontrada no sistema");
                    } else {
                        System.out.println("Digite o CNPJ do cliente que possui a frota");

                        String cnpj = scanner.nextLine();
                        Cliente clienteListar = seguradoraListar.procurarCliente(cnpj);
                        
                        if (clienteListar == null) {
                            System.out.println("Cliente com tal CNPJ não encontrado");
                        } else {

                            for (Frota frota : ((ClientePJ)clienteListar).getListaFrotas()) {
                                System.out.println(frota.toString());
                            }

                        }

                    }


                } else {
                    //faz nada pq ai ele volta
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
                            System.out.println("Sinistro não encontrado. Tente novamente");
                        } else {
                            System.out.println("Sinistro removido com sucesso");
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
                Seguro seguroSinistro = null;
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

                    System.out.println("Digite o ID do seguro");
                    int id  = scanner.nextInt();
                    lixo = scanner.nextLine();

                    for (Seguro seguro : seguradoraSinistro.listarSeguros()) {
                        if(seguro.getID() == id) {
                            seguroSinistro = seguro;
                            break;
                        }
                    }
                    
                    if (seguroSinistro == null) {
                        System.out.println("Seguro não encontrado, tente novamente");
                    } else {
                        Condutor condutorSinistro = null;

                        System.out.println("Digite o cpf do condutor");

                        String cpf = scanner.nextLine();

                        for(Condutor condutor : seguroSinistro.getListaCondutores()) {
                            if(condutor.getCpf().equals(cpf)) {
                                condutorSinistro = condutor;
                                break;
                            }
                        }

                        if(condutorSinistro == null) {
                            System.out.println("Cliente não encontrado na base de dados. Verifique o nome ou a seguradora e tente novamente");
                        } else {
                            

                            Veiculo veiculoSinistro = null;

                            Calendar dataSinistroCalendar = leData();
                            String dataSinistroString = Datas.converteCalendarParaString(dataSinistroCalendar);
                            
                            System.out.println("Digite o endereço");
                            String endereco = scanner.nextLine();
                            System.out.println("Digite a placa do veículo");
                            String placa = scanner.nextLine();
                            
                            if (seguroSinistro instanceof SeguroPJ) {

                                for (Veiculo veiculo : ((SeguroPJ)seguroSinistro).getFrota().getListaVeiculos()) {
                                    if (veiculo.getPlaca().equals(placa)) {
                                        veiculoSinistro = veiculo;
                                        break;
                                    }
                                }

                                if (veiculoSinistro == null) {
                                    System.out.println("Veículo não encontrado na frota seguradad");
                                } else {
                                    seguroSinistro.gerarSinistro(dataSinistroString, endereco, seguroSinistro, veiculoSinistro, condutorSinistro);
                                    System.out.println("Sinistro gerado com sucesso");
                                }

                            }

                            else {

                                veiculoSinistro = ((SeguroPF)seguroSinistro).getVeiculo();
    
                                seguroSinistro.gerarSinistro(dataSinistroString, endereco, seguroSinistro, veiculoSinistro, condutorSinistro);
                                System.out.println("Sinistro gerado com sucesso");
                                
                            }

                            
                        }
                    }

                    
                    
                }

            } else if(operacao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {

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

                    System.out.println("Você deseja transferir um seguro PF ou um seguro PJ");
                    System.out.println("Digite 1 para PF e digite 2 para PJ");
                    
                    int opcaoSeguro = scanner.nextInt();
                    lixo = scanner.nextLine();

                    if(opcaoSeguro == 1) {

                        Cliente clienteQueVaiReceberPF = null;
                        Seguro seguroTransferido = null;
                        
                        System.out.println("Digite o CPF do cliente");
                        String cpf = scanner.nextLine();

                        clienteQueVaiReceberPF = seguradoraTransferir.procurarCliente(cpf.replaceAll("[^0-9]+", ""));

                        if (clientePF == null) {
                            System.out.println("Cliente não encontrado");
                        } else {
                            System.out.println("Digite o ID do seguro que será transferido");
                            int id = scanner.nextInt();
                            lixo = scanner.nextLine();

                            for (Seguro seguro : seguradoraTransferir.listarSeguros()) {
                                if (seguro.getID() == id) {
                                    seguroTransferido = seguro;
                                    break;
                                }
                            }

                            if (seguroTransferido == null) {
                                System.out.println("Seguro não encontrado");

                            } else {

                                ((SeguroPF) seguroTransferido).transferirSeguro((ClientePF)clienteQueVaiReceberPF);
                                System.out.println("Seguro transferido com sucesso");

                            }

                        }

                    } else if (opcaoSeguro == 2) {
                        Cliente clienteQueVaiReceberPJ = null;
                        Seguro seguroTransferido = null;
                        
                        System.out.println("Digite o CNPJ do cliente");
                        String cnpj = scanner.nextLine();

                        clienteQueVaiReceberPJ = seguradoraTransferir.procurarCliente(cnpj.replaceAll("[^0-9]+", ""));

                        if (clientePF == null) {
                            System.out.println("Cliente não encontrado");
                        } else {
                            System.out.println("Digite o ID do seguro que será transferido");
                            int id = scanner.nextInt();
                            lixo = scanner.nextLine();

                            for (Seguro seguro : seguradoraTransferir.listarSeguros()) {
                                if (seguro.getID() == id) {
                                    seguroTransferido = seguro;
                                    break;
                                }
                            }

                            if (seguroTransferido == null) {
                                System.out.println("Seguro não encontrado");

                            } else {

                                ((SeguroPJ) seguroTransferido).transferirSeguro((ClientePJ)clienteQueVaiReceberPJ);
                                System.out.println("Seguro transferido com sucesso");

                            }

                        }
                    } else {
                        System.out.println("Digite uma opção válida");
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
            } else if (operacao == MenuOperacoes.GERENCIAR_SEGUROS.operacao) {
                System.out.println();
                System.out.println("Qual dessas ações você deseja realizar?");
                System.out.println("**************");
                System.out.println("1 - Cadastrar seguro");
                System.out.println("2 - Cancelar Seguro");
                
                operacao = scanner.nextInt();
                lixo = scanner.nextLine();
                int opcaoCliente;
                Seguradora seguradoraCadastroSeguro = null;

                if(operacao == 1) {
                    System.out.println();
                    System.out.println("Digite 1 caso queira um seguro para pessoa PJ e digite 2 caso queria seguro para uma PF");
                    opcaoCliente = scanner.nextInt();
                    lixo = scanner.nextLine();

                    if (opcaoCliente == 1) {
                        System.out.println("Digite o nome da seguradora");
                        String nomeSeguradora = scanner.nextLine();
                        
                        for (Seguradora seguradora : listaSeguradorasDoSistema) {
                            if(seguradora.getNome().equals(nomeSeguradora)) {
                                seguradoraCadastroSeguro = seguradora;
                                break;
                            }
                        }

                        if (seguradoraCadastroSeguro == null) {
                            System.out.println("Seguradora com o nome especificado não encontrada. Digite novamente ou cadastre a seguradora");
                        } else {
                            System.out.println("Digite o CPF do cliente");
                            String cpfCliente = scanner.nextLine();
                            Cliente clienteSeguro = null;

                            clienteSeguro = seguradoraCadastroSeguro.procurarCliente(cpfCliente);

                            if (clienteSeguro == null) {
                                System.out.println("Cliente não encontrado, verifique os dados");
                            } else {
                                System.out.println("Digite a placa do veículo do cliente que você deseja segurar");
                                String placa = scanner.nextLine();

                                Veiculo veiculoSegurar = null;

                                for (Veiculo veiculo : clienteSeguro.getVeiculos()) {
                                    if (veiculo.getPlaca().equals(placa)) {
                                        veiculoSegurar = veiculo;
                                        break;
                                    }
                                }

                                if (veiculoSegurar != null) {
                                    seguradoraCadastroSeguro.gerarSeguro((ClientePF)clienteSeguro, veiculoSegurar);
                                    System.out.println("Seguro gerado com sucesso!");
                                } else {
                                    System.out.println("Veículo não encontrado, verifique as infos");
                                }

                            } 

                            
                        


                        }

                    } else if (opcaoCliente == 2) {
                        System.out.println("Digite o nome da seguradora");
                        String nomeSeguradora = scanner.nextLine();
                        
                        for (Seguradora seguradora : listaSeguradorasDoSistema) {
                            if(seguradora.getNome().equals(nomeSeguradora)) {
                                seguradoraCadastroSeguro = seguradora;
                                break;
                            }
                        }

                        if (seguradoraCadastroSeguro == null) {
                            System.out.println("Seguradora com o nome especificado não encontrada. Digite novamente ou cadastre a seguradora");
                        } else {
                            System.out.println("Digite o CNPJ do cliente");
                            String cnpjCliente = scanner.nextLine();
                            Cliente clienteSeguro = null;

                            clienteSeguro = seguradoraCadastroSeguro.procurarCliente(cnpjCliente);
    

                            if (clienteSeguro == null) {
                                System.out.println("Cliente não encontrado, verifique os dados");
                            } else {
                                System.out.println("Digite o código da frota que você deseja segurar");
                                int codeFrota = scanner.nextInt();
                                lixo = scanner.nextLine();

                                Frota frotaSegurar = null;

                                for (Frota frota : ((ClientePJ)clienteSeguro).getListaFrotas()) {
                                    if (frota.getCode() == codeFrota) {
                                        frotaSegurar = frota;
                                        break;
                                    }
                                }

                                if (frotaSegurar != null) {
                                    seguradoraCadastroSeguro.gerarSeguro((ClientePJ)clienteSeguro, frotaSegurar);
                                    System.out.println("Seguro gerado com sucesso!");
                                } else {
                                    System.out.println("Frota não encontrada, verifique as infos");
                                }

                            } 

                        }
                    } else {
                        System.out.println("Digite uma opção válida!");
                    }

                } else if (operacao == 2) { 
                    System.out.println("Digite o nome da seguradora");
                    String nomeSeguradora = scanner.nextLine();
                    Seguradora seguradoraCancelarSeguro = null;
                    
                    for(Seguradora seguradora : listaSeguradorasDoSistema) {
                        if (seguradora.getNome().equals(nomeSeguradora)) {
                            seguradoraCancelarSeguro = seguradora;
                            break;
                        }
                    }
                    
                    if(seguradoraCancelarSeguro == null) {
                        System.out.println("Seguradora não encontrada no sistema. Verifique o nome");
                    } else {
                        System.out.println("Digite o ID do seguro");
                        int id = scanner.nextInt();
                        lixo = scanner.nextLine();
                        Seguro seguroCancelar = null;
                        
                        for (Seguro seguro : seguradoraCancelarSeguro.listarSeguros()) {
                            if(seguro.getID() == id) { //os dois são ints então posso usar o ==
                                seguroCancelar = seguro;
                                break;
                            }
                        }

                        if(seguroCancelar == null) {
                            System.out.println("Seguro não encontrado, por favor verifique o ID e tente novamente");
                        } else {
                            seguradoraCancelarSeguro.cancelarSeguro(seguroCancelar);
                            System.out.println("Seguro cancelado com sucesso");
                        }

                    }

                } else {
                    System.out.println("Digite uma opção válida");
                }
                

            } else if (operacao == MenuOperacoes.SAIR.operacao) {
                break;
            } 
    
        }

        scanner.close();
        
    }
}