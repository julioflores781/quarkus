package org.acme.services;


import org.acme.entity.Empleado;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Empleado")
@Produces(MediaType.APPLICATION_JSON)
public class EmpleadoApi {



    @GET
    public Response doGet(){
        List<Empleado> empleados =Empleado.findAll().list();
        return Response.ok(empleados).build();
    }


        @GET
        @Path("{id}")
        public Response doGetId(@PathParam("id") Long id){
            Empleado empleado =  Empleado.findById(id);
            return Response.ok(empleado).build();
        }

        @POST
        @Transactional
        public Response doPost(Empleado request){

                Empleado empleado = new Empleado(request.getEmpleado_id(), request.getNombre(), request.getApellido(), request.getPuesto_id(), request.getEditorial_id(), request.getFecha_ingreso());

                System.out.println(empleado.toString());


                empleado.persist();
        return Response.ok(empleado).build();
        }


        @PUT
        @Path("{id}")
        @Transactional
        public Response update( @PathParam("id") Long id,Empleado request){
        Empleado empleado =  Empleado.findById(id);


            if (empleado ==null) {
                throw new WebApplicationException("Id inexistente",404);
            }
            empleado.setEmpleado_id(request.getEmpleado_id());
            empleado.setNombre(request.getNombre());
            empleado.setApellido(request.getApellido());
            empleado.setFecha_ingreso(request.getFecha_ingreso());
            empleado.setPuesto_id(request.getPuesto_id());
            empleado.setEditorial_id(request.getEditorial_id());


                empleado.persist();
            return  Response.ok(empleado).build();



        }


        @DELETE
        @Path("{id}")
        @Transactional
        public Response delete( @PathParam("id") Long id){
        Empleado empleado =  Empleado.findById(id);


            if (empleado ==null) {
                throw new WebApplicationException("Id inexistente",404);
            }
                empleado.delete();
            return  Response.ok("Se elimino Correctamente").build();



        }



}
