/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.demohalloween.business;


import com.flecharoja.demohalloween.model.Clientes;
import com.flecharoja.demohalloween.pojo.Cliente;
import com.flecharoja.demohalloween.service.ClientesService;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Codecr
 */
@Path("clientes")
public class ClientesResources {

    @EJB
    ClientesService service;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Cliente c) {

        Clientes cliente = new Clientes();
        cliente.setId(c.getId());
        cliente.setNombre(c.getNombre());
        cliente.setApellido1(c.getApellido1());
        cliente.setApellido2(c.getApellido2());

        service.add(cliente);

        return Response.status(Response.Status.OK).build();

    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(service.getAll()).build();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        try {
            Clientes c = service.find(id);
            JsonObject json = Json.createObjectBuilder()
                    .add("nombre", c.getNombre())
                    .build();

            return Response.ok(json).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
