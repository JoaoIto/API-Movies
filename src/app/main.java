package src.app;

import src.classes.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        System.out.println("Aplicação geração de filmes IMDB!");

        String urlAPI = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        URI httpAdress = URI.create(urlAPI);
        var client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(httpAdress).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Exibindo na tela o corpo da requisição;
        // -> System.out.println(body);

        //Listagem de filmes:
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);

        System.out.println("A lista de filmes tem tamanho: \n" + moviesList.size() + "\n Acompanhe a lista");
        for (Map<String, String> movies: moviesList) {
            System.out.println("Este é o filme: ");
            System.out.println(movies.get("title"));
            System.out.println(movies.get("imDbRating"));
            System.out.println();
        }
    }
}
