package Arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import Auxiliares.Datas;
import Main.Condutor;

//isso aqui vai ler dados
public class ArquivoCondutor implements Arquivo {
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

    public static ArrayList<Condutor> transformarDadosParaObjetos(String dados) {
        String[] linhas;
        ArrayList<Condutor> condutores = new ArrayList<Condutor>();
        Condutor aux;
        

        linhas = dados.split("_");

        /* Estrutura
         * Index 0: CPF
         * Index 1: NOME
         * Index 2: TELEFONE
         * Index 3: ENDERECO
         * Index 4: EMAIL
         * Index 5: DATA DE NASCIMENTO
        */

        for (String linha : linhas) {

            String[] infos = linha.split(",");
            LocalDate dataNascimentoLocalDate = LocalDate.parse(infos[5]);
            Calendar dataNascimentoCalendar = Datas.converteLocalDateParaCalendar(dataNascimentoLocalDate);

            aux = new Condutor(infos[0], infos[1], infos[2], infos[3], infos[4], dataNascimentoCalendar);

            condutores.add(aux);

        }

        return condutores;

    }
}
