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

---

## Exibição no console:

Perceba que, na visualização de filmes, temos diversos, e ainda sim
suas informações estão sendo colocadas de forma "porca" e mais feia! Vamos
resolver este problema dentro do código na exibição das informações em negrito
e ainda uma forma inteligente de fazer com que o código exiba emojis de rating
para cada filme!

````java
            // Esibe a nota do filme;
            System.out.println(movies.get("imDbRating"));
            // Captura o número do rating;
            double numberStars = Double.parseDouble(movies.get("imDbRating"));
            // transforma em (int) para exibição do rating em emojis inteiros;
            int rating = (int) numberStars;

            System.out.println();

            // for(), código de repetição para exibição dos emojis;
                    // referente ao inteiro de rating
            for(int i = 0; i <= rating; i++){
                System.out.print("💛");
            }
            System.out.println();
        }
````

---