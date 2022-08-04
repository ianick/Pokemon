package com.pokemon.bellTest.pokemon;

import com.pokemon.bellTest.model.PokemonDetails;
import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.model.PokemonResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonsResponseTest {



    @Test
    public void getlistPokemonDtoWithPokemonDetailsTest() throws IOException {

        PokemonDetails pokemonDetails =mock(PokemonDetails.class);
        PokemonResponse pokemonResponse= mock(PokemonResponse.class);
        PokemonDto pokemonDto1= mock(PokemonDto.class);
        PokemonDto pokemonDto2= mock(PokemonDto.class);
        Set<PokemonDto> list = Set.of(pokemonDto1,pokemonDto2);
        Set<PokemonDto> list1 = Set.of(pokemonDto1,pokemonDto2);

        when(pokemonDto1.getPokemonDetails()).thenReturn(pokemonDetails);
        when(pokemonResponse.getlistPokemonDtoWithPokemonDetails(list)).thenReturn(list1);


    }
@Test
    public void getPokemonDetails() throws IOException {

        PokemonDetails pokemonDetails =mock(PokemonDetails.class);
        PokemonResponse pokemonResponse= mock(PokemonResponse.class);
        PokemonDto pokemonDto1= mock(PokemonDto.class);
        PokemonDto pokemonDto2= mock(PokemonDto.class);
        Set<PokemonDto> list = Set.of(pokemonDto1,pokemonDto2);
        Set<PokemonDto> list1 = Set.of(pokemonDto1,pokemonDto2);

        when(pokemonDto1.getPokemonDetails()).thenReturn(pokemonDetails);
        when(pokemonResponse.getlistPokemonDtoWithPokemonDetails(list)).thenReturn(list1);


    }



}
