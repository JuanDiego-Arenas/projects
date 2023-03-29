package co.edu.usergioarboleda.inventario;

import co.edu.usergioarboleda.inventario.app.controller.ControladorProductos;
import co.edu.usergioarboleda.inventario.app.model.RepositirioProductos;
import co.edu.usergioarboleda.inventario.app.view.FrmInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    @Autowired
    private RepositirioProductos repositorio;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(InventarioApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            FrmInventario vista = new FrmInventario();
            ControladorProductos controlador = new ControladorProductos(repositorio,vista);
        };
    }

}
