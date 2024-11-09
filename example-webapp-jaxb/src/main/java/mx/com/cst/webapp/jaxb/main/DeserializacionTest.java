package mx.com.cst.webapp.jaxb.main;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.com.cst.webapp.jaxb.model.Circulo;

import java.io.File;

public class DeserializacionTest {

    public static void main(String[] args){

        try{

            // Creando un archivo
            File archivo = new File("circulo.xml");

            JAXBContext contexto = JAXBContext.newInstance(Circulo.class);

            // Se crea un deseralizador:
            Unmarshaller unmarshaller = contexto.createUnmarshaller();

            // Deserializamos:
            Circulo circulo = (Circulo) unmarshaller.unmarshal(archivo);

            // Resultado:
            System.out.println("\n\t Objeto de la clase Circulo deserializado: ");
            System.out.println("\n\t Radio: "+circulo.getRadio());
            System.out.printf("\n\t Área: %.3f \n",circulo.calcularArea());
            System.out.printf("\n\t Perímetro: %.3f \n",circulo.calcularPerimetro());

        }catch(JAXBException exception){

            System.out.println("\n\t Error al deserializar...");
            System.out.println("\n\t Mensaje: "+exception.getMessage());

        }

    }


}
