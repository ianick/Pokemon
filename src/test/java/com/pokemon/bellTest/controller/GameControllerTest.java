package com.pokemon.bellTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.bellTest.BellTestApplicationTests;
import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.GameStatus;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class GameControllerTest extends BellTestApplicationTests {

    @MockBean
    private GameService gameService;
    @Autowired
    private MockMvc mockMvc;

    private static final String PATH = "https://pokeapi.co/api/v2/pokemon";


    @Test
    @DisplayName("Star new game test")
    public void initGameTest() throws Exception {
        Player playerdto = new Player();
            playerdto.setName("Santos");

        String json = new ObjectMapper().writeValueAsString(playerdto);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH+"/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        Mockito.when(gameService.newGame(ArgumentMatchers.any())).thenReturn(null);
    }

    @Test
    @DisplayName("test in the Beginning connect")
    public void connectToTheGameTest() throws Exception {
        Player playerdto = new Player();
        playerdto.setName("Santos");

        String json = new ObjectMapper().writeValueAsString(playerdto);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH+"/start")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        Mockito.when(gameService.connectToGame(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(null);
    }
    @Test
    @DisplayName("test game play")
    public void gamePlayTest() throws Exception {
        Game game = Game.builder()
                .gameId("12345678")
                .status(GameStatus.IN_PROGRESS)
                .winner(PokemonDto
                        .builder()
                        .url("/pokemon")
                        .name("Santos").build())
                .player1(new Player())
                .build();

        String json = new ObjectMapper().writeValueAsString(game);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH+"/start")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        Mockito.when(gameService.gamePlay(ArgumentMatchers.any())).thenReturn(null);
    }

}
