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
                ctrl_film.currentPage = data.page;
                ctrl_film.nextPage = ctrl_film.currentPage + 1;
                ctrl_film.prevPage = ctrl_film.currentPage - 1;
                ctrl_film.totalPages = data.total_pages;

                ctrl_film.current.innerText = ctrl_film.currentPage;

                if (ctrl_film.currentPage <= 1) {
                    ctrl_film.prev.classList.add('disabled');
                    ctrl_film.next.classList.remove('disabled')
                } else if (ctrl_film.currentPage >= ctrl_film.totalPages) {
                    ctrl_film.prev.classList.remove('disabled');
                    ctrl_film.next.classList.add('disabled')
                } else {
                    ctrl_film.prev.classList.remove('disabled');
                    ctrl_film.next.classList.remove('disabled')
                }

                ctrl_film.tagsEl.scrollIntoView({
                    behavior: 'smooth'
                })

            } else {
                ctrl_film.main.innerHTML = `<h1 class="no-results">No Results Found</h1>`
            }

        })

    }
}