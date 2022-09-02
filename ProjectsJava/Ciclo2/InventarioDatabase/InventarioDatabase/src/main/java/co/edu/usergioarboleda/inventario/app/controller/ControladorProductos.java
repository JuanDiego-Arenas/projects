package co.edu.usergioarboleda.inventario.app.controller;

import co.edu.usergioarboleda.inventario.app.model.Productos;
import co.edu.usergioarboleda.inventario.app.model.RepositirioProductos;
import co.edu.usergioarboleda.inventario.app.view.FrmInventario;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ryoshi
 */
public class ControladorProductos implements ActionListener {
    
    private RepositirioProductos repositorio;
    private FrmInventario vista;

    public ControladorProductos() {

    }

    public ControladorProductos(RepositirioProductos repositorio, FrmInventario vista) {
        this.repositorio = repositorio;
        this.vista = vista;
        ListarProductos();
        AgregarEventos();
        this.vista.setVisible(true);
    }

    /**
     * LLamar lista
     * @return Lista de productos de la base de datos
     */
    public List<Productos> listar() {
        return (List<Productos>) repositorio.findAll();
    }

    /**
     * Muestra la lista de productos en la tabla "TblInventario"
     */
    public void ListarProductos() {
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{
            "codigo", "Nombre", "Precio", "Inventario"}, 0);

        for (Productos producto : listar()) {
            modeloTabla.addRow(new Object[]{producto.getCodigo(),
                producto.getNombre(), producto.getPrecio(), producto.getInventario()});
        }

        vista.getTblInventario().setModel(modeloTabla);

    }
    

    public void guardar(Productos producto) {
        if(producto.getCodigo()==null){
            repositorio.save(producto);
        }
    }

    public void actualizar(Productos producto) {
        if(producto.getCodigo()!=null){
            repositorio.save(producto);
        }
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregarProducto()) {
            AgregarProducto();
        }
        if (e.getSource() == vista.getBtnActualizarProducto()) {
            ActualizarProducto();
        }
        if (e.getSource() == vista.getBtnBorrarProducto()) {
            EliminarProducto();
        }
        if (e.getSource() == vista.getBtnInforme()) {
            GenerarInforme();
        }
        if (e.getSource() == vista.getBtnRefrescar()) {
            ListarProductos();
        }
    }

    private void AgregarEventos() {
        vista.getBtnAgregarProducto().addActionListener(this);
        vista.getBtnActualizarProducto().addActionListener(this);
        vista.getBtnBorrarProducto().addActionListener(this);
        vista.getBtnInforme().addActionListener(this);
        vista.getBtnRefrescar().addActionListener(this);
    }

    public void AgregarProducto() {
        try {
            List<JTextField> cajasTexto = new ArrayList<>();
            cajasTexto.add(vista.getTxtNombreProducto());
            cajasTexto.add(vista.getTxtInventarioProducto());
            cajasTexto.add(vista.getTxtPrecioProducto());
            if (ValidarCampos(cajasTexto)) {
                Productos producto = new Productos(vista.getTxtNombreProducto().getText(),
                        Double.parseDouble(vista.getTxtPrecioProducto().getText()),
                        Integer.parseInt(vista.getTxtInventarioProducto().getText()));
                guardar(producto);
                ListarProductos();
                vista.Limpiar();
            } else {
                JOptionPane.showMessageDialog(vista, 
                    "Error: por favor complete los campos", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, 
                    "Error: en tipo de dato ingresado en uno o varios de los campos", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ActualizarProducto() {
        try {
            int fila = vista.getTblInventario().getSelectedRow();
            Integer codigo = (Integer) vista.getTblInventario().getValueAt(fila, 0);
            Productos producto = repositorio.findById(codigo).get();
            JTextField TxtNombreActualizar = new JTextField(producto.getNombre());
            JTextField TxtPrecioActualizar = new JTextField(String.valueOf(producto.getPrecio()));
            JTextField TxtInventarioActualizar = new JTextField(String.valueOf(producto.getInventario()));
            JPanel PnlActualizar = new JPanel(new GridLayout(0, 1));
            PnlActualizar.add(new JLabel("Nombre: "));
            PnlActualizar.add(TxtNombreActualizar);
            PnlActualizar.add(new JLabel("Precio: "));
            PnlActualizar.add(TxtPrecioActualizar);
            PnlActualizar.add(new JLabel("Inventario: "));
            PnlActualizar.add(TxtInventarioActualizar);
            int respuesta = JOptionPane.showOptionDialog(vista, PnlActualizar,
                    "Actualizar Producto " + producto.getNombre(), JOptionPane.OK_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Actualizar Producto"}, 0);
            if (respuesta == JOptionPane.OK_OPTION) {
                List<JTextField> cajasTexto = new ArrayList<>();
                cajasTexto.add(TxtNombreActualizar);
                cajasTexto.add(TxtPrecioActualizar);
                cajasTexto.add(TxtInventarioActualizar);
                if (ValidarCampos(cajasTexto)) {
                    actualizar(new Productos(codigo, TxtNombreActualizar.getText(), 
                            Double.parseDouble(TxtPrecioActualizar.getText()),
                            Integer.parseInt(TxtInventarioActualizar.getText())));
                    ListarProductos();
                } else {
                    JOptionPane.showMessageDialog(vista, 
                    "Error: en tipo de dato ingresado en uno o varios de los campos", "Error", 
                    JOptionPane.ERROR_MESSAGE); 
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: no hay producto seleccionado o los datos son incorrectos", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarProducto() {
        try {
            int fila = vista.getTblInventario().getSelectedRow();
            Integer codigo = (Integer) vista.getTblInventario().getValueAt(fila, 0);
            String nombre = (String) vista.getTblInventario().getValueAt(fila, 1);
            int respuesta = JOptionPane.showConfirmDialog(vista,
                    "¿Quieres eliminar el producto: " + nombre + "?",
                    "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (respuesta == 0) {
                eliminar(codigo);
                ListarProductos();
                JOptionPane.showMessageDialog(vista, "Producto eliminado de forma exitosa",
                        "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: no hay producto seleccionado",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void GenerarInforme() {
        String nombrePrecioMayor = "";
        String nombrePrecioMenor = "";
        Double precioMayor = 0.0;
        Double precioMenor = 999999999999999.9;
        Double totalPrecios = 0.0;
        Double totalValores = 0.0;

        for(Productos producto : listar()){
             if(producto.getPrecio() > precioMayor){
                 precioMayor = producto.getPrecio();
                 nombrePrecioMayor = producto.getNombre();
             }
             if(producto.getPrecio() < precioMenor){
                 precioMenor = producto.getPrecio();
                 nombrePrecioMenor = producto.getNombre();
             }
             totalValores += producto.getPrecio() * producto.getInventario();
             totalPrecios += producto.getPrecio();
        }

        JOptionPane.showMessageDialog(vista,
                "\n\nProducto precio mayor: " + nombrePrecioMayor + 
                "\n\nProducto precio menor: " + nombrePrecioMenor + 
                "\n\nPromedio precios: " + String.format("%.1f",totalPrecios/listar().size()) +
                "\n\nTotal del inventario: " + totalValores,
                "Informe",JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean ValidarCampos(List<JTextField> cajasTexto) {
        boolean valido = true;
        for (JTextField caja : cajasTexto) {
            if (caja.getText().isEmpty()) {
                valido = false;
            }
        }
        return valido;
    }
    
}
