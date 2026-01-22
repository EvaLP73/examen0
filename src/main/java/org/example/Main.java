package org.example;

import org.example.repositorios.CicloRepositorio;
import org.example.repositorios.DirectorRepositorio;
import org.example.repositorios.InstitutoRepositorio;
import org.hibernate.Session;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Test");

        Session session = null;

        try {
            session = HibernateUtil.get().openSession();
            Main.menu(session);

        } finally {
            if (session!=null) {
                session.close();
                System.out.println("Finalizando la conexion a MySQL");
            }
        }
        sc.close();
    }

    public static void menu(Session session) {
        final String mensaje = "1. Crear instituto\n" +
                "2. Eliminar instituto\n" +
                "3. Crear ciclo\n" +
                "4. Eliminar ciclo\n" +
                "5. Modificar telefono instituto\n" +
                "6. Asignar director al IES\n" +
                "7. Asignar Ciclo al IES\n" +
                "8. Consulta 1\n" +
                "9. Consulta 2\n" +
                "10. Consulta 3\n" +
                "11. Salir";
        DirectorRepositorio directorRepo = new DirectorRepositorio(session);
        CicloRepositorio cicloRepo = new CicloRepositorio(session);
        InstitutoRepositorio institutoRepo = new InstitutoRepositorio(session);
        int opcion = -1;
        do {
            opcion = pedirInt(mensaje);
            switch (opcion) {
                case 1:
                    String nombreInstituto = pedirString("Introduce nombre de instituto");
                    String telefono = pedirString("Introduce telefono");
                    int director = pedirInt("Introduce codigo director");
                    institutoRepo.crearInstituto(nombreInstituto, telefono, director);
                    break;
                case 2:
                    int idInstituto = pedirInt("Introduce codigo de instituto");
                    institutoRepo.eliminarInstituto(idInstituto);
                    break;
                case 3:
                    String nombreCiclo = pedirString("Introduce nombre de ciclo");
                    cicloRepo.crearCiclo(nombreCiclo);
                    break;
                case 4:
                    int idCiclo = pedirInt("Introduce codigo de ciclo a eliminar");
                    cicloRepo.eliminarCiclo(idCiclo);
                    break;
                case 5:
                    int codigoInstituto = pedirInt("Introduce codigo instituto");
                    String telefonoModificar= pedirString("Introduce telefono");
                    institutoRepo.modificarTelefono(codigoInstituto, telefonoModificar);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Introduce numeros de 1 al 11");
            }
        } while (opcion != 11);
    }
    //Función de lectura de un String:
    public static String pedirString(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }
    //Función de lectura de un entero:
    public static int pedirInt(String mensaje){
        while(true){
            try{
                System.out.println(mensaje);
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            }catch (InputMismatchException e){
                System.out.println("Eroor, no letras, solo numeros"+ e.getMessage());
            }
        }
    }

}