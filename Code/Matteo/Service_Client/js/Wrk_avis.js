/*
  But : Worker de la page avis.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/
class Wrk_avis {
    constructor() {
    }

    getAvis(url) {
        console.log("lifdskjnoifds");
        fetch(url)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                if (data.length !== 0) {
                    ctrl_avis.showAvis(data);


                } else {
                    ctrl_avis.innerHTML = `<h1 class="no-results">No Results Found</h1>`
                }

            })

    }

}