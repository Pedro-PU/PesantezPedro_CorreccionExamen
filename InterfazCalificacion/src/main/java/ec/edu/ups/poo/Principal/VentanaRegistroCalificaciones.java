package ec.edu.ups.poo.Principal;
import java.awt.*;
import java.awt.event.*;
public class VentanaRegistroCalificaciones extends Frame {
    // Campos de texto accesibles para capturar datos
    private TextField txtCedula;
    private TextField txtNombre;
    private TextField txtApellido;

    public VentanaRegistroCalificaciones() {
        setTitle("Registro de Calificaciones");
        setSize(400, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel superior con botones
        Panel panelSuperior = new Panel(new FlowLayout());
        Button btnAgregar = new Button("Agregar");
        Button btnModificar = new Button("Modificar");
        Button btnEliminar = new Button("Eliminar");
        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnModificar);
        panelSuperior.add(btnEliminar);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con etiquetas y campos de texto
        Panel panelCentral = new Panel(new GridLayout(3, 2, 10, 10));
        panelCentral.add(new Label("Cédula:"));
        txtCedula = new TextField();
        panelCentral.add(txtCedula);

        panelCentral.add(new Label("Nombre:"));
        txtNombre = new TextField();
        panelCentral.add(txtNombre);

        panelCentral.add(new Label("Apellido:"));
        txtApellido = new TextField();
        panelCentral.add(txtApellido);

        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior con botones
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnGuardar = new Button("Guardar");
        Button btnCancelar = new Button("Cancelar");
        panelInferior.add(btnGuardar);
        panelInferior.add(btnCancelar);
        add(panelInferior, BorderLayout.SOUTH);

        // Evento del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                System.out.println("Datos ingresados:");
                System.out.println("Cédula: " + cedula);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}