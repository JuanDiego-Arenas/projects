package co.edu.usergioarboleda.inventario.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author JuanDiego-Arenas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("Productos")
public class Productos {

    @Id
    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer inventario;

    /**
     * 
     * @param nombre
     * @param precio
     * @param inventario 
     */
    public Productos(String nombre, Double precio, Integer inventario) {
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

}
