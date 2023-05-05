/*
  But : Worker de la page index.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/
class Wrk_index {

    constructor() {
        console.log("je suis la");
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
            dataType: "text",
            data: "action=logout",
            url: "https://gamberal01.emf-informatique.ch/javaGateway/GatewayServlet",
            success: successCallback,
        });
    }

    login(username, password, sucesscallback, erroCallback) {
        $.ajax({
            type: "POST",
            dataType: "text",
            data: "action=login&username=" + username + "&password=" + password,
            url: "https://gamberal01.emf-informatique.ch/javaGateway/GatewayServlet",
            success: successCallback,
            error: errorCallBack,

        });
    }



}