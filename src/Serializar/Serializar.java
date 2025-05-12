package Serializar;

import Json.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializar {
    public static void main(String[] args) {
        ej3();
    }
    //Ejercicio 12: Serializar un objeto
    //Escribe un programa que serialice un objeto Persona (con nombre, edad) a un archivo persona.ser utilizando ObjectOutputStream.
    public static void ej1(){
        Persona persona = new Persona("asd","asd",12);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Serializar\\Archivos\\persona.ser"));
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Serializar\\Archivos\\persona.ser"));
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
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\Serializar\\Archivos\\personas.ser"));
            oos.writeObject(personas);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
