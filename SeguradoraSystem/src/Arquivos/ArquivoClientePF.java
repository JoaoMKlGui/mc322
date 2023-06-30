package Arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import Auxiliares.Datas;
import Clientes.ClientePF;
import Main.Seguradora;
import Main.Veiculo;

//isso aqui vai ler dados
public class ArquivoClientePF implements Arquivo {

    public boolean gravarArquivo() {
        return false;
    }

    public String lerArquivo() {
        return null;
    }

    public static String lerArquivo(String caminhoArquivo) {

        String finalString = "";

        try { //try para evitar que haja um erro caso o arquivo não exista ou o caminho esteja errado

            BufferedReader arquivoEntrada = new BufferedReader(new FileReader(caminhoArquivo)); 
            
            try {
                String linhaLida;
                linhaLida = arquivoEntrada.readLine(); //ler essa linha pois vai ser a linha que contém o nome das colunas, o que não me importa

                while ((linhaLida = arquivoEntrada.readLine()) != null) { //se acabar o arquivo, ele sai do while e para de manipular
                    finalString += linhaLida + "_";
                }   

            } catch (IOException exception) {
                System.out.println("Houve um erro: " + exception.getMessage());
                arquivoEntrada.close();
                return null;
            } 

            arquivoEntrada.close();
        
        } catch (IOException exception) {
            System.out.println("Houve um problema na hora de ler o arquivo através do caminho passado");
            System.out.println("Erro: " + exception.getMessage());
            System.out.println("Verifique os dados passados, principalmente o caminho passado para chegar ao arquivo, e tente novamente");

            return null;
        }
    
        return finalString;

    }

    public static ArrayList<ClientePF> transformarDadosParaObjetos(String dados) {
        String[] linhas;
        ArrayList<ClientePF> clientes = new ArrayList<ClientePF>();
        ClientePF aux;
        Veiculo veiculoAux;
        Seguradora seguradoraPadrao = new Seguradora("Seguradora do jao", "telefone", "oi@gmail.com", "unicamp", "01426582000135");
        

        linhas = dados.split("_");

        /* Estrutura
         * Index 0: CPF
         * Index 1: NOME
         * Index 2: TELEFONE
         * Index 3: ENDERECO
         * Index 4: EMAIL
         * Index 5: SEXO
         * Index 6: ENSINO
         * Index 7: DATA DE NASCIMENTO
         * Index 8: PLACA CARRO
        */

        //obs: de acordo com os antigos labs, tá faltando várias infos, então algumas coisas serão um padrão pra todas as entradas

        for (String linha : linhas) {

            String[] infos = linha.split(",");
            LocalDate dataNascimentoLocalDate = LocalDate.parse(infos[7]);
            Calendar dataNascimentoCalendar = Datas.converteLocalDateParaCalendar(dataNascimentoLocalDate);

            Calendar dataLicenca = Calendar.getInstance();
            Date data = Calendar.getInstance().getTime(); //como não foi passada a data da licença no csv, estou setando como padrão o dia de hoje
            dataLicenca.setTime(data);

            veiculoAux = new Veiculo(infos[8]);
            aux = new ClientePF(infos[1], infos[3], dataLicenca, infos[6], infos[5], "Alta", infos[0], dataNascimentoCalendar, seguradoraPadrao);
            aux.adicionarVeiculo(veiculoAux);
            clientes.add(aux);

        }

        return clientes;

    }
}
