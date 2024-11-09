package mx.com.cst.webapp.jaxws.service;

import jakarta.jws.WebService;
import mx.com.cst.webapp.jaxws.model.Paciente;

import java.util.List;

@WebService
public interface ServicioWebMedico {

    String saludar(String nombre);
    List<Paciente> listarPacientes();
    Paciente crearPaciente(Paciente paciente);
    String obtenerDiagnostico(String nombre,double masa, double estatura);

}
