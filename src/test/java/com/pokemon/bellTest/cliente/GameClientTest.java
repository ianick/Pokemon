package com.pokemon.bellTest.cliente;

import com.pokemon.bellTest.game.GameAPI;
import feign.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public class GameClientTest {

    private static final String BASE_URL="https://pokeapi.co/api/v2";
    private static final String RESPONSE_GETS= "[{\"count\":1154,\"next\":null,\"previous\":null,\"results\":[{\"name\":\"bulbasaur\",\"url\":\"https://pokeapi.co/api/v2/pokemon/1/\"},{\"name\":\"ivysaur\",\"url\":\"https://pokeapi.co/api/v2/pokemon/2/\"},{\"name\":\"venusaur\",\"url\":\"https://pokeapi.co/api/v2/pokemon/3/\"},{\"name\":\"charmander\",\"url\":\"https://pokeapi.co/api/v2/pokemon/4/\"},{\"name\":\"charmeleon\",\"url\":\"https://pokeapi.co/api/v2/pokemon/5/\"},{\"name\":\"charizard\",\"url\":\"https://pokeapi.co/api/v2/pokemon/6/\"},{\"name\":\"squirtle\",\"url\":\"https://pokeapi.co/api/v2/pokemon/7/\"},{\"name\":\"wartortle\",\"url\":\"https://pokeapi.co/api/v2/pokemon/8/\"},{\"name\":\"blastoise\",\"url\":\"https://pokeapi.co/api/v2/pokemon/9/\"},{\"name\":\"caterpie\",\"url\":\"https://pokeapi.co/api/v2/pokemon/10/\"}]";

    @Mock
    private Response client;

    private final static long limit=50;
    private final static long offset=0;
    @Autowired
    private static  WebTestClient webTestClient;
    private GameAPI gameAPI;

    @BeforeAll
    public static void setup() {
        webTestClient = (WebTestClient) WebTestClient.bindToServer()
                .baseUrl(BASE_URL)
                .build();
    }
    @Test
    public void getPokemon(){

        webTestClient.get().uri("/pokemon",limit, offset)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();

    }

}
