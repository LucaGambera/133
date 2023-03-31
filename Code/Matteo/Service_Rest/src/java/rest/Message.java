/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author LeonettiM
 */
@Path("Service1")
public class Message {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Message
     */
    public Message() {
    }

    /**
     * Retrieves representation of an instance of rest.Message
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getUser")
    @Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public String getMessage() {
        return "Bonjour tout le monde !";
    }
}
