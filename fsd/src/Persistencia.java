import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

public class Persistencia {
    XStream xStream = new XStream(new DomDriver("UTF-8"));
    // metodo salvar dados nos arquivos

        public void salvarCentral(CentralDeInformacoes programa, String arquivoPrograma){
            try {
                File arquivo = new File(arquivoPrograma);
                arquivo.createNewFile();
                PrintWriter pW = new PrintWriter(arquivo);
                String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
                xml += xStream.toXML(programa);
                pW.print(xml);
                pW.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    // exceções exception são quando um arquivo não existe
    public CentralDeInformacoes recuperarCentral(String nomeArquivo){
        try {
            File arquivo = new File(nomeArquivo);
            xStream.allowTypes(new Class[] {CentralDeInformacoes.class,ProgramaDeTv.class,Canal.class});
            if (arquivo.exists()) {
                return (CentralDeInformacoes) xStream.fromXML(new FileInputStream(arquivo));

            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new CentralDeInformacoes();
    }
}
