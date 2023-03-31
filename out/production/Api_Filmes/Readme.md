# API de filmes [IMDB](https://www.imdb.com/chart/top/)

Vamos construir uma aplicação do zero da ***Imersão Alura*** para consumir a API do IMDb e exibir os filmes mais populares, destacando seus pôsteres e visualizando sua classificação... Tudo isso sem usar nenhuma biblioteca externa!

## Sobre

Basicamente se abre um código de ***`request(), send(), response()`*** para a busca dos títulos
de filmes do IMDB, sua capa, póster, chamada para o chamado ***Alura Stickers***!

## Código de ***`request(), send(), response()`***:

````java
        // Salvando variável para locação da API web;
        String urlAPI = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        // Colocando em uma variável de API;
        URI httpAdress = URI.create(urlAPI);
        // Colocando em métodop de HTTPClient;
        var client = HttpClient.newHttpClient();
        
        // E aqui o corpo da requisição para a API;
        HttpRequest request = HttpRequest.newBuilder(httpAdress).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);
    }
}

````

## Código para expressão regular:

Para melhor resposta da requisição do objeto da API dentro do console
para ser melhor exibido, foi construído um objeto, com as expressões regulares,
chamada por um código de biblioteca do Github, [código de expressão regular](https://gist.github.com/alexandreaquiles/cf337d3bcb59dd790ed2b08a0a4db7a3).

````java
package src.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class JsonParser {

    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json){
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }

        return dados;
    }
}

````

Note que este código serve para ser filtrada dentro de uma lista de repetição
as informações que realmente são necessárias para a exibição, aquela filtragem nas infos.

---

## Código de repetição com filtragem: 

````java
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
````