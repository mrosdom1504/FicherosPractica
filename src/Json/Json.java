package Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Json {
    public static void main(String[] args) {
        ej2();
    }

    //Ejercicio 7: Serializar un objeto a JSON
    //Crea un programa que convierta un objeto de la clase Persona (que tenga nombre, edad, y direccion) en un archivo persona.json utilizando Jackson o Gson.
    public static void ej1() {
        ObjectMapper mapper = new ObjectMapper();
        List<Persona> personas = new ArrayList<>();
        Persona persona = new Persona("ajds", "adas", 12);
        Persona persona1 = new Persona("ajasdds", "adas", 12);
        Persona persona2 = new Persona("ajsadsds", "adas", 12);
        personas.add(persona);
        personas.add(persona1);
        personas.add(persona2);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Json\\persona.json"), personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Ejercicio 8: Deserializar un JSON a un objeto
    //Escribe un programa que lea el archivo persona.json y lo convierta en un objeto Persona usando Jackson o Gson. Luego, muestra el contenido del objeto en la consola.
    public static void ej2(){
        ObjectMapper mapper = new ObjectMapper();
        Persona persona1 = new Persona("asdf","sad",12);
        try{
            List<Persona> personas = mapper.readValue(new File("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Json\\persona.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Persona.class));
            for(Persona persona : personas){
                System.out.println(persona);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Ejercicio 11: Modificar un JSON
    //Crea un programa que lea el archivo personas.json, modifique el atributo edad de una persona específica y guarde los cambios de nuevo en el archivo.
    public static void ej3(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File archivo = new File("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Json\\persona.json");

        try {
            // Leer JSON y convertir a lista de personas
            List<Persona> personas = mapper.readValue(archivo, new TypeReference<List<Persona>>() {});

            // Buscar por nombre y modificar edad (por ejemplo: cambiar edad de "Ana")
            for (Persona persona : personas) {
                if (persona.getNombre().equalsIgnoreCase("Ana")) {
                    persona.setEdad(35);
                }
            }

            // Escribir lista modificada al mismo archivo
            mapper.writeValue(archivo, personas);
            System.out.println("Archivo modificado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
