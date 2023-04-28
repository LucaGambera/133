/*
  But : Contrôleur de la page film.html
  Auteur : Simon Losey
  Date :   08.06.2022 / V1.0
*/

/* 
constantes de la classe Ctrl_film
*/
const API_KEY = 'api_key=1cf50e6248dc270629e802686245c2c8';
const BASE_URL = 'https://api.themoviedb.org/3';
const API_URL = BASE_URL + '/discover/movie?sort_by=popularity.desc&' + API_KEY + '&language=fr-FR';
const IMG_URL = 'https://image.tmdb.org/t/p/w500';
const searchURL = BASE_URL + '/search/movie?' + API_KEY + '&language=fr-FR';

class Ctrl_film {

    /* 
    variables de la classe Ctrl_film
    */


    form = 0;
    search = 0;
    tagsEl = 0;
    main = 0;

    prev = 0;
    next = 0;
    current = 0;

    currentPage = 1;
    nextPage = 2;
    prevPage = 3;
    lastUrl = '';
    totalPages = 100;



    constructor() {

    }


    /** Mets en place la page film.html et écouteurs
     * 
     */
    start() {
        this.tagsEl = document.getElementById("tags");
        this.main = document.getElementById('main');
        this.form = document.getElementById('form');
        this.search = document.getElementById('search');

        this.prev = document.getElementById('prev')
        this.next = document.getElementById('next')
        this.current = document.getElementById('current')

        wrk_film.getMovies("https://gamberal01.emf-informatique.ch/javaDouanier/GatewayServlet?action=getFilms&PAGE=1");
        var form = document.getElementById('form');
        var prev = document.getElementById('prev')
        var next = document.getElementById('next')
        var film = document.getElementById('film')


        form.addEventListener('submit', (e) => {
            e.preventDefault();

            const searchTerm = this.search.value;

            if (searchTerm) {
                wrk_film.getMovies(searchURL + '&query=' + searchTerm)
            } else {
                wrk_film.getMovies("https://gamberal01.emf-informatique.ch/javaDouanier/GatewayServlet?action=getFilms&PAGE=" + this.currentPage);
            }

        })

        film.addEventListener('click', () => {
            ctrl_index.loadFilm();
        })



        prev.addEventListener('click', () => {
            if (this.prevPage > 0) {
                this.pageCall(this.prevPage);
            }
        })

        next.addEventListener('click', () => {
            if (this.nextPage <= this.totalPages) {
                this.pageCall(this.nextPage);
            }
        })
    }
    /**affiche la page demandé
     * 
     * @param {*} page 
     */
    pageCall(page) {
        let url = "https://gamberal01.emf-informatique.ch/javaDouanier/GatewayServlet?action=getFilms&PAGE=" +page;
        this.getMovies(url);

    }




    /**affiche les films
     * 
     * @param {*} data 
     */
    showMovies(data) {
        this.main.innerHTML = '';

        data.forEach(movie => {
            const {
                title,
                poster_path,
                vote_average,
            } = movie;
            const movieEl = document.createElement('div');
            movieEl.classList.add('movie');
            movieEl.innerHTML = `
             <img src="${poster_path? IMG_URL+poster_path: "http://via.placeholder.com/1080x1580" }" alt="${title}">
            <div class="movie-info">
                <h3>${title}</h3>
                <span class="${this.getColor(vote_average)}">${vote_average}</span>
                
                </div>
            
        
        `

            this.main.appendChild(movieEl);
        })
    }

    /**donne la couleur de la note du film
     * 
     * @param {*} vote 
     * @returns 
     */
    getColor(vote) {
        if (vote >= 8) {
            return 'green'
        } else if (vote >= 5) {
            return "orange"
        } else {
            return 'red'
        }
    }

}