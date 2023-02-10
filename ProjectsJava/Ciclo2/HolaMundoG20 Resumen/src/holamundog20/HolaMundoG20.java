/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundog20;

/**
 *
 * @author fdomoreno
 */

import java.util.Scanner;

public class HolaMundoG20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Tipos de datos Primitivos y definicion de variables:
        //Numeros Enteros
        byte numeroEntero=0;
        short numeroEntero1=0;
        int numeroEntero2=0;
        long numeroEntero3=0;
        
        //Numeros con punto flotante o decimales
        double numeroConDecimal=0.1e2;
        float numeroConDecimal1=0.2f;
        
        //Caracter
        char caracter='f';
        
        //booleando true o false
        boolean verdad = true;
        
        //Tipos de datos cadena
        String cadenas ="";
        
        
        //Leer datos en consola:
        // Se define un elemento de tipo escaner
        Scanner sc = new Scanner(System.in);
        
        //se utiliza el metodo nextLine() o nextInt() o nextDouble, etc, dependiendo del tipo de datos.
        //para solicitar que se ingrese un nuevo dato en consola:
        cadenas = sc.nextLine();
        numeroEntero2 = sc.nextInt();
        numeroEntero= sc.nextByte();
        
        //estructura IF:
        
        if(numeroEntero1>=numeroEntero2){
            //bloque de codigo
        }else if(caracter=='a'){
            //bloque de codigo
        }else{
            //bloque de codigo
        }
        
        
        int i=0;
        do{
            menu();
            i=sc.nextInt();
            
            switch(i){
                case 1:
                    System.out.println("Escogió Lavar");
                    break;
                case 2:
                    System.out.println("Escogió Planchar");
                    break;
                case 3:
                    System.out.println("Escogió Limpiar");
                    break;
                case 4:
                    System.out.println("Escogió organizar");
                    break;
                case 5:
                    System.out.println("Chao!");
                    break;
                default:
                    System.err.println("Opción no valida");
                    break;
            }
        }while(i!=5);
        
        //Forma de mostrar o escribir en la consola.
        System.out.println("Hola mundo");
    }
    
    
    //Metodo void no retorna datos
    static void menu(){
        System.out.println("Por favor seleccione una opción del menú: ");
        System.out.println("=====================");
        System.out.println("1. Lavar");
        System.out.println("2. Planchar");
        System.out.println("3. Limpiar");
        System.out.println("4. Organizar");
        System.out.println("5. Salir");
        System.out.println("=====================");
    }
    
    //Metodo que retorna un double y recibe 2 argumentos uno double y el otro entero
    double suma(double a, int b){
        return a + b;
    }
    
    boolean validarNumeroPar(int numero){
        if((numero%2)==0){
            return true;
        }else{
            return false;
        }
    }
    
}
