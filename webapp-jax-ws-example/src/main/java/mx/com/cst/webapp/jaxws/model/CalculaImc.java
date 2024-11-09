package mx.com.cst.webapp.jaxws.model;

public class CalculaImc {

    private Paciente paciente;
    private double masa;
    private double estatura;
    private double imc;
    private String diagnostico;

    public CalculaImc(Paciente paciente, double masa, double estatura) {
        this.paciente = paciente;
        this.masa = masa;
        this.estatura = estatura;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String generarDiagnostico() {

        imc = masa / Math.pow(estatura, 2);
        String clasificacion;

        if (imc < 16) {
            clasificacion = "Delgadez severa";
        } else if (imc < 17) {
            clasificacion = "Delgadez moderada";
        } else if (imc < 18.5) {
            clasificacion = "Delgadez leve";
        } else if (imc < 25) {
            clasificacion = "Peso normal";
        } else if (imc < 30) {
            clasificacion = "Preobesidad";
        } else if (imc < 35) {
            clasificacion = "Obesidad leve";
        } else if (imc < 40) {
            clasificacion = "Obesidad media";
        } else {
            clasificacion = "Obesidad mórbida";
        }

        return String.format(
                """
                
                    DIAGNOSTICO
                    Paciente: %s
                    Masa: %.2f kg
                    Estatura: %.2f m
                    Indice de masa corporal: %.3f
                    Clasificación: %s
                    Consulta a tu médico...
                    
                """,paciente.getNombre(),masa,estatura,imc,clasificacion
        );

    }


}
