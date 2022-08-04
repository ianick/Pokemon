package com.pokemon.bellTest.Client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.bellTest.model.PokemonDto;
import com.pokemon.bellTest.model.Results;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonResponse {
    private Results results;

    public Set<PokemonDto> getlistPokemonDtoWithPokemonDetails(Set<PokemonDto> listOfPokemonDtos) throws IOException {

            listOfPokemonDtos.forEach(pokemonDto -> {

                PokemonDetails pokemonDetails = null;
                try {
                    pokemonDetails = getPokemonDetails(pokemonDto.getUrl());
                } catch (IOException e) {
                    System.out.println("Erro ao obter detalhe do pokemon");
                }
                pokemonDto.setPokemonDetails(pokemonDetails);

            });

            return listOfPokemonDtos;

        }

        public static PokemonDetails getPokemonDetails(String fullURL) throws IOException {

            URL url = new URL(fullURL);

            // Abrir a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // definir pedido
            connection.setRequestProperty("accept", "application/json");
            // definir user agent para evitar 403 - Proíbido
            connection.addRequestProperty("User-Agent", "chrome");

            // construir o pedido
            InputStream responseStream = connection.getInputStream();

            // Converter o resultado
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(responseStream, PokemonDetails.class);


        }

        public  PokemonResponse getlistPokemonDto(String baseUrl) throws IOException {
            URL url = new URL(baseUrl);

            // Abrir a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // definir pedido
            connection.setRequestProperty("accept", "application/json");
            // definir user agent para evitar 403 - Proíbido
            connection.addRequestProperty("User-Agent", "chrome");

            // construir o pedido
            InputStream responseStream = connection.getInputStream();

// Converter o resultado
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            PokemonResponse pokemon = mapper.readValue(responseStream, PokemonResponse.class);

            return pokemon;

        }



}
