package mx.com.cst.webapp.jaxb.main;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.com.cst.webapp.jaxb.model.Persona;

import java.io.File;

public class PersonaDeserializacion {

    public static void main(String[] args) {

        try{

            File archivo = new File("persona.xml");
            JAXBContext contexto = JAXBContext.newInstance(Persona.class);

            Unmarshaller unmarshaller = contexto.createUnmarshaller();

            Persona persona = (Persona) unmarshaller.unmarshal(archivo);

            System.out.println("\n\t Objeto de la clase Persona deserializado: ");
            System.out.println("\n\t Nombre: "+persona.getNombre());
            System.out.println("\n\t Edad: "+persona.getEdad());

        }catch (JAXBException exception){

            System.out.println("\n\t Error al deserializar un archivo XML ");
            System.out.println("\n\t Mensaje: "+exception.getMessage());

        }
    }

}
