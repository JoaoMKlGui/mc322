package Arquivos;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import Main.Sinistro;
import java.io.File;

//isso aqui vai gravar dados
public class ArquivoSinistro implements Arquivo {
    


    public boolean gravarArquivo(String caminho, ArrayList<Sinistro> sinistros) {
        //o arquivo será gravado em um diretório chamado "arquivos_gravados", dentro de SeguradoraSystem
        //por conta disso pegaremos o absolutePath (diretório Arquivos), o diretório pai (src), e em seguida o diretório pai também (SeguradoraSystem)


        String caminhoArquivoSaida = caminho; //os arquivos de sinistros serão gravados no formato csv

        String idSinistro;
        String dataSinistro;
        String endereco;
        String cpfCondutor;
        String idSeguro;
        

        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(caminhoArquivoSaida)); //comando que pode dar erro e motiva o try catch 

            for (Sinistro sinistro : sinistros) {

                idSinistro = String.valueOf(sinistro.getID());
                dataSinistro = sinistro.getData();
                endereco = sinistro.getEndereco();
                cpfCondutor = sinistro.getCondutor().getCpf();
                idSeguro = String.valueOf(sinistro.getSeguro().getID());

                out.write(idSinistro + ",");
                out.write(dataSinistro + ",");
                out.write(endereco + ",");         // bloco para gravar os dados de cada coluna para cada seguro que será gravado
                out.write(cpfCondutor + ",");
                out.write(idSeguro);
                out.newLine();

            }

            out.close();
 

        } catch (IOException exception) {

            System.out.println("Houve um erro: " + exception.getMessage());
            return false;

        }
        
        return true;
    }

    public String lerArquivo(String caminhoArquivo) {
        //transformar os dados que estão gravados em csv para um objeto, devolvendo um arraylist

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

    public ArrayList<Sinistro> transformarDadosParaObjetos(String dados) {
        ArrayList<Sinistro> sinistrosLidos = new ArrayList<Sinistro>();
        Sinistro novoSinistro;

        String[] dadosSeparados = dados.split("_"); //agora os dados estão separados por vírgula e cada sinistro, com seus respectivos dados separados por vírgula, está em uma posição do vetor

        for (String linha : dadosSeparados) {

            String[] linhaSeparada = dados.split(","); 

            /*
             * Estrutura:
             * index 0: ID
             * index 1: Data
             * index 2: Endereco
             * index 3: Condutor
             * index 4: ID do seguro
             */

            if (linhaSeparada.length != 5) {
                System.out.println("Erro na conversão do arquivo para sinistros");
                return null;
            }

            novoSinistro = new Sinistro(linhaSeparada[1], linhaSeparada[2], )
            

        }
        
        return sinistrosLidos;
    }

}
