package mx.com.cst.webapp.jaxb.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Circulo {

    private double radio;

    public Circulo(){

    }

    public Circulo(double radio){
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularArea(){
        return Math.PI*Math.pow(radio,2);
    }

    public double calcularPerimetro(){
        return Math.PI*radio*2;
    }

}
