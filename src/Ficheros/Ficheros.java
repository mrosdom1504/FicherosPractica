package Ficheros;

import java.io.*;

public class Ficheros {
    public static void main(String[] args) {
        ej4();
    }

    //Ejercicio 1: Leer un archivo de texto
    public static void ej1() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\archivos\\texto.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejercicio 2: Escribir en un archivo de texto
    //Crea un programa que escriba el texto "Hola Mundo" en un archivo llamado saludo.txt.
    public static void ej2() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\archivos\\saludo.txt"));
            bw.write("Hola Mundo");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejercicio 3: Contar líneas en un archivo
    //Desarrolla un programa que cuente cuántas líneas tiene el archivo entrada.txt y lo imprima en la consola.
    public static void ej3() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\archivos\\entrada.txt"));
            String linea;
            int contador = 1;
            while ((linea = br.readLine()) != null) {
                contador++;
            }
            br.close();
            System.out.println(contador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejercicio 4: Copiar el contenido de un archivo a otro
    //Escribe un programa que copie el contenido de origen.txt a destino.txt, manteniendo el mismo formato.
    public static void ej4() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\archivos\\origen.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\usuario\\IdeaProjects\\FicherosPractica\\src\\archivos\\destino.txt"));
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (!primeraLinea) {
                    bw.newLine(); // Escribir salto de línea solo si no es la primera línea
                }
                bw.write(linea);
                primeraLinea = false; // Después de la primera línea, esta será false
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//Ejercicio 6: Eliminar un archivo
//Desarrolla un programa que elimine un archivo llamado archivo_a_eliminar.txt de tu sistema de Ficheros.archivos.

}