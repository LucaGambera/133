/*
  But : Contôleur de la page index.html    
  Auteur : Simon Losey
  Date :   08.06.2022 / V1.0
*/

/**executer au debut
 * 
 */
$().ready(function () {
    wrk_film =new Wrk_film();


    wrk_index = new Wrk_index();
    ctrl_index = new Ctrl_index();
    ctrl_index.loadFilm();
    ctrl_film = new Ctrl_film();
});

class Ctrl_index {

    /**constructeur de cette classe
     * 
     */
    constructor() {
        this.langue = "fr";
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

    /**charge la vue map
     * 
     */


}