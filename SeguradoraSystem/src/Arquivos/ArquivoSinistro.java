package Arquivos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Main.Sinistro;

//isso aqui vai gravar dados
public class ArquivoSinistro implements Arquivo {
    

    public static boolean gravarArquivo(ArrayList<Sinistro> sinistros) {
        //o arquivo será gravado em um diretório chamado "arquivos_gravados", dentro de SeguradoraSystem
        //por conta disso pegaremos o absolutePath (diretório Arquivos), o diretório pai (src), e em seguida o diretório pai também (SeguradoraSystem)

        String caminhoArquivoSaida = "../ArquivosGravados/SinistroGravado.txt"; //os arquivos de sinistros serão gravados no formato csv

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

    public boolean gravarArquivo() { //feito apenas pra compilar devido à interface
        return false;
    }

    public String lerArquivo() {
        return null;
    }

}
