/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctrl;

import wrk.Wrk;

/**
 *
 * @author gamberal01
 */
public class Ctrl {

    private Wrk refWrk;

    public Ctrl(Wrk refWrk) {
        this.refWrk = refWrk;
    }

    public String getTousAvis() {
        return refWrk.getTousAvis();
    }
    public String getAvis(int idFilm){
        return refWrk.getAvis(idFilm);
    }

    public String getFilms(int page) {
        return refWrk.getFilms(page);

    }

    public boolean login(String username, String password) {
        return refWrk.login(username, password);
    }

    public String addAvis(String avis, int idFilm, int pkUser) {
        return refWrk.addAvis(avis, idFilm, pkUser);
    }

}
