$().ready(function () {
    wrk_index = new Wrk_index();
    wrk_avis = new Wrk_avis();
    window.ctrl_index = new Ctrl_index();
    ctrl_avis = new Ctrl_avis();
    ctrl_index.loadAvis();

});

class Ctrl_index {
    constructor() {

    }
    loadAvis() {
        wrk_index.chargerVue("avis", function () {
            ctrl_avis.start();
        });
        console.log("charger")
    }
}