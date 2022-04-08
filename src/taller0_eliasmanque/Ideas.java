package taller0_eliasmanque;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ideas {

    // #################################################################################################
    public static void admin() throws FileNotFoundException {
        System.out.println("Bienvenido al menu de ADMIN");
    }

    // #################################################################################################
    public static void usuarioBusqueda(String usuario, String pass) throws FileNotFoundException {
        // Si no encontramos al usuario debemos llevarlo a registrarlo sino ya podremos
        // ingresar al menu
        File file = new File("Jugadores.txt");
        Scanner arch = new Scanner(file);
        // Este while sera de busqueda
        Boolean encontrado = false;
        while (arch.hasNext()) {
            String[] partes = arch.next().split(",");
            String user = partes[0], contraseña = partes[1];
            // 4 posibles causas
            // Usuario encontrado y Contraseña coinciden
            if (user.equals(usuario)) {
                System.out.println("");
                System.out.println("Usuario encontrado");
                System.out.println("");
                encontrado = true;
                if (contraseña.equals(pass)) {
                    System.out.println("Acceso correcto");
                    menuUsuario();
                    break;
                } else {
                    System.out.println("[Contraseña Incorrecta!!]");
                    System.out.println("");
                    System.out.println("########################################################");
                    break;
                }
                // Usuario encontrado y Contraseña no coincide
            }
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado");
            Registro();
        }
        arch.close();
    }

    // #################################################################################################
    public static void Registro() throws FileNotFoundException {
        System.out.print("Desea registrarce? SI/NO ===> ");
        Scanner lectura = new Scanner(System.in);
        String confir = lectura.next();
        confir = confir.toUpperCase();
        while (!(confir.equals("SI")) && !(confir.equals("NO"))) {
            System.out.println("Ingrese un valor valido");
            System.out.print("Desea registrarce? SI/NO ===> ");
            confir = lectura.next();
            System.out.println("");
            confir = confir.toUpperCase();
        }
        if (confir.equals("SI")) {
            System.out.println("WENARDOOO");
            System.out.println("tabien");
            lectura.close();
        }
    }

    // #################################################################################################
    public static void menuUsuario() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner leer = new Scanner(System.in);

        // Variables a Usar
        String user, password;

        // Inicio de programa
        System.out.println("########################################################");
        System.out.print("Desea iniciar el programa? SI/NO  ===> ");
        String confir = leer.nextLine();
        System.out.println("########################################################");
        confir = confir.toUpperCase();

        while (!(confir.equals("SI")) && !(confir.equals("NO"))) {
            System.out.println("Ingrese un valor valido");
            System.out.println("Desea iniciar el programa? SI/NO  ===> ");
            confir = leer.next();
            System.out.println("");
            System.out.println("########################################################");
            confir = confir.toUpperCase();
        }
        if (confir.equals("SI")) {
            while (confir.equals("SI")) {
                System.out.print("Ingrese su nombre de Usuario ===> ");
                user = leer.next();
                System.out.print("Ingrese su Contraseña ===> ");
                password = leer.next();
                // Division entre Usuario, Admin y Registro
                // ADMIN
                if (user.equals("Admin") && password.equals("Patata19")) {
                    admin();
                }
                // USUARIO
                else {
                    usuarioBusqueda(user, password);
                }
                System.out.println("########################################################");
                System.out.print("Desea intentarno denuevo? SI/NO ");
                confir = leer.next();
                confir = confir.toUpperCase();
            }
        } else {
            System.out.println("Porque no? >:c");
        }
        leer.close();
    }
}