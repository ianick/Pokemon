package com.pokemon.bellTest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PokemonDto {
    private String name;
    private String url;
    private String height;
    private String weight;
    private PositionDto position;
}
