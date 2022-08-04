package com.pokemon.bellTest.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

@ToString
@Getter
@Setter
public class PokemonResponse {
    @SerializedName("results")
    private Set<PokemonDto> results;



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

        public PokemonDetails getPokemonDetails(String fullURL) throws IOException {

            URL url = new URL(fullURL);

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
    @PostConstruct
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
