
package reto2;

/**
 * Clase productos
 * @author JuanDiego-Arenas
 */
public class Product {
    private Integer id;
    private String name;
    private double price;
    private Integer inventory;

    /**
     * Constructor vacio
     */
    public Product() {
    }
    
    /**
     * Constructor con parametros
     * @param id
     * @param name
     * @param price
     * @param inventory 
     */
    public Product(Integer id,String name,double price,int inventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }
    
    /**
     * @return Id del producto
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modificar el id del producto
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Nombre del producto
     */
    public String getName() {
        return name;
    }

    /**
     * Modificarl el nombre del producto
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Precio del procudto
     */
    public double getPrice() {
        return price;
    }

    /**
     * Modificar el precio del producto 
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return La cantidad del producto en el inventario
     */
    public int getInventory() {
        return inventory;
    }

    /**
     * cantidad de procunto guardado para modificarlo
     * @param inventory
     */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + 
                ", inventory=" + inventory + '}';
    }
  
    
}
