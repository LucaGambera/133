/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * REST Web Service
 *
 * @author gamberal01
 */
@Path("Service2")
public class Message {

    private static final String API_KEY = "api_key=eb482103d8c607c29a702217d8ad491a";
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String API_URL = BASE_URL + "/discover/movie?sort_by=popularity.desc&" + API_KEY + "&language=fr-FR&page=1";

    /**
     * const API_KEY = 'api_key=eb482103d8c607c29a702217d8ad491a'; const
     * BASE_URL = 'https://api.themoviedb.org/3'; const API_URL = BASE_URL +
     * '/discover/movie?sort_by=popularity.desc&' + API_KEY + '&language=fr-FR';
     *
     */
    @Context
    private UriInfo context;
    private WebTarget webTarget;
    private Client client;

    /**
     *
     * Creates a new instance of Message
     */
    public Message() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(API_URL);
    }

    /**
     * Retrieves representation of an instance of rest.Message
     *
     * @return an instance of java.lang.String
     */
    /**
     * Creates a new instance of Message
     */
    /**
     * Retrieves representation of an instance of rest.Message
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getFilms")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getFilms() {
        String retourApi = "Test";
        WebTarget ressource = webTarget;
        retourApi = ressource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("Accept-Charset", "UTF-8").get(String.class);
        return retourApi;
    }


}
