package Crud;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean siSigue = true;
        while (siSigue) {
            System.out.println("=====Menu de Personas=====");
            System.out.println("1.Crear Persona");
            System.out.println("2.Eliminar Persona");
            System.out.println("3.Modificar Persona");
            System.out.println("4.Exportar personas a json");
            System.out.println("5.Serializar personas");
            System.out.println("6.Mostrar personas");
            System.out.println("7.Salir");
            System.out.println("Elija una opcion: ");
            int opcion;
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    Persona.crearPersona();
                    break;
                case 2:
                    System.out.println("Nombre de la persona a eliminar: ");
                    String nombrePersona = sc.nextLine();
                    Persona.eliminarPersona(nombrePersona);
                    break;
                case 3:
                    System.out.println("Nombre de la persona a modificar: ");
                    String nombrePersona1 = sc.nextLine();
                    Persona.modificarPersona(nombrePersona1);
                    break;
                case 4:
                    Persona.exportarJson();
                    break;
                case 6:
                    System.out.println(Persona.getListaPersonas());
                    break;
                case 5:
                    Persona.serializar();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    siSigue = false;
                    break;
            }
        }

    }
}
