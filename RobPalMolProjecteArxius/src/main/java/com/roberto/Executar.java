package com.roberto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roberto.POJO.Data;
import com.roberto.POJO.Pokemon;
import com.roberto.POJO.Tipus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Executar {
    public static void main(String[] args) throws Exception {

        Data data;
        //caché
        try {
            //si trova el archir de cache el carrega
            Data cache = CacheManager.cargarCache();
            data = cache;
        }catch (Exception e){
            //si no el trova el crea
            ObjectMapper mapper = new ObjectMapper();
            File archivo = new File("src/main/resources/json/Pokemon.json");
            data = mapper.readValue(archivo, Data.class);
            CacheManager.guardarCache(data);
        }

        //validació del schema
        SchemaValidate schemaValidate = new SchemaValidate();
        schemaValidate.validate();

        ConfigReader config = new ConfigReader("src/main/resources/json/config.ini");
        String siteName = config.getProperty("name");
        String siteTheme = config.getProperty("description");

        GenerarHTML.generarIndex(data, siteName, siteTheme);

        for (Tipus tipus : data.getTipus_pokemon()) {

            List<Pokemon> pokemonsPorTipo = getPokemonsPorTipo(tipus, data.getPokemons());

            GenerarHTML.generarPerfil(tipus, pokemonsPorTipo);
        }
        RSSGenerator.generarRSS(data);
    }
    private static List<Pokemon> getPokemonsPorTipo(Tipus tipus, List<Pokemon> allPokemons) {
        List<Pokemon> pokemonsPorTipo = new ArrayList<>();
        for (Pokemon pokemon : allPokemons) {
            if (pokemon.getId_tipus().contains(tipus.getId())) {
                pokemonsPorTipo.add(pokemon);
            }
        }
        return pokemonsPorTipo;
    }
}
