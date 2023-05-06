/*
  But : Worker de la page avis.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/
class Wrk_avis {
    constructor() {
    }

    getTousAvis(url) {

        fetch(url)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                if (data.length !== 0) {
                    ctrl_avis.showAvis(data);


                } else {
                    alert("erreur lors du chargement des avis");
                }

            })

    }




}