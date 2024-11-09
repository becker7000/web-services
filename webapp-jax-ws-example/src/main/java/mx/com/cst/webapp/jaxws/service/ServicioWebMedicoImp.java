package mx.com.cst.webapp.jaxws.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import mx.com.cst.webapp.jaxws.model.CalculaImc;
import mx.com.cst.webapp.jaxws.model.Paciente;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "mx.com.cst.webapp.jaxws.service.ServicioWebMedico")
public class ServicioWebMedicoImp implements ServicioWebMedico {

    private int contadorConsulta;

    @Override
    @WebMethod
    public String saludar(String nombre) {
        System.out.println("\n\t Intancia del servicio web: "+this);
        contadorConsulta++;
        System.out.println("\n\t Consulta número "+contadorConsulta);
        return "Bienvenid@ "+nombre+" al sistema de IMC";
    }

    @Override
    @WebMethod
    public List<Paciente> listarPacientes() {
        return Arrays.asList(
                new Paciente("Laura"),
                new Paciente("Julio"),
                new Paciente("Arely"),
                new Paciente("Luis"),
                new Paciente("Naomi"),
                new Paciente("Eder")
        );
    }

    @Override
    @WebMethod
    public Paciente crearPaciente(Paciente paciente) {
        System.out.println("\n\t Paciente guardado: "+paciente.getNombre());
        return new Paciente(paciente.getNombre());
    }

    @Override
    @WebMethod
    public String obtenerDiagnostico(String nombre, double masa, double estatura) {
        Paciente paciente = new Paciente(nombre);
        CalculaImc calculaImc = new CalculaImc(paciente,masa,estatura);
        return calculaImc.generarDiagnostico();
    }

}
