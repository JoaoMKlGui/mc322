package Arquivos;
import Main.Frota;
import Main.Veiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//isso aqui vai ler dados
public class ArquivoFrota implements Arquivo {
    
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

    public static ArrayList<Frota> transformarDadosParaObjetos(String dados) {
        String[] linhas;
        ArrayList<Frota> frotas = new ArrayList<Frota>();
        Veiculo veiculo1;
        Veiculo veiculo2;
        Veiculo veiculo3;

        Frota aux;

        linhas = dados.split("_");

        /* Estrutura
         * Index 0: ID_FROTA
         * Index 1: PLACA 1
         * Index 2: PLACA 2
         * Index 3: PLACA 3
        */

        for (String linha : linhas) {

            String[] infos = linha.split(",");
            aux = new Frota(Integer.parseInt(infos[0]));
            veiculo1 = new Veiculo(infos[1]);
            veiculo2 = new Veiculo(infos[2]);
            veiculo3 = new Veiculo(infos[3]);
            aux.adicionarVeiculo(veiculo1);
            aux.adicionarVeiculo(veiculo2);
            aux.adicionarVeiculo(veiculo3);

            frotas.add(aux);

        }

        return frotas;

    }

}
