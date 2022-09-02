package co.edu.usergioarboleda.inventario.app.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanDiego-Arenas
 */
@Repository
public interface RepositirioProductos extends CrudRepository<Productos, Integer> {

}
