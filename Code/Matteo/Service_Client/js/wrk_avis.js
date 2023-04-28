class Wrk_avis {
    constructor() {
    }
    getAvis(url) {
        ctrl_film.lastUrl = url;
        fetch(url).then(res => res.json()).then(data => {
            console.log(data.results)
            if (data.results.length !== 0) {
                ctrl_avis.showMovies(data.results);




            } else {
                ctrl_film.main.innerHTML = `<h1 class="no-results">No Results Found</h1>`
            }

        })

    }
}