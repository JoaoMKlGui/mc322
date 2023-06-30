package Arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Auxiliares.Datas;
import Clientes.ClientePJ;
import Main.Frota;
import Main.Seguradora;

//isso aqui vai ler dados
public class ArquivoClientePJ implements Arquivo {
    
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

    public static ArrayList<ClientePJ> transformarDadosParaObjetos(String dados) {
        String[] linhas;
        ArrayList<ClientePJ> clientes = new ArrayList<ClientePJ>();
        ClientePJ aux;
        Frota frotaAux;
        Seguradora seguradoraPadrao = new Seguradora("Seguradora do jao", "telefone", "oi@gmail.com", "unicamp", "01426582000135");
        

        linhas = dados.split("_");

        /* Estrutura
         * Index 0: CNPJ
         * Index 1: NOME
         * Index 2: TELEFONE
         * Index 3: ENDERECO
         * Index 4: EMAIL
         * Index 5: DATA DE FUNDACAO
         * Index 6: ID FROTA
        */

        //obs: de acordo com os antigos labs, tá faltando várias infos, então algumas coisas serão um padrão pra todas as entradas

        for (String linha : linhas) {

            String[] infos = linha.split(",");
            LocalDate dataFundacaoLocalDate = LocalDate.parse(infos[5]);
            Calendar dataFundacaoCalendar = Datas.converteLocalDateParaCalendar(dataFundacaoLocalDate);

            Calendar dataLicenca = Calendar.getInstance();
            Date data = Calendar.getInstance().getTime(); //como não foi passada a data da licença no csv, estou setando como padrão o dia de hoje
            dataLicenca.setTime(data);

            frotaAux = new Frota(Integer.parseInt(infos[6]));

            aux = new ClientePJ(infos[1], infos[3], dataLicenca, "Superior Completo", "Mutante", "Alta", infos[0], dataFundacaoCalendar, 100, seguradoraPadrao);
            aux.cadastrarFrota(frotaAux);
            clientes.add(aux);

        }

        return clientes;

    }
}
