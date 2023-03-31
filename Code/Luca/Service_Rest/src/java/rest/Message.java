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
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author gamberal01
 */
@Path("Service2")
public class Message {

    private static final String API_KEY = "api_key=eb482103d8c607c29a702217d8ad491a";
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String API_URL = BASE_URL + "/discover/movie?sort_by=popularity.desc&"+ API_KEY +"&language=fr-FR";

    /**
     * const API_KEY = 'api_key=eb482103d8c607c29a702217d8ad491a';
     * const BASE_URL = 'https://api.themoviedb.org/3';
     * const API_URL = BASE_URL + '/discover/movie?sort_by=popularity.desc&' + API_KEY + '&language=fr-FR';
     
     */
    @Context
    private UriInfo context;

    private Client client;

    /**
     *
     * Creates a new instance of Message
     */
    public Message() {

    }

    /**
     * Retrieves representation of an instance of rest.Message
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Message
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    @GET
    @Path("getFilm")
    @Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public String getMessage() {
        String retourApi = "Test";

        return retourApi;
    }

}
