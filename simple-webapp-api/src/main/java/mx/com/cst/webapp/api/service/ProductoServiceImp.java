package mx.com.cst.webapp.api.service;

import mx.com.cst.webapp.api.model.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImp implements ProductoService {

    @Override
    public List<Producto> listarProductos(){
        return Arrays.asList(
                new Producto(1,"Coca-cola","Refresco",35.5),
                new Producto(2,"Oreo","Galletas",19.5),
                new Producto(3,"Sabritas","Botana",17.5),
                new Producto(4,"Boing","Jugo",14.5),
                new Producto(5,"Donas","Pan",18.5),
                new Producto(6,"Ruffles","Botana",19.5),
                new Producto(7,"Emperador","Galletas",24.5)
        );
    }

}
