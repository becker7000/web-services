package mx.com.cst.webapp.jaxb.service;

import jakarta.jws.WebService;
import mx.com.cst.webapp.jaxb.model.Circulo;

@WebService(endpointInterface = "mx.com.cst.webapp.jaxb.service.CirculoService")
public class CirculoServiceImp implements CirculoService{

    @Override
    public double calcularArea(Circulo circulo) {
        double area = circulo.calcularArea();
        return area;
    }

    @Override
    public double calcularPerimetro(Circulo circulo) {
        double perimetro = circulo.calcularPerimetro();
        return perimetro;
    }

}
