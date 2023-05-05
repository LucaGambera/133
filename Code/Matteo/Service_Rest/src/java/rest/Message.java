/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import beans.Users;
import com.google.gson.Gson;
import java.util.ArrayList;
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
    //ok
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

    //ok
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

    //ok
    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@QueryParam("username") String username) {
        Gson gson = new Gson();
        String json = "{\"result\": false}";
        Users user = wrkdb.getUser(username);
        if (user != null) {
            json = gson.toJson(user);

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

    //ok
    @POST
    @Path("CheckLogin")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String checkLogin(@FormParam("USERNAME") String username, @FormParam("PASSWORD") String password) {
<<<<<<< HEAD

        String result;
        if (wrkdb.checkLogin(username, password)) {
            result = "OK";

        } else {
            result = "KO";
        }

        return result;
=======
        Gson builder = new Gson();
        String db = wrkdb.checkLogin(username, password);
        ArrayList<String> resultat = new ArrayList<>();
        String toJson = builder.toJson(db);
        return "{\"user\":" + toJson + "}";
>>>>>>> 0503e7c4701e05dff553d0c73daa680022c0c648

    }

    //ok
    @DELETE
    @Path("DeleteAvis")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String deleteMembre(@FormParam("PK_Avis") int PK) {
        String retour;
        if (wrkdb.deletAvis(PK)) {
            retour = "OK";
        } else {
            retour = "KO";
        }
        return retour;
    }
    

}
