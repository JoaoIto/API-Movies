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

---