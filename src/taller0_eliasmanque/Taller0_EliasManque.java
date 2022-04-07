package taller0_eliasmanque;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Elias M. Olivares
 */
public class Taller0_EliasManque {
    
    public static void main(String[] args) throws FileNotFoundException{
        // Lectura de Archivos
        File fileJugadores = new File("Jugadores.txt");
        Scanner archJugadores = new Scanner(fileJugadores);
        Scanner leer = new Scanner(System.in);

        // Inicio de sesion
        System.out.println("Ingrese su usuario y contaseña.");
        System.out.print("Usuario ===> ");
        String user = leer.next();
        System.out.print("");
        System.out.print("Contraseña ===> ");
        String pass = leer.next();

        while (archJugadores.hasNext()) {
            String[] partes = archJugadores.next().split(",");

            // Declaracion de variables String usuario y contraseña
            String usuario = partes[0], contraseña = partes[1];

            // Declaracion de variables int (puntos de vida), ataque, defensa, velocidad,
            // numHechizos y exp
            int puntosVida = Integer.parseInt(partes[2]), ataque = Integer.parseInt(partes[3]),
                    defensa = Integer.parseInt(partes[4]), velocidad = Integer.parseInt(partes[5]),
                    numHechizos = Integer.parseInt(partes[6]), exp = Integer.parseInt(partes[7]);
            
            System.out.println(System.getProperty("user.dir"));
        }
        archJugadores.close();
    }
    
}
