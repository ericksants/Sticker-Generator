import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class ExtraiConteudoNasa implements ExtratorDeConteudo {
    public List<Conteudo> extrairConteudos(String json){

        var parse = new JsonParser();
        List<Map<String, String>> listaConteudo = parse.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        
        for (Map<String, String> atributos : listaConteudo){
            String urlImagem = atributos.get("url");
            String titulo = atributos.get("title");

            var conteudo = new Conteudo(titulo, urlImagem);


            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
