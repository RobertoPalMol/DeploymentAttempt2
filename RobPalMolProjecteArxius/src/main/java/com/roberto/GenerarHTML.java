package com.roberto;

import com.roberto.POJO.Pokemon;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import com.roberto.POJO.Data;
import com.roberto.POJO.Tipus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerarHTML {

    private static TemplateEngine templateEngine;

    static {
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix("src/main/resources/templates/");
        templateResolver.setSuffix(".html");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public static void generarIndex(Data data, String siteName, String siteTheme) {
        Context context = new Context();
        context.setVariable("siteName", siteName);
        context.setVariable("siteTheme", siteTheme);
        context.setVariable("tipusPokemon", data.getTipus_pokemon());

        String output = templateEngine.process("index", context);
        try (FileWriter writer = new FileWriter("src/main/resources/web/index.html")) {
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarPerfil(Tipus tipus, List<Pokemon> pokemons) {
        String path = "src/main/resources/web/" + tipus.getNom() + ".html";
        File file = new File(path);
        File parentDir = file.getParentFile();

        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        Context context = new Context();
        context.setVariable("tipus", tipus);
        context.setVariable("pokemons", pokemons);

        String output = templateEngine.process("pokemon-profile", context);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
