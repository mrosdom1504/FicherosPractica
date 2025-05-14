package Crud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persona implements Serializable {
    private String nombre;
    private String sexo;
    private int edad;
    private static List<Persona> listaPersonas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public Persona() {
    }

    public Persona(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        listaPersonas.add(this);
    }

    public static void crearPersona() {
        int contador;
        System.out.println("Cuantas personas quiere meter?");
        contador = sc.nextInt();
        while(contador>0){
            contador--;
            System.out.println("Indique el nombre de la persona");
            sc.nextLine();
            String nombre = sc.nextLine();
            System.out.println("Indique el sexo de la persona");
            String sexo = sc.nextLine();
            System.out.println("Indique la edad de la persona");
            int edad = sc.nextInt();
            new Persona(nombre,sexo,edad);
        }
    }

    public static void modificarPersona(String personaBuscada) {
        for (Persona p : listaPersonas) {
            if (p.getNombre().equals(personaBuscada)) {
                System.out.println("Indique el nombre");
                sc.nextLine();
                p.setNombre(sc.nextLine());
                System.out.println("Indique el sexo");
                p.setSexo(sc.nextLine());
                System.out.println("Indique la edad");
                p.setEdad(sc.nextInt());
                System.out.println("Persona modificada con exito");
                return;
            }
        }
        System.out.println("Persona no encontrada");
    }

    public static void eliminarPersona(String personaBuscada) {
        for (Persona p : listaPersonas) {
            if (p.getNombre().equals(personaBuscada)) {
                listaPersonas.remove(p);
                System.out.println("Persona eliminada con exito...");
                return;
            }
        }
        System.out.println("Persona no encontrada");
    }

    public static void exportarJson() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("src/Crud/Archivos/personas.json"), listaPersonas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void serializar(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Crud/Archivos/personas.ser"));
            oos.writeObject(listaPersonas);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public static void setListaPersonas(List<Persona> listaPersonas) {
        Persona.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", edad=" + edad +
                '}';
    }
}
