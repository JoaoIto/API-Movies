# API de filmes [IMDB](https://www.imdb.com/chart/top/)

Aplicação feita na ***Imersão Alura***, para a buscagem de rotas para uma API de filmes, desenvolvida em Java! Confira o código.

## Sobre

Basicamente se abre um código de ***`request(), send(), response()`*** para a busca dos títulos
de filmes do IMDB, sua capa, póster, chamada para o chamado ***Alura Stickers***!

## Código de ***`request(), send(), response()`***:

````java
        String urlAPI = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        URI httpAdress = URI.create(urlAPI);
        var client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(httpAdress).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);
    }
}

````