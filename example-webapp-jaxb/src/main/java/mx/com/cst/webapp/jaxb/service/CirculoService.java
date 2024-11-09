package mx.com.cst.webapp.jaxb.service;

import jakarta.jws.*;
import mx.com.cst.webapp.jaxb.model.Circulo;

@WebService
public interface CirculoService {

    @WebMethod
    double calcularArea(Circulo circulo);

    @WebMethod
    double calcularPerimetro(Circulo circulo);

}
