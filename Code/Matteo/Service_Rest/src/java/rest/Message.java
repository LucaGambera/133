/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import workers.WrkDB;

/**
 * REST Web Service
 *
 * @author LeonettiM
 */
@Path("Service1")
public class Message {

    @Context
    private UriInfo context;
    private WrkDB wrkdb;

    /**
     * Creates a new instance of Message
     */
    public Message() {
        wrkdb = new WrkDB("3306", "mydb");
    }

    /**
     * Retrieves representation of an instance of rest.Message
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getAvis")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAvis() {
        Gson gson = new Gson();
        String json;
        try {
            json = gson.toJson(wrkdb.getAvis());
        } catch (Exception e) {
            json = gson.toJson("error");
        }
        return json;
    }

    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@QueryParam("PK") int pk) {
        Gson gson = new Gson();
        String json;
        try {
            json = gson.toJson(wrkdb.getUser(pk));
        } catch (Exception e) {
            json = gson.toJson("error");
        }
        return json;
    }
}
