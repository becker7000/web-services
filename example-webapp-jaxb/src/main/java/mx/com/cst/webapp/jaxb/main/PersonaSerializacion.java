package mx.com.cst.webapp.jaxb.main;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import mx.com.cst.webapp.jaxb.model.Persona;

import java.io.File;

public class PersonaSerializacion {

    public static void main(String[] args) {

        try{

            Persona persona = new Persona("Carlos", 25);
            JAXBContext contexto = JAXBContext.newInstance(Persona.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            File archivo = new File("persona.xml");
            marshaller.marshal(persona,archivo);
            System.out.println("\n\t Objeto de la clase Persona serializado");
            System.out.println("\n\t Ruta: "+archivo.getAbsolutePath());

        } catch (JAXBException exception){

            System.out.println("\n\t Error al serializar un objeto de la clase Persona");
            System.out.println("\n\t Mensaje: "+exception.getMessage());
        }
    }

}
