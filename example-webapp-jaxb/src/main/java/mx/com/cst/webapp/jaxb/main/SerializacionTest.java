package mx.com.cst.webapp.jaxb.main;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import mx.com.cst.webapp.jaxb.model.Circulo;

import java.io.File;

public class SerializacionTest {

    public static void main(String[] args){

        try{

            // Crear un objeto Java (Circulo)
            Circulo circulo = new Circulo(10);

            JAXBContext contexto = JAXBContext.newInstance(Circulo.class);

            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            // Generamos el archivo de salida:
            File archivo = new File("circulo.xml");

            // Serializamos el objeto circulo
            marshaller.marshal(circulo,archivo);

            System.out.println("\n\t El objeto de la clase Circulo ha sido serializado a XML");
            System.out.println("\n\t Ruta: "+archivo.getAbsolutePath());

        }catch (JAXBException exception){
            System.out.println("\n\t Error al serializar el objeto de Circulo");
            System.out.println("\n\t Mensaje: "+exception.getMessage());
        }

    }

}
