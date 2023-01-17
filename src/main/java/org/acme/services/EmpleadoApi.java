package org.acme.services;


import org.acme.entity.Empleado;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Empleado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoApi {



    @GET
    @Path("/All")
    public Response doGet(){
        List<Empleado> empleados =Empleado.findAll().list();
        return Response.ok(empleados).build();
    }


        @GET
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response doGetId(@PathParam("id") Long id){
            Empleado empleado =  Empleado.findById(id);
            return Response.ok(empleado).build();
        }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doPost(Empleado request){

            Empleado empleado = new Empleado(request.getEmpleado_id(), request.getNombre(), request.getApellido(), request.getPuesto_id(), request.getEditorial_id(), request.getFecha_ingreso());

            System.out.println(empleado.toString());


            empleado.persist();
    return Response.ok(empleado).build();
    }

        @DELETE
        @Produces(MediaType.APPLICATION_JSON)
        @Path("{id}")
        @Transactional
        public Response delete( @PathParam("id") Long id){

        Empleado empleado =  Empleado.findById(id);


        if (empleado !=null) {
                 Empleado.deleteById(id);
                Response.ok().build();
            }else {


            return Response.notModified().build();
        }


            return null;
        }



}
