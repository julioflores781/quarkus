package org.acme;

import io.smallrye.common.constraint.NotNull;
import org.acme.entity.Persona;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/persona")
public class PersonaApi {

    private static List<Persona>  personas = new ArrayList<>();



    Persona julio = new Persona("Julio","Flores");

    Persona juliet = new Persona("juliet","Flores");
    Persona joharlis = new Persona("joharlis","zarraga");
    Persona alejandro = new Persona("alejandro","Medina");



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonas() {
        List<Persona>  personas = Persona.findAll().list();
        return Response.ok(personas).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(@NotNull Persona persona) {

        Persona persona1 = new Persona(persona.getNombre(), persona.getApellido());
        persona1.persist();


        return Response.ok(persona1).build();
    }
}
