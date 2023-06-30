package Arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Main.Veiculo;

//isso aqui vai ler dados
public class ArquivoVeiculo implements Arquivo {
    
    public boolean gravarArquivo() {
        return false;
    }

    public String lerArquivo() {
        return null;
    }

    public String lerArquivo(String caminhoArquivo) {

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

    public ArrayList<Veiculo> transformarDadosParaObjetos(String dados) {
        String[] linhas;
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        Veiculo aux;

        linhas = dados.split("_");

        /* Estrutura
         * Index 0: PLACA
         * Index 1: MARCA
         * Index 2: MODELO
         * Index 3: ANO_FAB
        */

        for (String linha : linhas) {

            String[] infos = linha.split(",");
            
            aux = new Veiculo(infos[0]);
            veiculos.add(aux);

        }

        return veiculos;

    }

}
