package Ficheros;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        int opcion;
        boolean siSigue = true;
        while (siSigue) {
            System.out.println("Menu");
            System.out.println("1. Copiar archivos");
            System.out.println("2. Estructura directorios");
            System.out.println("3. Listar ficheros");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    ExploradorArchivos.copiarArchivo();
                    break;
                case 2:
                    ExploradorArchivos.estructuraDirectorios();
                    break;
                case 3:
                    ExploradorArchivos.listarFichero();
                    break;
                case 4:
                    siSigue = false;
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }
}
