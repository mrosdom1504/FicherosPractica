package SerializarYJsonCombinados;

import Json.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    //🔁 Ejercicios Combinados:
    //Ejercicio 30: Leer CSV → Convertir a objetos → Guardar en JSON
    //Lee un archivo empleados.csv, conviértelo en una lista de objetos Empleado y guárdalo en empleados.json.
    public static void ej2(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            BufferedReader br = new BufferedReader(new FileReader(""));
            String linea;
            List<Empleado> empleados = new ArrayList<>();
            boolean esPrimeraLinea = true;
            while((linea = br.readLine()) != null){
                if (esPrimeraLinea) {
                    esPrimeraLinea = false; // saltamos encabezado
                    continue;
                }
                String[] partes = linea.split(",");

                if (partes.length == 3) {
                    String nombre = partes[0];
                    int edad = Integer.parseInt(partes[1]);
                    String departamento = partes[2];

                    empleados.add(new Empleado(nombre, edad, departamento));
                }
            }
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("src/Ficheros/archivos/empleados.json"), empleados);
            System.out.println("Empleados guardados en empleados.json");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Ejercicio 31: Leer JSON → Modificar → Serializar
    //Lee un JSON, cambia uno o más atributos de los objetos y luego serialízalos como objetos Java a un archivo .ser.
    //
    //Ejercicio 32: Leer JSON → Mostrar con formato bonito en consola
    //Lee un archivo JSON y muéstralo por consola con sangrías usando Jackson (mapper.enable(SerializationFeature.INDENT_OUTPUT)).
}
