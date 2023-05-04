class Ctrl_avis {
    constructor() {

        this.start()
    }

    start() {
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
            const avisEL = document.createElement('div');
            avisEL.class = "avis";


            var avisss = document.createElement("p");
            avisss.innerHTML = avis






            avisEL.appendChild(avisss)



            $("#avis").append(avisEL);
        })
    }
}