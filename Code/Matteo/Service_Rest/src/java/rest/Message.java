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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
        wrkdb = new WrkDB("3306", "gamberal01_133");
    }

    /**
     * Retrieves representation of an instance of rest.Message
     *
     * @return an instance of java.lang.String
     */
    
    //nok
    @GET
    @Path("getTousAvis")
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
    
    //nok
    @GET
    @Path("getAvis")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUnAvis(@QueryParam("IDFILM") int id) {
        Gson gson = new Gson();
        String json;
        try {
            json = gson.toJson(wrkdb.getUnAvis(id));
        } catch (Exception e) {
            json = gson.toJson("error");
        }
        return json;
    }
    
    //nok
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
    
    //ok
    @POST
    @Path("Adduser")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addUsers(@FormParam("username") String user, @FormParam("password") String password) {
        String s;
        if (wrkdb.adduser(user, password)) {
            s = "OK";
        } else {
            s = "KO";
        }
        return s;
    }
    
    //ok
    @POST
    @Path("Addavis")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addAvis(@FormParam("avis") String avis, @FormParam("idfilm") int idfilm, @FormParam("fkuser") int fkuser) {
        String s;
        if (wrkdb.addAvis(avis, idfilm, fkuser)) {
            s = "OK";
        } else {
            s = "KO";
        }
        return s;
    }
    
    //nok
    @POST
    @Path("CheckLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkLogin(@FormParam("username") String username) {
        Gson builder = new Gson();
        String toJson = builder.toJson(wrkdb.checkLogin(username));
        return "{\"user\":" + toJson + "}";
    }

    //ok
    @DELETE
    @Path("DeleteAvis")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deleteMembre(@FormParam("PK_Avis") int PK) {
        String s;
        if (wrkdb.deletAvis(PK)) {
            s = "OK";
        } else {
            s = "KO";
        }
        return s;
    }

}
