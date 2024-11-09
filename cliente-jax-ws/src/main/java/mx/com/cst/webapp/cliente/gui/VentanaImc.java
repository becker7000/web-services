package mx.com.cst.webapp.cliente.gui;

import mx.com.cst.webapp.jaxws.service.Paciente;
import mx.com.cst.webapp.jaxws.service.ServicioWebMedico;
import mx.com.cst.webapp.jaxws.service.ServicioWebMedicoImpService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaImc extends JFrame {

    private JPanel panel;
    private JTextField nombreTextField;
    private JTextField masaTextField;
    private JTextField estaturaTextField;
    private JButton generarDiagnosticoButton;
    private JButton limpiarDatosButton;
    private JTextArea diagnosticoTextArea;

    public VentanaImc(){

        this.setTitle("Calculadora de índice de masa corporal");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(480,480));
        this.iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {
        this.colocarPaneles();
        this.comportamientoBotones();
    }

    private void colocarPaneles() {
        this.getContentPane().add(panel);
    }

    private void comportamientoBotones() {

        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    // Generamos una instancia del el Web Service
                    ServicioWebMedico servicioWebMedico =
                            new ServicioWebMedicoImpService()
                                    .getServicioWebMedicoImpPort();

                    // Para la ventana:
                    String nombre = nombreTextField.getText();
                    double masa = Double.parseDouble(masaTextField.getText());
                    double estatura = Double.parseDouble(estaturaTextField.getText());
                    String diagnostico = servicioWebMedico.obtenerDiagnostico(nombre,masa,estatura);
                    diagnosticoTextArea.setText(diagnostico);

                    // Otros detalles:
                    System.out.println("\n\t Un saludo: "+servicioWebMedico.saludar(nombre));
                    Paciente paciente = new Paciente();
                    paciente.setNombre(nombre);
                    Paciente pacienteCopia = servicioWebMedico.crearPaciente(paciente);
                    System.out.println("\n\t Paciente copia: "+pacienteCopia.getNombre());

                    System.out.println("\n\n\t LISTA DE PACIENTES");
                    servicioWebMedico.listarPacientes().forEach(
                            p -> System.out.print("\n\t -> Nombre: "+p.getNombre())
                    );

                    System.out.println("\n");

                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(
                            null,
                            "La masa y la estatura deben ser numeros.",
                            "Error en la entrada de datos",
                            JOptionPane.ERROR_MESSAGE
                    );
                }catch (Exception exception){
                    System.out.println("\n\t Error al consumir el Web Service");
                    System.out.println("\n\t Mensaje: "+exception.getMessage());
                }

            }
        };
        generarDiagnosticoButton.addActionListener(click);

        ActionListener limpiarClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombreTextField.setText("");
                masaTextField.setText("");
                estaturaTextField.setText("");
                diagnosticoTextArea.setText("");

            }
        };

        limpiarDatosButton.addActionListener(limpiarClick);

    }

}
