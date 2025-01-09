package com.roberto.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

    @JsonProperty("tipus_pokemon")
    private List<Tipus> tipus_pokemon;
    @JsonProperty("pokemons")
    private List<Pokemon> pokemons;

    public List<Tipus> getTipus_pokemon() {
        return tipus_pokemon;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return "Data{" +
                "tipus_pokemon=" + tipus_pokemon +
                ", pokemons=" + pokemons +
                '}';
    }
}
