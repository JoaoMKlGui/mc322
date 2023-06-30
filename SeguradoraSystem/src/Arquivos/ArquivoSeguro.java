package Arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Main.Condutor;
import Main.Seguro;
import Main.Sinistro;
import Auxiliares.Datas;

//isso aqui vai gravar dados
public class ArquivoSeguro implements Arquivo {
    
    
    public static boolean gravarArquivo(ArrayList<Seguro> seguros) {
        //o arquivo será gravado em um diretório chamado "arquivos_gravados", dentro de SeguradoraSystem
        //por conta disso pegaremos o absolutePath (diretório Arquivos), o diretório pai (src), e em seguida o diretório pai também (SeguradoraSystem)

        String caminhoArquivoSaida = "../ArquivosGravados/SeguroGravado.txt"; //os arquivos de sinistros serão gravados no formato csv
        String idSeguro;
        String dataInicioSeguro;
        String dataFimSeguro;
        String nomeSeguradora;
        String concatenadaIDsSinistros = "";
        String concatenadaCPFsCondutores = "";
        String valorSeguro;

        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(caminhoArquivoSaida)); //comando que pode dar erro e motiva o try catch 

            for (Seguro seguro: seguros) {

                idSeguro = String.valueOf(seguro.getID());
                dataInicioSeguro = Datas.converteCalendarParaString(seguro.getDataInicio());
                dataFimSeguro = Datas.converteCalendarParaString(seguro.getDataFim()); //recolhendo as infos
                nomeSeguradora = seguro.getSeguradora().getNome();
                valorSeguro = String.valueOf(seguro.getValorMensal());

                for (Sinistro sinistro : seguro.listarSinistros()) {
                    concatenadaIDsSinistros = concatenadaIDsSinistros + ";" + (String.valueOf(sinistro.getID())); //concatenando todos os ids de sinistro
                }

                for (Condutor condutor : seguro.getListaCondutores()) {
                    concatenadaCPFsCondutores = concatenadaCPFsCondutores + ";" + condutor.getCpf(); //concatenando os cpfs dos condutores
                }



                out.write(idSeguro + ",");
                out.write(dataInicioSeguro + ",");
                out.write(dataFimSeguro + ",");         // bloco para gravar os dados de cada coluna para cada seguro que será gravado
                out.write(nomeSeguradora + ",");
                out.write(concatenadaIDsSinistros + ",");
                out.write(concatenadaCPFsCondutores + ",");
                out.write(valorSeguro + ",");
                out.newLine();

            }

            out.close();
 

        } catch (IOException exception) {

            System.out.println("Houve um erro: " + exception.getMessage());
            return false;

        }
        
        return true;
    }

    public boolean gravarArquivo() { //pra compilar devido à interface
        return false;
    }

    public String lerArquivo() {
        return null;
    }

}
