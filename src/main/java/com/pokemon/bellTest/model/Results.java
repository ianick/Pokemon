package com.pokemon.bellTest.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Set;

@ToString
public class Results {
    @SerializedName("results")
    private Set<PokemonDto> results;

    public Results(Set<PokemonDto> results) {
        this.results = results;
    }

    public Set<PokemonDto> getResults() {
        return results;
    }

    public void setResults(Set<PokemonDto> results) {
        this.results = results;
    }
}
