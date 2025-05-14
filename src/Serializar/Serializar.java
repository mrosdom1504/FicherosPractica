package Serializar;

import Json.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serializar {
    public static void main(String[] args) {
        ej7();
    }
    //Ejercicio 12: Serializar un objeto
    //Escribe un programa que serialice un objeto Persona (con nombre, edad) a un archivo persona.ser utilizando ObjectOutputStream.
    public static void ej1(){
        Persona persona = new Persona("asd","asd",12);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Serializar\\Crud.Archivos\\persona.ser"));
            oos.writeObject(persona);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Ejercicio 13: Deserializar un objeto
    //Desarrolla un programa que lea el archivo persona.ser y deserialice el objeto Persona. Luego, muestra el contenido del objeto en la consola.
    public static void ej2(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Serializar\\Crud.Archivos\\persona.ser"));
            System.out.println(ois.readObject());
            ois.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //Ejercicio 14: Serializar una lista de objetos
    //Escribe un programa que serialice una lista de objetos Persona y la guarde en un archivo personas.ser.
    public static void ej3(){
        List<Persona> personas = new ArrayList<>();
        Persona persona = new Persona("asd","adsf",21);
        Persona persona1 = new Persona("asd","adsf",21);
        Persona persona2 = new Persona("asd","adsf",21);
        personas.add(persona);
        personas.add(persona1);
        personas.add(persona2);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Serializar\\Crud.Archivos\\personas.ser"));
            oos.writeObject(personas);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Ejercicio 27: Serializar un mapa de productos
    //Crea una clase Producto con nombre y precio. Usa un Map<String, Producto> y serialízalo a un archivo productos.ser.
    public static void ej4(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializar/Crud.Archivos/productos.ser"));
            Map<String,Producto> productos = new HashMap<>();
            productos.put("Agua",new Producto("asdas",123.123));
            productos.put("Agrdfua",new Producto("asdfsdfas",122133.123));
            productos.put("Ag234ua",new Producto("asdsddas",12453.123));
            oos.writeObject(productos);
            oos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Ejercicio 28: Serializar múltiples objetos con writeObject
    //Serializa tres objetos de distintas clases (Persona, Producto, Libro) en un solo archivo. Luego deserialízalos.
    public static void ej5(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializar/Crud.Archivos/DistintasClases.ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializar/Crud.Archivos/DistintasClases.ser"));
            Persona persona1 = new Persona("asd", "sad", 21);
            Persona persona2 = new Persona("asd", "sad", 21);
            Persona persona3 = new Persona("asd", "sad", 21);
            Producto producto1 = new Producto("asd", 213);
            oos.writeObject(persona1);
            oos.writeObject(persona2);
            oos.writeObject(persona3);
            oos.writeObject(producto1);
            oos.close();
            while (true) {
                Object obj = ois.readObject();
                System.out.println("leido=" + obj);
            }
        }catch (EOFException e){
            System.out.println("Fin del Archivo");
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //Serializar y deserializar imagen
    public static void ej6() {
        File imagen = new File("src/Ficheros/archivos/img_1.png");
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Ficheros/archivos/img_1.ser"));
            byte[] bytes = Files.readAllBytes(imagen.toPath());
            oos.writeObject(bytes);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Ficheros/archivos/img_1.ser"));
            byte[] image = (byte[]) ois.readObject();
            Files.write(imagen.toPath(), image);
            ois.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //serializar kibab
    public static void ej7(){
        try{
            Kibab kibab = new Kibab("Carne de cerdo","Salsa blanca");
            Kibab kibab1 = new Kibab("Carne dasdas cerdo","Salsa asdblanca");
            List<Kibab> kibabs = new ArrayList<>();
            kibabs.add(kibab);
            kibabs.add(kibab1);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializar/Archivos/kibab.ser"));
            oos.writeObject(kibabs);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializar/Archivos/kibab.ser"));
            System.out.println(ois.readObject());
            ois.close();

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            mapper.writeValue(new File("src/Serializar/Archivos/kibab.json"), kibabs);
            List<Kibab> listaKibabs = mapper.readValue(new File("src/Serializar/Archivos/kibab.json"), mapper.getTypeFactory().constructCollectionType(List.class, Kibab.class));
            System.out.println(listaKibabs);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
