package com.pokemon.bellTest.game;

import com.pokemon.bellTest.model.Results;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "https://pokeapi.co/api/v2")
public interface TestGame {

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Results testApi(@RequestParam(value = "limit") Long limit, @RequestParam(value = "offset") long offset);


}
