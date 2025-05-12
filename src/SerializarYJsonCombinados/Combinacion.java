package SerializarYJsonCombinados;

import Json.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;

public class Combinacion {
    public static void main(String[] args) {
        ej1();
    }
    //Ejercicio 18: Leer un archivo JSON y serializar a un objeto
    //Desarrolla un programa que lea un archivo JSON llamado persona.json, deserialice el contenido en un objeto Persona, y luego serialice ese objeto a un archivo persona_serializada.ser.
    public static void ej1(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Leer el archivo JSON y convertirlo en objeto Persona
            Persona persona = mapper.readValue(
                    new File("src/SerializarYJsonCombinados/Archivos/persona.json"),
                    Persona.class);
            System.out.println("Leído desde JSON: " + persona);

            // Serializar a archivo .ser
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("src/SerializarYJsonCombinados/Archivos/persona_serializada.ser")
            );
            oos.writeObject(persona);
            oos.close();

            System.out.println("Objeto serializado correctamente en persona_serializada.ser");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
