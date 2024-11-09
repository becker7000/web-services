package mx.com.cst.webapp.cliente;

import mx.com.cst.webapp.jpa.service.LibroServicioWeb;
import mx.com.cst.webapp.jpa.service.LibroServicioWebImpService;

public class Main {

    public static void main(String[] args) {

        LibroServicioWeb libroServicioWeb =
                new LibroServicioWebImpService()
                        .getLibroServicioWebImpPort();

        libroServicioWeb.listar().forEach(
                l -> System.out.printf(
                        """
                            +-----------LIBRO-------------+
                            | Titulo: %s
                            | Autor: %s
                            | Precio: $ %.2f
                            +----------------------------+
                        """,l.getTitulo(),l.getAutor(),l.getPrecio()
                )
        );

    }
}