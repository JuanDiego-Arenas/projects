
package reto3;
import java.util.Scanner;
/**
 * @author JuanDiego-Arenas
 */
public class Reto3 {

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private static final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public static String read(){
        return scanner.nextLine();
    } 

    public static void main(String[] args) {
        run();
    }
    
    /**
    * método principal
    */
    public static void run(){
        
        // Nuevo producto para la lista de productos
        ProductsDatabase baseDatos = new ProductsDatabase();
        String operador = read();
        String[] parametros = read().split(" ");
        Product producto = new Product(Integer.parseInt(parametros[0]),
                parametros[1],Double.parseDouble(parametros[2]),Integer.parseInt(parametros[3]));
        
        // Validacion del operador y sus respectivo comando
        if(operador.equals("AGREGAR") && !baseDatos.verificarExistencia(producto)) {
            baseDatos.create(producto);
            baseDatos.generarInforme();
        }else if(operador.equals("ACTUALIZAR") && baseDatos.verificarExistencia(producto)) {
            baseDatos.update(producto);
            baseDatos.generarInforme();
        }else if(operador.equals("BORRAR") && baseDatos.verificarExistencia(producto)) {
            baseDatos.delete(producto);
            baseDatos.generarInforme();
        }else {
            System.out.println("ERROR");
        }
        
    }
    
}
