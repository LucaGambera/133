/*
  But : Worker la page index.html    
  Auteur : Simon Losey
  Date :   08.06.2022 / V1.0
*/
class Wrk_index {

  constructor() {
    console.log("je suis la");
  }
  /**affiche la vue demandée
   * 
   * @param {*} vue 
   * @param {*} callback 
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

}