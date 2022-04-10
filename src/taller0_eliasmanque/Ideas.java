package taller0_eliasmanque;

import java.io.*;
import java.util.*;


public class Ideas {

    // #################################################################################################//admin//
    public static void admin() throws IOException {
        System.out.println("Bienvenido al menu de ADMIN");

        boolean ingresoMenu = true;
        String ingreso;
        String opcion;
        @SuppressWarnings("resource") // Se usa solo para retirar el aviso del Scanner
        Scanner leer = new Scanner(System.in);

        while (ingresoMenu) {
            // 4 opciones disponibles para el admin
            System.out.print("""
                    Opciones disponibles:

                    A) Eliminar Jugadores
                    B) Agregar Enemigos
                    C) Agregar Hechizos
                    D) Ver las estadisticas de los Jugadores

                    Ingrese su opcion ===>  """);
            opcion = leer.next();
            opcion = opcion.toUpperCase();
            if (opcion.equals("A")) {// Eliminar Jugadores
                System.out.println("a");

            } else if (opcion.equals("B")) {// Agregar Enemigos
                System.out.println("b");

            } else if (opcion.equals("C")) {// Agregar Hechizos
                agregarHechizos();

            } else if (opcion.equals("D")) {// Ver las estadisticas de los Jugadores
                System.out.println(" ");
                System.out.println("Lista de las estadisticas de los jugadores: ");
                estadisticasJugadores();
            }
            System.out.println("Desea salir del menu de admin? SI/NO");
            ingreso = leer.next();
            ingreso = ingreso.toUpperCase();
            if (ingreso.equals("SI")) {
                ingresoMenu = false;
            } else if (ingreso.equals("NO")) {
                ingresoMenu = true;
            } else {
                break;
            }

        }
    }

    // ##########################################################################################//SYS.OUT
    // Agregar Hechizos
    public static void agregarHechizos() throws IOException {
        @SuppressWarnings("resource") // Se usa solo para retirar el aviso del Scanner
        Scanner leer = new Scanner(System.in,"US-ASCII");
        File file = new File("Hechizos.txt");
        boolean confirmacion = true;
        String hechizo, poderHechizo, opcion;
        while (confirmacion) {
            System.out.print("Ingrese el nombre del hechizo ===>");
            hechizo = leer.next();
            System.out.print("Ingrese el poder del hechizo ===>");
            poderHechizo = leer.next();
            System.out.println("ENTRADA    " + hechizo);
            BufferedWriter archHechizos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            archHechizos.write("\n");
            archHechizos.write(hechizo + "," + poderHechizo);
            System.out.print("Desea agregar otro hechizo? SI/NO ===> ");
            opcion = leer.next();
            opcion = opcion.toUpperCase();
            if (opcion.equals("SI")) {
                confirmacion = true;
                archHechizos.close();
            } else if (opcion.equals("NO")) {
                confirmacion = false;
                archHechizos.close();
            }
        }
    }

    // ##########################################################################################//SYS.OUT
    // Estadisticas//OK
    public static void estadisticasJugadores() throws FileNotFoundException {
        File file = new File("Jugadores.txt");
        Scanner arch = new Scanner(file);
        while (arch.hasNext()) {
            String[] partes = arch.next().split(",");
            String nombreUsuario = partes[0], ptosVida = partes[2], ataque = partes[3], defensa = partes[4],
                    velocidad = partes[5], numHechizos = partes[6], exp = partes[7];
            System.out.println("""

                    ####################
                    Usuario: %s
                    ####################
                    Puntos de Vida: %s
                    Ataque: %s
                    Defensa: %s
                    Velocidad: %s
                    Numero de Hechizos: %s
                    Experiencia: %s""".formatted(nombreUsuario, ptosVida, ataque, defensa, velocidad, numHechizos,
                    exp));
        }
        arch.close();
    }

    // #################################################################################################//usuarioBusqueda//
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
        arch.close();
        if (!encontrado) {
            System.out.println("Usuario no encontrado");
            Registro();
        }
    }

    // #################################################################################################//Registro//
    public static void Registro() throws FileNotFoundException {
        System.out.print("Desea registrarce? SI/NO ===> ");
        @SuppressWarnings("resource")
        Scanner lectura = new Scanner(System.in);
        String confirmacion = lectura.next();
        confirmacion = confirmacion.toUpperCase();

        while (!(confirmacion.equals("SI")) && !(confirmacion.equals("NO"))) {
            System.out.println("Ingrese un valor valido");
            System.out.print("Desea registrarce? SI/NO ===> ");
            confirmacion = lectura.next();
            System.out.println("");
            confirmacion = confirmacion.toUpperCase();
        }
        if (confirmacion.equals("SI")) {
            System.out.println("WENARDOOO");
            System.out.println("tabien");
        }
    }

    // #################################################################################################//menuUsuario//
    public static void menuUsuario() throws FileNotFoundException {
        System.out.println("Wenas wn");
    }

    // #################################################################################################//main//
    public static void main(String[] args) throws IOException {
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
                System.out.print("Desea iniciar nuevamente el programa? SI/NO ");
                confir = leer.next();
                confir = confir.toUpperCase();
            }
        } else {
            System.out.println("Porque no? >:c");
        }
        leer.close();
    }
}