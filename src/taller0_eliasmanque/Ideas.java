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

            } else if (opcion.equals("B")) {// Agregar Enemigos OK
                System.out.println(" ");
                agregarEnemigos();

            } else if (opcion.equals("C")) {// Agregar Hechizos OK
                System.out.println(" ");
                agregarHechizos();

            } else if (opcion.equals("D")) {// Ver las estadisticas de los Jugadores OK
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

    // ##########################################################################################//Eliminar
    // Jugador
    public static void eliminarJugador() {

    }

    // ##########################################################################################//SYS.OUT
    // //Agregar Enemigos
    public static void agregarEnemigos() throws IOException {
        @SuppressWarnings("resource") // Se usa solo para retirar el aviso del Scanner
        Scanner leer = new Scanner(System.in);
        File file = new File("Enemigos.txt");
        boolean confirmacion = true;
        String nomEnemigo, hp, ataque, clase, velocidad, opcion;
        while (confirmacion) {
            System.out.print("Ingrese el nombre del enemigo ===> ");
            nomEnemigo = leer.next();

            System.out.print("Ingrese el hp del enemigo ===> ");
            hp = leer.next();

            System.out.print("Ingrese el poder de ataque ===> ");
            ataque = leer.next();

            System.out.print("Ingrese la clase del enemigo del enemigo {S,A,B,C,F} ===> ");
            clase = leer.next();
            clase = clase.toUpperCase();

            System.out.print("Ingrese la velocidad del enemigo ===>");
            velocidad = leer.next();

            BufferedWriter archEnemigo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            archEnemigo.write("\n");
            archEnemigo.write(nomEnemigo + "," + hp + "," + ataque + "," + clase + "," + velocidad);
            System.out.print("Desea agregar otro enemigo? SI/NO ===> ");
            opcion = leer.next();
            opcion = opcion.toUpperCase();
            if (opcion.equals("SI")) {
                confirmacion = true;
                archEnemigo.close();
            } else if (opcion.equals("NO")) {
                confirmacion = false;
                archEnemigo.close();
            }
        }
    }

    // ##########################################################################################//SYS.OUT
    // // Agregar Hechizos
    public static void agregarHechizos() throws IOException {
        @SuppressWarnings("resource") // Se usa solo para retirar el aviso del Scanner
        Scanner leer = new Scanner(System.in);
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
    public static void usuarioBusqueda(String usuario, String pass) throws IOException {
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
                    System.out.println("");
                    menuUsuario(user);
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

    // #################################################################################################//Registro//OK
    public static void Registro() throws IOException {
        System.out.print("Desea registrarce? SI/NO ===> ");
        @SuppressWarnings("resource")
        Scanner lectura = new Scanner(System.in);
        File file = new File("Jugadores.txt");
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
            System.out.print("Ingrese un nombre de usuario ===> ");
            String user = lectura.next();
            boolean whileError = true;
            while (whileError) {
                whileError = repetido(user);
                if (whileError) {
                    System.out.println("Usuario ya existe");
                    System.out.print("Ingrese nuevamente ===> ");
                    user = lectura.next();
                } else {
                    System.out.println("Usuario Disponible");
                    System.out.print("Ingrese su contraseña ===> ");
                    String pass = lectura.next();
                    BufferedWriter archJugadores = new BufferedWriter(
                            new OutputStreamWriter(new FileOutputStream(file, true)));
                    archJugadores.write("\n");
                    archJugadores.write(user + "," + pass + ",10,10,10,10,0,0");
                    archJugadores.close();
                    menuUsuario(user);
                }
            }
        }
    }

    // #################################################################################################//repetido//OK
    public static boolean repetido(String user) throws FileNotFoundException {
        File file = new File("Jugadores.txt");
        System.out.println("########################################################");
        @SuppressWarnings("resource")
        Scanner arch = new Scanner(file);
        while (arch.hasNext()) {
            String[] partes = arch.next().split(",");
            String name = partes[0];
            if (name.equals(user)) {
                return true;
            }
        }
        return false;
    }

    // #################################################################################################//podio//OK
    public static void podio(String user) throws FileNotFoundException {
        File file = new File("Jugadores.txt");
        System.out.println("########################################################");
        @SuppressWarnings("resource")
        Scanner arch = new Scanner(file);
        int contador = 0;
        while (arch.hasNext()) {
            arch.next().split(",");
            contador++;
        }
        int[] listaExp = new int[contador];
        String[] jugadores = new String[contador];
        int index = 0;

        Scanner arch2 = new Scanner(file);
        while (arch2.hasNext()) {
            String[] partes = arch2.next().split(",");
            String name = partes[0];
            int exp = Integer.parseInt(partes[7]);
            listaExp[index] = exp;
            jugadores[index] = name;
            index++;
        }
        arch2.close();
        ordenarLista(listaExp, jugadores, user);
    }

    // #################################################################################################//Ordenar
    // Listas//OK
    public static void ordenarLista(int[] experiencia, String[] Jugadores, String user) {
        for (int i = 1; i < experiencia.length; i++) {
            for (int j = 0; j < experiencia.length - i; j++) {
                if (experiencia[j] > experiencia[j + 1]) {
                    int aux = experiencia[j];
                    experiencia[j] = experiencia[j + 1];
                    experiencia[j + 1] = aux;

                    String aux2 = Jugadores[j];
                    Jugadores[j] = Jugadores[j + 1];
                    Jugadores[j + 1] = aux2;
                }
            }
        }
        String[] verificar = new String[10];
        int podio = 1, indexVerificar = 0;
        for (int i = experiencia.length - 1; i > experiencia.length - 11; i--) {
            System.out.println(podio + " Lugar: " + Jugadores[i] + " con " + experiencia[i] + " de XP ");
            verificar[indexVerificar] = Jugadores[podio];
            podio++;
            indexVerificar++;
        }
        for (int i = 0; i < 10; i++) {
            if (verificar[i].equals(user)) {
                System.out.println("########################################################");
                System.out.println("Felicidades estas dentro de los 10 Mejores del Juego!!");
            }
        }
    }

    // #################################################################################################//Busqueda
    // estadisticas
    public static void busqeEstadisticas(String user) throws FileNotFoundException {
        File file = new File("Jugadores.txt");
        Scanner arch = new Scanner(file);
        while (arch.hasNext()) {
            String[] partes = arch.next().split(",");
            String nombre = partes[0];
            String  ptosVida    = partes[2], ataque      = partes[3], 
                    defensa     = partes[4], velocidad   = partes[5],
                    numHechizos = partes[6], exp         = partes[7];
            if (user.equals(nombre)) {
                System.out.println("Usuario encontrado: ");
                System.out.println("""
                        ########################################################
                        Usuario: [%s]
                        ########################################################
                        Puntos de Vida      ==> %s
                        Ataque              ==> %s
                        Defensa             ==> %s
                        Velocidad           ==> %s
                        Numeros de Hechizos ==> %s
                        EXP                 ==> %s
                        """.formatted(user,ptosVida,ataque,defensa,velocidad,numHechizos,exp));
            }
        }arch.close();
    }

    // #################################################################################################//Juego JcE//
    public static void JuegoJCE() {
        
    }
    // #################################################################################################//Juego JcJ//
    public static void JuegoJcJ() {
        
    }
    // #################################################################################################//menuUsuario//
    public static void menuUsuario(String user) throws FileNotFoundException {
        @SuppressWarnings("resource") // Se usa solo para retirar el aviso del Scanner
        Scanner leer = new Scanner(System.in);
        String opcion;

        System.out.println("Bienvenido " + "[" + user + "]");
        System.out.println("");
        System.out.println("Opciones del menu de usuario: ");
        System.out.print("""
                A)Inicio del juego
                B)Aprender hechizo
                C)Ver estadisticas de un Jugador
                D)Ver estadisticas de Hechizo
                E)Ver ranking de jugadores con mas Exp
                F)Salir

                Ingrese su opcion ===> """);
        opcion = leer.next();
        opcion = opcion.toUpperCase();
        if (opcion.equals("A")) {
            System.out.print("""
                    Ingrese modo de juego

                    1 ==> JcE
                    2 ==> JcJ

                    Ingrese su opcion ===>
                    """);
            int modoJuego = leer.nextInt();
            if(modoJuego == 1){
                JuegoJCE();
            }else if (modoJuego == 2){
                JuegoJcJ();
            }
        } else if (opcion.equals("B")) {

        } else if (opcion.equals("C")) {
            System.out.println("Busqueda de estadisticas: ");
            System.out.print("Ingrese el nombre del usuario que busca ===> ");
            String busqUser = leer.next();
            busqeEstadisticas(busqUser);
        } else if (opcion.equals("D")) {
            
        } else if (opcion.equals("E")) {
            System.out.println("Ranking de los jugadores con mas exp: ");
            podio(user);

        } else if (opcion.equals("F")) {
            System.out.println("Saliendo del menu jugador ... ");
        }
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
            System.out.println("""
                        ░░█▀░░░░░░░░░░░▀▀███████░░░░
                        ░░█▌░░░░░░░░░░░░░░░▀██████░░░
                        ░█▌░░░░░░░░░░░░░░░░███████▌░░
                        ░█░░░░░░░░░░░░░░░░░████████░░
                        ▐▌░░░░░░░░░░░░░░░░░▀██████▌░░
                        ░▌▄███▌░░░░▀████▄░░░░▀████▌░░
                        ▐▀▀▄█▄░▌░░░▄██▄▄▄▀░░░░████▄▄░
                        ▐░▀░░═▐░░░░░░══░░▀░░░░▐▀░▄▀▌▌
                        ▐░░░░░▌░░░░░░░░░░░░░░░▀░▀░░▌▌
                        ▐░░░▄▀░░░▀░▌░░░░░░░░░░░░▌█░▌▌
                        ░▌░░▀▀▄▄▀▀▄▌▌░░░░░░░░░░▐░▀▐▐░
                        ░▌░░▌░▄▄▄▄░░░▌░░░░░░░░▐░░▀▐░░
                        ░█░▐▄██████▄░▐░░░░░░░░█▀▄▄▀░░
                        ░▐░▌▌░░░░░░▀▀▄▐░░░░░░█▌░░░░░░
                        ░░█░░▄▀▀▀▀▄░▄═╝▄░░░▄▀░▌░░░░░░
                        ░░░▌▐░░░░░░▌░▀▀░░▄▀░░▐░░░░░░░
                        ░░░▀▄░░░░░░░░░▄▀▀░░░░█░░░░░░░
                        ░░░▄█▄▄▄▄▄▄▄▀▀░░░░░░░▌▌░░░░░░
                        ░░▄▀▌▀▌░░░░░░░░░░░░░▄▀▀▄░░░░░
                        ▄▀░░▌░▀▄░░░░░░░░░░▄▀░░▌░▀▄░░░
                        ░░░░▌█▄▄▀▄░░░░░░▄▀░░░░▌░░░▌▄▄
                        ░░░▄▐██████▄▄░▄▀░░▄▄▄▄▌░░░░▄░
                        ░░▄▌████████▄▄▄███████▌░░░░░▄
                        ░▄▀░██████████████████▌▀▄░░░░
                        ▀░░░█████▀▀░░░▀███████░░░▀▄░░
                        ░░░░▐█▀░░░▐░░░░░▀████▌░░░░▀▄░
                        ░░░░░░▌░░░▐░░░░▐░░▀▀█░░░░░░░▀
                        ░░░░░░▐░░░░▌░░░▐░░░░░▌░░░░░░░
                        ░╔╗║░╔═╗░═╦═░░░░░╔╗░░╔═╗░╦═╗░
                        ░║║║░║░║░░║░░░░░░╠╩╗░╠═╣░║░║░
                        ░║╚╝░╚═╝░░║░░░░░░╚═╝░║░║░╩═╝░
                    """);
        }
        leer.close();
    }
}