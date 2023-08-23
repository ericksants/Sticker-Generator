import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        // fazer uma conexao http
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json"; //salvando a URL em uma variavel
        //ExtratorDeConteudo extratorConteudo = new ExtraiConteudo();

        //String url ="https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-01-12&end_date=2023-01-16";
        //ExtratorDeConteudo extratorConteudo = new ExtraiConteudoNasa();

        //minha api
        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extratorConteudo = new ExtraiConteudo();

        var http = new ClientHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extratorConteudo.extrairConteudos(json);
        var stickers =  new Stickers();
        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlimagem()).openStream();
            String nomeArquivo =  conteudo.getTitulo() + ".png";

            stickers.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}
