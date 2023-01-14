package org.acme;

import org.acme.entity.Persona;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/persona")
public class PersonaApi {

    private static List<Persona>  personas = new ArrayList<>();



    Persona julio = new Persona("95742604","Julio","Flores");



    Persona juliet = new Persona("55742604","juliet","Flores");
    Persona joharlis = new Persona("95830925","joharlis","zarraga");
    Persona alejandro = new Persona("95555555","alejandro","Medina");



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonas() {

    personas.add(julio);
    personas.add(juliet);
    personas.add(joharlis);
    personas.add(alejandro);
        return Response.ok(personas).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPersonas() {

        Persona Carolina = new Persona("111111","Carolina","Arnal");


        return Response.ok(personas.add(Carolina)).build();
    }
}
