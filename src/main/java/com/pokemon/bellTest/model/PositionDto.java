package com.pokemon.bellTest.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PositionDto {
    private int CoordinateX;
    private int CoordinateY;
}
