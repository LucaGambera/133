/*
  But : Worker de la page index.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/
var BASE_URL = "https://gamberal01.emf-informatique.ch/javaGateway/GatewayServlet";
class Wrk_index {

    constructor() {
    }

    /**affiche la vue demandée
     *
     * @param {*} vue
     * @param {*} callback -
     */
    chargerVue(vue, callback) {

        // charger la vue demandee
        $("#view").load("views/" + vue + ".html", function () {

            // si une fonction de callback est spécifiée, on l'appelle ici
            if (typeof callback !== "undefined") {
                callback();
            }

        });
    }

    disconnect(successCallback, errorCallback) {
        $.ajax({
            type: "POST",
            dataType: "json",
            data: "action=logout",
            url: BASE_URL,
            xhrFields: {
                withCredentials: true,
            },
            async: false,
            crossDomain: true,
            success: successCallback,
        });
    }

    login(username, password, sucesscallback, erroCallback) {
        $.ajax({
            type: "POST",
            dataType: "json",
            data: "action=login&username=" + username + "&password=" + password,
            url: BASE_URL,
            xhrFields: {
                withCredentials: true,
            },
            async: false,
            crossDomain: true,
            success: sucesscallback,
            error: erroCallback,

        });
    }
    sinscrire(username, password, sucesscallback, erroCallback){
        $.ajax({
            type: "POST",
            dataType: "json",
            data: "action=adduser&username=" + username + "&password=" + password,
            url: BASE_URL,
            xhrFields: {
                withCredentials: true,
            },
            async: false,
            crossDomain: true,
            success: sucesscallback,
            error: erroCallback,

        });
    }



}