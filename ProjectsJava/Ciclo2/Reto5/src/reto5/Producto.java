package reto5;

/**
 *
 * @author JuanDiego-Arenas
 */
public class Producto {

    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer inventario;
    
    /**
     * Constructor vacio
     */
    public Producto() {
    }

    /**
     * Constructor con parametros
     * @param codigo
     * @param nombre
     * @param precio
     * @param inventario 
     */
    public Producto(Integer codigo, String nombre, Double precio, Integer inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    /**
     * Muestra el codigo identificador del producto
     * @return ID de producto
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Asignar un nuevo valor a el atributo "codigo"
     * @param codigo 
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Muesta el nombre del producto
     * @return Nombre de producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return 
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * 
     * @param precio 
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * 
     * @return 
     */
    public Integer getInventario() {
        return inventario;
    }

    /**
     * 
     * @param inventario 
     */
    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }
}
