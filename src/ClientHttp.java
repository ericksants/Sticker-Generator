import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {

    public String buscaDados(String url){
        try {
            URI addres = URI.create(url); //transformando a URL em uma URI
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(addres).GET().build(); // realizando a chamada usando a URI dentro da variavel com o metodo
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // enviando requisicao
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }
}
