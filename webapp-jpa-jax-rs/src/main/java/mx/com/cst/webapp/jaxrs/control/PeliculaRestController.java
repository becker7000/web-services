package mx.com.cst.webapp.jaxrs.control;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.com.cst.webapp.jaxrs.model.Pelicula;
import mx.com.cst.webapp.jaxrs.service.PeliculaService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/peliculas")
@Produces(MediaType.APPLICATION_JSON)
@JsonPropertyOrder({"id", "titulo", "anio_lanzamiento", "genero", "duracion"}) // PROBAR AL FINAL con JACKSON-FASTER
public class PeliculaRestController {

    @Inject
    private PeliculaService peliculaService;

    @GET
    public List<Pelicula> listar(){
        return peliculaService.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") int id){
        Optional<Pelicula> peliculaOptional = peliculaService.porId(id);
        if(peliculaOptional.isPresent()){
            // Enviamos la pelicula por el response
            return Response.ok(peliculaOptional.get()).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Pelicula pelicula){
        try{
            Pelicula peliculaNueva = peliculaService.guardar(pelicula);
            return Response.ok(peliculaNueva).build();
        }catch (Exception exception){
            exception.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") int id,Pelicula pelicula){
        Optional<Pelicula> peliculaOptional = peliculaService.porId(id);
        if(peliculaOptional.isPresent()){
            Pelicula peliculaNueva = peliculaOptional.get();
            peliculaNueva.setTitulo(pelicula.getTitulo());
            peliculaNueva.setAnioLanzamiento(pelicula.getAnioLanzamiento());
            peliculaNueva.setGenero(pelicula.getGenero());
            peliculaNueva.setDuracion(pelicula.getDuracion());
            try {
                peliculaService.guardar(peliculaNueva);
                return Response.ok(peliculaNueva).build();
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
        Optional<Pelicula> peliculaOptional = peliculaService.porId(id);
        if(peliculaOptional.isPresent()){
            try{
                peliculaService.eliminar(peliculaOptional.get().getId());
                return Response.noContent().build();
            }catch (Exception exception){
                exception.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
