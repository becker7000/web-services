package mx.com.cst.webapp.jaxrs.control;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.com.cst.webapp.jaxrs.model.Libro;
import mx.com.cst.webapp.jaxrs.service.LibroService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/libros")
@Produces(MediaType.APPLICATION_JSON)
public class LibrosRestController {

    @Inject
    private LibroService libroService;

    @GET
    public List<Libro> listar(){
        return libroService.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id){
        Optional<Libro> libroOptional = libroService.porId(id);
        if(libroOptional.isPresent()){
            return Response.ok(libroOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Libro libro){
        try{
            Libro nuevoLibro = libroService.guardar(libro);
            return Response.ok(nuevoLibro).build();
        }catch (Exception exception){
            exception.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") int id, Libro libro){
        Optional<Libro> libroOptional = libroService.porId(id);
        if(libroOptional.isPresent()){
            Libro nuevoLibro = libroOptional.get();
            nuevoLibro.setTitulo(libro.getTitulo());
            nuevoLibro.setAutor(libro.getAutor());
            nuevoLibro.setPrecio(libro.getPrecio());
            try{
                libroService.guardar(nuevoLibro);
                return Response.ok(nuevoLibro).build();
            }catch (Exception exception){
                exception.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        Optional<Libro> libroOptional = libroService.porId(id);
        if(libroOptional.isPresent()){
            try{
                libroService.eliminar(libroOptional.get().getId());
                return Response.noContent().build();
            }catch (Exception exception){
                exception.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
