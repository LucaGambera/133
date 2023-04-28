/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrk;

import beans.SimpleResponse;
import com.google.gson.Gson;
import help.ParameterStringBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author gamberal01
 */
public class Wrk {

    public Wrk() {

    }

    private String sendChangement(String url, String method, HashMap<String, String> data) {
        String result = "false";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(data));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String sendLire(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getFilms(int page) {
        return sendLire("https://gamberal01.emf-informatique.ch/javaService_Rest/webresources/Service2/getFilms?PAGE=" + page);
    }

    public String getAvis() {
        return sendLire("https://leonettim.emf-informatique.ch/javaService_Rest/webresources/Service1/getTousAvis");
    }

    public String addAvis(String avis, int idFilm, int pkUser) {
        String idFIlmString = "" + idFilm;
        String pkUserString = "" + pkUser;
        String lien = sendChangement("https://leonettim.emf-informatique.ch/javaService_Rest/webresources/Service1/Addavis", "POST", new HashMap<String, String>() {
            {
                put("avis", avis);
                put("idFilm", idFIlmString);
                put("pkUser", pkUserString);
            }
        });
        System.out.println(lien);

        return lien;
    }

}
