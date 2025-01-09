package com.roberto;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//clase creada amb ajuda de internet
//https://www.youtube.com/watch?v=mueyzKT3Tdg
public class SchemaValidate {

    void validate() throws FileNotFoundException {

        //JSON SCHEMA
        File schema = new File("src/main/resources/json/schema.json");

        //Leer y analizar el contenido del File
        JSONTokener schemaData = new JSONTokener(new FileInputStream(schema));
        //Se convierte en JSON Object
        JSONObject jsonSchema = new JSONObject(schemaData);

        //JSON DATA
        File jsonData = new File("src/main/resources/json/Pokemon.json");

        //Leer y analizar el contenido del File
        JSONTokener jsonDataFile = new JSONTokener(new FileInputStream(jsonData));
        //Se convierte en JSON Object
        JSONObject jsonObject = new JSONObject(jsonDataFile);

        //VALIDACIÓ
        //genera un objeto schema
        Schema validacio = SchemaLoader.load(jsonSchema);
        //valida los datos del json con el schema proporcionado
        try {
            validacio.validate(jsonObject);
            System.out.println("JSON válido.");
        } catch (ValidationException e) {
            System.err.println("Error en la validación del JSON: " + e.getMessage());
        }

    }
}
