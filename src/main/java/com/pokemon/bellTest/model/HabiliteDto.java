package com.pokemon.bellTest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class HabiliteDto {
    private String name;
    private String url;
    private Boolean is_hidden;
}
