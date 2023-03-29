
package reto5;
import java.util.HashMap;

/**
 *
 * @author Ryoshi
 */
public class BaseDatosProductos {
    
    private HashMap<Integer,Producto> listaProductos = new HashMap<Integer,Producto>();
    
    public BaseDatosProductos() {
        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }

    /**
     * Muesta la lista de productos (Getter)
     * @return Lista de productos (de la clase "BaseDatosProductos")
     */
    public HashMap<Integer, Producto> getListaProductos() {
        return listaProductos;
    }

}
