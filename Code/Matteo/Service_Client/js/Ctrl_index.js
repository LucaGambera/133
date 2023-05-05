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
    window.ctrl_index = new Ctrl_index();
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
        const username = document.getElementById('username');
        const inputusername = username.value;
        const password = document.getElementById('password');
        const inputpassword = password.value;
        wrk_index.login(inputusername, inputpassword,this.successCallback, this.erroCallback);


    }
    sinscrire(){
        const username = document.getElementById('usernameInscription');
        const inputUser = username.value;
        const password = document.getElementById('passwordInscription');
        const inputPassword = password.value;
        wrk_index.sinscrire(inputUser, inputPassword, this.successCallbacksinscrire, this.erroCallbacksinscrire)
    }
    successCallback(data){
        if(data.result == true){
            alert("Login réussi");
            ctrl_index.loadFilm();
        }
    }
    erroCallback(){
        alert("problème login");
    }


    successCallbacksinscrire(data){
        if(data.result == true){
            alert("Inscription réussi");
            ctrl_index.loadFilm();
        }else {
            alert("problème inscription");
        }
    }
    erroCallbacksinscrire(){
        alert("problème inscription");
    }
}