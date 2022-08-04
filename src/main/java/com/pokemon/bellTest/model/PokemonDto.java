package com.pokemon.bellTest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokemon.bellTest.Client.PokemonDetails;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PokemonDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("position")
    private PositionDto position;
    @JsonProperty("pokemonDetails")
    private PokemonDetails pokemonDetails;

}
