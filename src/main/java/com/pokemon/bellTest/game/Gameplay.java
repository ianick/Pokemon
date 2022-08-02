package com.pokemon.bellTest.game;

import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.model.PositionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gameplay {
    private PokemonDto pokemon;
    private PositionDto position;
    private String gameId;
}
