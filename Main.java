/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;
import java.util.*;
import java.io.*;
/**
 *
 * @author jcgof
 */
public class Main {
    public static void main(String args[])
    {
        Itunes itunes = new Itunes();
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. añadir Cancion");
        System.out.println("2. reseñas Cancion");
        System.out.println("3. desacargar Cancion");
        System.out.println("4. Canciones");
        System.out.println("5. Informacion Cancion");
        System.out.println("6. Salir");
        System.out.println("Elija la opcion que desea");
        opcion = scanner.nextInt();
        while(opcion!=6){
            switch(opcion){
                case 1:
                    
                    break;
                    
                case 2: 
                    
                    break;
                    
                case 3 : 
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5: 
                    
                    break;
            }
        }
        System.out.println("Salio del programa");
    }
}
