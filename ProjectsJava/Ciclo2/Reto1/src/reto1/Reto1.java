
package reto1;
import java.util.Scanner;

/**
 * 
 * @author JuanDiego-Arenas
 */
public class Reto1 {
    
    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private  static final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public static String read(){
        return scanner.nextLine();
    }

    public static void main(String args[]) {
        run();
    }
    
    public static void run(){
        
        String[] entry = read().split(" ");

        double masa = Double.parseDouble(entry[0]);
        double altura = Double.parseDouble(entry[1]);
        int edad = Integer.parseInt(entry[2]);
        
        double imc = calcularIMC(masa,altura);
        
        // Esta es la validacion de los valores ingresados
        // No cree una funcion para validad tanto este como el riesgo, ya que se me hacia mas facil de este modo.
        if(masa >= 0 && masa <= 150 && altura >= 0.1 && altura <= 2.5 && edad >= 0 && edad <= 110) {
            System.out.println(String.format("%.1f",calcularIMC(masa,altura)) +" "+ calcularRiesgo(imc,edad));
        } else { 
            System.out.println("ERROR");
        }
       
    }
    
    /**
     * Este metodo calcula el Indice de Masa Corporal de la persona
     * @param masa
     * @param altura
     * @return El IMC de la persona
     */
    public static double calcularIMC(double masa, double altura){
        return masa / (altura*altura );
        
    }
    
    /**
     * Este metodo calcula el nivel de riesgo de sufrir problemas del corazón 
     * @param imc
     * @param edad
     * @return Nivel de riesgo "Bajo", "Medio" o "Alto"
     */
    public static String calcularRiesgo(double imc, int edad){
        String riesgo = "";
        
        // Esta es la validacion del nivel de riesgo de sufrir problemas del corazón
        if(edad < 45 && imc < 22){
            return riesgo = ("Bajo");
        }else if(edad < 45 && imc >= 22){
            return riesgo = "Medio";
        }else if(edad >= 45 && imc < 22){
            return riesgo = "Medio";
        }else if(edad >= 45 && imc >= 22){
            return riesgo = "Alto";
        }
        
        return riesgo;
    }
       
}
