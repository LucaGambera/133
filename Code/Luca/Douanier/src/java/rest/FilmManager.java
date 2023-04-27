/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author gamberal01
 */
public class FilmManager {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://gamberal01.emf-informatique.ch/javaService_Rest/webresources";
    
    public FilmManager(){
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Service2");
    }
    public String getFilms(){
        return webTarget.path("getFilms").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }
}
