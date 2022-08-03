package com.pokemon.bellTest.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {
    @Getter
    @Setter
    @Value("classpath:json/pokemons_50.json")
    private Resource pokemonfile50;
}
