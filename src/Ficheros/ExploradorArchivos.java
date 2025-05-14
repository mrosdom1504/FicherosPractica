package Ficheros;

import java.io.*;

//Ejercicio 8. El centro de la Tierra
//Crea una clase llamada ExploradorArchivos que realice las siguientes operaciones:
//
//Listar todos los archivos y carpetas contenidos en la ruta "/resources/explorador/"
//Hacer 10 copias de un archivo, por ejemplo copiar.txt (debes crearlo) y que las copias se encuentren en la carpeta
//Crear una estructura de subdirectorios dentro de "/resources/explorador/" que tenga la siguiente forma:
//"/resources/explorador/volcan/descenso/aprobar/programacion/ y dentro de ella debe contener un archivo llamado "centroTierra.txt"
public class ExploradorArchivos {
    public static File[] listarFichero() {
        File archivo = new File("resources/explorador");
        File[] archivos = archivo.listFiles();
        for (File f : archivos){
            System.out.println(f);
        }
        return archivo.listFiles();
    }

    public static void copiarArchivo() throws IOException {
        for (int i = 1; i <= 10; i++) {
            String copia = "resources/explorador/copiar";
            BufferedReader br = new BufferedReader(new FileReader(copia + ".txt"));
            String linea;
            BufferedWriter bw = new BufferedWriter(new FileWriter(copia + i + ".txt"));
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            br.close();
        }

    }

    public static void estructuraDirectorios() throws IOException {
        File archivo = new File("resources/explorador/volcan/descenso/aprobar/programacion");
        File archivo1 = new File("resources/explorador/volcan/descenso/aprobar/programacion/centroTierra.txt");
        archivo.mkdirs();
        archivo1.createNewFile();
    }
}
