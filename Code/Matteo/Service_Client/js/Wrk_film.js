/*
  But : workeur de la page film.html
  Auteur : Simon Losey
  Date :   16.06.2022 / V1.0
*/
class Wrk_film {
    constructor() {}

    /**Va chercher les films selon la demande
     * 
     * @param {*} url 
     */
    getMovies(url) {
        ctrl_film.lastUrl = url;
        fetch(url).then(res => res.json()).then(data => {
            console.log(data.results)
            if (data.results.length !== 0) {
                ctrl_film.showMovies(data.results);




            } else {
                ctrl_film.main.innerHTML = `<h1 class="no-results">No Results Found</h1>`
            }

        })

    }
}