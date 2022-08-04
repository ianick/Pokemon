package com.pokemon.bellTest.service;

import com.pokemon.bellTest.game.Game;
import com.pokemon.bellTest.game.GameStatus;
import com.pokemon.bellTest.game.Player;
import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.model.PositionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;


public class GameServiceTest {
    @Autowired
    private GameService gameService;

    @BeforeEach
    public void setup(){
        gameService = Mockito.mock(GameService.class);

    }

    @Test
    public void testCreateGame() throws IOException {

        Game game = Game.builder()
                .player1(Player
                        .builder()
                        .name("Antonio")
                        .build())
                .gameId("123456789")
                .winner(PokemonDto.builder()
                        .name("Iverton")
                        .url("/pokemos")
                        .position(PositionDto
                                .builder()
                                .CoordinateX(12)
                                .CoordinateY(12)
                                .build()
                        ).build())
                .status(GameStatus.IN_PROGRESS)
                .build();
        Player player = Mockito.mock(Player.class);

        Game game1= Mockito.mock(Game.class);

        Mockito.when(gameService.newGame(player)).thenReturn(game1);

        gameService.newGame(player);

        Mockito.verify(gameService, Mockito.times(1)).newGame(any(Player.class));

    }
}
