/*
  But : Contrôleur de la page index.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/

/**executer au debut
 * 
 */
$().ready(function () {
    wrk_film =new Wrk_film();


    wrk_index = new Wrk_index();
    wrk_avis = new Wrk_avis();
    ctrl_index = new Ctrl_index();
    ctrl_index.loadFilm();
    ctrl_film = new Ctrl_film();
    ctrl_avis = new Ctrl_avis();

});

class Ctrl_index {

    /**constructeur de cette classe
     * 
     */
    constructor() {
        this.langue = "fr";
        this.idFilm = 0;
    }

    /**charge la vue film
     * 
     */
    loadFilm() {
        wrk_index.chargerVue("film", function () {
            ctrl_film.start();
        });
        console.log("charger")
    }
    disconnect(){
        wrk_index.disconnect(this.successDisconnect);
    }
    successDisconnect(data){
        if(data.result == true){
            alert("Déconnexion réussie");
        }else{
            alert("Erreur lors de la déconnexion");
        }
    }
    login(){
        wrk_index.login(username, password,this.successCallback, this.erroCallback);
    }
    successCallback(){
        alert("Login réussi");
    }
    erroCallback(){
        alert("problème login");
    }


}