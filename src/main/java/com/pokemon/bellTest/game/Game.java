package com.pokemon.bellTest.game;

import com.pokemon.bellTest.model.PokemonDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Game {
    private String gameId;
    private Player player1;
    private Player player2;
    private GameStatus status;
    private PokemonDto winner;
}
