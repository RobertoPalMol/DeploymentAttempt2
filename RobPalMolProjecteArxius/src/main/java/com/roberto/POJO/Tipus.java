package com.roberto.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Tipus implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("debilitats")
    private ArrayList<String> debilitats;
    @JsonProperty("avantatges")
    private ArrayList<String> avantatges;
    @JsonProperty("foto")
    private String foto;

    public int getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public ArrayList<String> getDebilitats() {
        return debilitats;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<String> getAvantatges() {
        return avantatges;
    }


    @Override
    public String toString() {
        return "Tipus{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", debilitats=" + debilitats +
                ", avantatges=" + avantatges +
                ", foto='" + foto + '\'' +
                '}';
    }
}
