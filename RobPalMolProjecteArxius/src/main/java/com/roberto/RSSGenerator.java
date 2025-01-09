package com.roberto;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.roberto.POJO.Pokemon;
import com.roberto.POJO.Data;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.List;

public class RSSGenerator {

    public static void generarRSS(Data data) throws Exception {
        //Las clases DocumentBuilderFactory y DocumentBuilder permiten la generación de un documento XML vacío almacenándolo en memoria.
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element rootElement = doc.createElement("rss");
        rootElement.setAttribute("version", "2.0");
        doc.appendChild(rootElement);


        Element channel = doc.createElement("pokemons");
        rootElement.appendChild(channel);


        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode("informacióDelPokemon"));
        channel.appendChild(title);


        for (Pokemon pokemon : data.getPokemons()) {
            Element item = doc.createElement("pokemon");
            channel.appendChild(item);

            Element itemId = doc.createElement("id");
            itemId.appendChild(doc.createTextNode(String.valueOf(pokemon.getId())));
            item.appendChild(itemId);

            Element itemNom = doc.createElement("nom");
            itemNom.appendChild(doc.createTextNode(pokemon.getNom()));
            item.appendChild(itemNom);

            Element itemIdTipus = doc.createElement("id_tipus");
            itemIdTipus.appendChild(doc.createTextNode(String.valueOf(pokemon.getId_tipus())));
            item.appendChild(itemIdTipus);

            Element itemDescripcio = doc.createElement("descripcio");
            itemDescripcio.appendChild(doc.createTextNode(pokemon.getDescripcio()));
            item.appendChild(itemDescripcio);
        }


        FileWriter writer = new FileWriter("src/main/resources/web/pokemon_rss.xml");
        writer.write(docToString(doc));
        writer.close();
    }

    //clase sacada de internet
    public static String docToString(Document doc) throws Exception {
        //capturar contenido contenido en forma de texto
        StringWriter writer = new StringWriter();
        //procesar el contenido en un documento xml
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        //embellecedor de linea (espacios para formatar en xml correctamente y que no sea solo 1 linea)
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");

        //indica donde tiene que ir el resultado
        StreamResult result = new StreamResult(writer);
        //Proporciona el documento xml de entrada
        DOMSource source = new DOMSource(doc);
        //escribe el contenido xml
        transformer.transform(source, result);
        return writer.toString();
    }
}
