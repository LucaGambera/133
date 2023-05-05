/*
  But : Contrôleur de la page avis.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/
class Ctrl_avis {
    constructor() {

        this.start()
    }

    start() {

        this.mySuperButton = $("#mySuperButton");
        this.main2 = $("#avis");
    }

    showAvis(data) {
        console.log(this.main2)
        this.main2.innerHTML = "";
        data.forEach(aviss => {
            let pkavis = aviss['pKAvis']
            console.log(pkavis);
            let avis = aviss['avis']
            console.log(avis)
            let idFilm = aviss['idFilm']
            console.log(idFilm)
            let fKUsers = aviss['fKUsers']
            console.log(fKUsers)
            //const avisEL = document.createElement('div');
            //avisEL.class = "avis";


            var avisss = document.createElement('p');
            var br = document.createElement('br');
            avisss.innerHTML = avis


            //avisEL.appendChild(avisss)


            $("#avis").append(avisss);
            $("#avis").append("<br/>");

            //insertBefore(br, avisEL);
        })

    }

    ajoutAvis() {

        const myInput = document.getElementById('avis');
        const inputContent = myInput.value;
        console.log('Contenu de la zone de texte :', inputContent, "id FIlm", ctrl_index.idFilm);
        wrk_avis.addAvis(inputContent, this.ajoutSuccessCallBack, this.ajoutErroCallBack);
    }
    ajoutSuccessCallBack(){
        alert("L'avis a été ajouter");
        window.location.href = "index.html";

    }
    ajoutErroCallBack(){
        alert("L'avis n'a pa pu être ajouter");
    }
}