package com.roberto.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Pokemon implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("id_tipus")
    private List<Integer> id_tipus;
    @JsonProperty("descripcio")
    private String descripcio;
    @JsonProperty("foto")
    private String foto;

    public int getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getNom() {
        return nom;
    }

    public List<Integer> getId_tipus() {
        return id_tipus;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", id_tipus=" + id_tipus +
                ", descripcio='" + descripcio + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
