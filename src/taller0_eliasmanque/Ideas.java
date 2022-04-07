package Taller0;

import java.util.Scanner;

public class Ideas{

    public static int buscar(String user,String pass){
        return 2;
    }
    public static void admin(){
        System.out.println("Bienvenido al menu de ADMIN");

    }
    public static void usuario(){
        //Si no encontramos al usuario debemos llevarlo a registrarlo sino ya podremos ingresar al menu
        
        System.out.println("Bienvenido al menu de Usuario");
        
    }
    public static void Registro() {
        System.out.println("Panita no bitches?");
        
    }


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        //Variables a Usar
        String user, password;

        //Inicio de programa
        System.out.println("########################################################");
        System.out.println("Desea iniciar el programa? SI/NO");
        String confir = leer.next();
        System.out.println("");
        System.out.println("########################################################");
        confir = confir.toUpperCase();

        while (!(confir.equals("SI")) && !(confir.equals("NO"))){
            System.out.println("Ingrese un valor valido");
            System.out.println("Desea iniciar el programa? SI/NO");
            confir = leer.next();
            System.out.println("");
            System.out.println("########################################################");
            confir = confir.toUpperCase();
        }
        if (confir.equals("SI")){
            while(confir.equals("SI")){
                System.out.print("Ingrese su nombre de Usuario ===> ");
                user = leer.next();
                System.out.println("");
                System.out.print("Ingrese su nombre de Contraseña ===> ");
                password = leer.next();

                //Division entre Usuario, Admin y Registro
                //ADMIN
                if(user.equals("Admin") && password.equals("Patata19")){
                    admin();
                }
                //USUARIO
                else{
                    usuario();
                }
                confir = leer.next();
                confir = confir.toUpperCase();
            }
        }else{
            System.out.println("Como que no >:c");
        }
        leer.close();
}
}