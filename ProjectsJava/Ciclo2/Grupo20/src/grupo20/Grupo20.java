
package grupo20;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.Scanner;
public class Grupo20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadAlumnos = sc.nextInt();
        
        for(int i = 0; i < cantidadAlumnos; i++){
            String[] alturaAlumnos = sc.nextLine().split(" ");
            System.out.println(Arrays.toString(alturaAlumnos));
        }
        
    }
    

}