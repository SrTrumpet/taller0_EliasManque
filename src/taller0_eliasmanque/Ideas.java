package Taller0;

import java.util.Scanner;

public class Ideas{

    public static int buscar(){
        return 0;
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        //Inicio de programa
        System.out.println("Desea iniciar el programa? SI/NO");
        String confir = leer.next();
        confir = confir.toUpperCase();
        System.out.println(confir);
        while (!(confir.equals("SI")) && !(confir.equals("NO"))){
            System.out.println("Ingrese un valor valido");
            System.out.println("Desea iniciar el programa? SI/NO");
            confir = leer.next();
            confir = confir.toUpperCase();
        }
        if (confir.equals("SI")){
            while(confir.equals("SI")){
                System.out.println("Llegaste");
                confir = leer.next();
            }
        }else{
            System.out.println("Como que no");
        }
        leer.close();
}
}