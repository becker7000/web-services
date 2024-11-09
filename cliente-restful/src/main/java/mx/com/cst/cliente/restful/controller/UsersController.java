package mx.com.cst.cliente.restful.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.RequestScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.com.cst.cliente.restful.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Named(value = "usersController")
@RequestScoped
public class UsersController {

    private List<User> listaUsuarios;

    @PostConstruct
    public void init() {
        listaUsuarios = new ArrayList<>();
        obtenerUsuarios();
    }

    public void obtenerUsuarios() {

        // Creamos un cliente
        Client client = ClientBuilder.newClient();

        // Fijamos la URL de la solicitud HTTP
        WebTarget target = client.target("https://randomuser.me/api?results=4"); // Obtener 1 usuario

        // Realizamos la solicitud GET
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        // Verificamos si la respuesta es correcta
        if (response.getStatus() == 200) {

            // Leer el cuerpo de la respuesta como un mapa genérico
            Map<String, Object> jsonResponse = response.readEntity(new GenericType<Map<String, Object>>() {
            });

            // Obtener la lista de usuarios
            List<Map<String, Object>> users = (List<Map<String, Object>>) jsonResponse.get("results");

            // Iterar sobre la lista de usuarios y mostrar los datos

            for (Map<String, Object> user : users) {

                User user_aux = new User();

                Map<String, Object> photo = (Map<String, Object>) user.get("picture");
                //System.out.println("Foto: " + photo.get("large"));
                // Ajustamos la url de la foto como string
                user_aux.getPicture().setLarge(photo.get("large").toString());
                //System.out.println("Foto: " + user_aux.getPicture().getLarge());

                // Suponiendo que 'name' es un mapa que contiene los campos 'first' y 'last'
                Map<String, Object> name = (Map<String, Object>) user.get("name");
                //System.out.println("Nombre: " + name.get("first"));
                // Ajustamos el primer nombre como String
                user_aux.getName().setFirst(name.get("first").toString());
                //System.out.println("Nombre: " + user_aux.getName().getFirst());

                //System.out.println("Nombre: " + user.get("name"));
                //System.out.println("Email: " + user.get("email"));
                // Ajustamos el email que es un campo directo
                user_aux.setEmail(user.get("email").toString());
                //System.out.println("Email: " + user_aux.getEmail());

                //System.out.println("Teléfono: " + user.get("phone"));
                // Ajustamos el phone que es un campo directo
                user_aux.setPhone(user.get("phone").toString());
                //System.out.println("Teléfono: " + user_aux.getPhone());

                // Ajustamos el genero que es un campo directo
                //System.out.println("Género: " + user.get("gender"));
                user_aux.setGender(user.get("gender").toString());
                //System.out.println("Género: " + user_aux.getGender());
                //System.out.println("------------------------------------------------");

                listaUsuarios.add(user_aux);

            }

        } else {
            System.out.println("Error al obtener datos. Status: " + response.getStatus());
        }
        client.close();

    }

    public List<User> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<User> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
