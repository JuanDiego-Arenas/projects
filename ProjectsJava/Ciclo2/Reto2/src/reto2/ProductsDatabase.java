
package reto2;
import java.util.HashMap;

/**
 * "Base de Datos" donde se alojan los productos preestablesidos
 * @author JuanDiego-Arenas
 */
public class ProductsDatabase {
    
    private HashMap<Integer, Product> listaProductos = new HashMap<Integer, Product>();
    
    /**
     * Es la lista de productos/base de datos preestablecidad
     */
    public ProductsDatabase() {
        listaProductos.put(1, new Product(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Product(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Product(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Product(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Product(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Product(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Product(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Product(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Product(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Product(10, "Jamon", 15000.0, 10));

    }
    
    /**
     * Crea un nuevo producto
     * @param producto 
     */
    public void create(Product producto) {
        listaProductos.put(producto.getId(), producto);
    }
    
    /**
     * Actualiza un producto
     * @param producto 
     */
    public void update(Product producto) {
        listaProductos.replace(producto.getId(), producto);
    }
    
    /**
     * Elimina un producto
     * @param producto 
     */
    public void delete(Product producto) {
        listaProductos.remove(producto.getId());
    }
    
    /**
     * Imprime el valor total de la lista de productos
     */
    public void generarInforme() {
        System.out.println(String.format("%.1f",total()));
    }
    
    /**
     * Calcula el valor total de la lista de productos
     * @return el precio del producto * la cantidad del producto
     */
    public double total() {
        double result = 0;
        for(Product producto : listaProductos.values()) {
            result += producto.getPrice() * producto.getInventory();
        }
        return result;
    }
    
    /**
     * Valida que el Id del producto esté dentro de la lista de productos
     * @param producto
     * @return True si el Id del producto existe. 
     * o False si el Id del producto no existe
     */
    public boolean verificarExistencia(Product producto) {
        return listaProductos.containsKey(producto.getId());
    }
}
