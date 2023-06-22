class Ctrl_avis {
    constructor() {

        this.start();
    }

    start() {
        this.main = document.getElementById('avisView');


        wrk_avis.getTousAvis("https://gamberal01.emf-informatique.ch/javaService_Rest_1/webresources/Service1/getTousAvis");
    }

    showAvis(data) {

        this.main.innerHTML = "";
        data.forEach(listAvis => {


            let avisData = listAvis['avis']
            let usernameData = listAvis['username']
            let resultat = "avis : " + avisData + " | nom d'utilisateur : " + usernameData;





            var avisP = document.createElement('p');

            var br = document.createElement('br');
            avisP.innerHTML = resultat;



            $("#avisView").append(avisP);
            $("#avisView").append("<br/>");


        })


    }
}