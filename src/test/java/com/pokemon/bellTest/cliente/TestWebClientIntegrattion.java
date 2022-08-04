package com.pokemon.bellTest.cliente;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.pokemon.bellTest.BellTestApplication;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;



@WireMockTest(httpPort = 8180)
@SpringBootTest(classes = BellTestApplication.class)
@TestPropertySource(locations = "classpath:application_test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestWebClientIntegrattion {
/*
    private final static long limit=50;
    private final static  long offset=0;
    @Autowired
    private PokemonClient pokemonClient;
    @Autowired
    private WireMockServers wireMock;
    @Autowired
    private DataMapper dataMapper;

    @Test
    @Order(1)
    @DisplayName("1 - Request all pokemons")
    public void givenRequestUrlPostsThenReturnStatusCode200() {
        wireMock.serverPosts(dataMapper.getPokemonfile50());
        Results result =  pokemonClient.getListPokemon(limit, offset);
    }
*/
}

