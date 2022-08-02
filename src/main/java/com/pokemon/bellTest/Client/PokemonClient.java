package com.pokemon.bellTest.Client;

import com.pokemon.bellTest.model.ListOfPokemonDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PokemonClient {
    @Value("${myrest.url}")
    private  String URL_BASE;
    WebClient webClient;
    public PokemonClient() {
        this.webClient = WebClient.create();
    }

    public Set<ListOfPokemonDto> getliPokemonDto(Set<ListOfPokemonDto> listOfPokemonDtos){
        System.out.println(listOfPokemonDtos.size() + " O meu Tamnaho e hgdi9wgbiodfgow");
        return (Set<ListOfPokemonDto>) Optional.ofNullable(listOfPokemonDtos)
                    .stream()
                    .map(listOfPokemonDtos1 -> listOfPokemonDtos1
                            .stream()
                            .flatMap(listOfPokemonDto -> listOfPokemonDto.getPokemonDtoList()
                                    .stream()
                                    .map(pokemonDto -> pokemonDto.getUrl())
                                    .map(s -> webClient.get()
                                            .uri(s)
                                            .accept(MediaType.APPLICATION_JSON)
                                            .retrieve()
                                            .onStatus(HttpStatus::is4xxClientError,
                                                    error -> Mono.error(new RuntimeException("check the parameters")))
                                                    .bodyToFlux(ListOfPokemonDto.class))
                                    .map(pokemonDtoFlux ->(ListOfPokemonDto) pokemonDtoFlux.collectList().subscribe()))
                            .collect(Collectors.toSet()));


    }
}