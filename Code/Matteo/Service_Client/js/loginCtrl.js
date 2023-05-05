/*
  But : Contrôleur de la page login.html
  Auteur : Matteo Leonetti
  Date :   05.05.2023 / V1.0
*/
const myButton = document.getElementById('login');
const myButtonInscription = document.getElementById('')
myButton.addEventListener('click', function() {
    login(document.getElementById("user").value,document.getElementById("password").value, loginSuccess, loginError);

});


function loginError(request, status, error) {
    alert("Erreur lors du login");
    
}

function loginSuccess(data, text, jqXHR) {
    if ($(data).find("result").text() == 'true')
    {
        //alert("Login ok");
        //const login = document.getElementById('logina');
        //login.innerHTML = $(data).find("user").text();
        window.location.replace("index.html");

    }
    else{
        alert("Erreur lors du login");
    }
}

$(document).ready(function () {
    $.getScript("js/services/servicesHttp.js", function () {
        console.log("servicesHttp.js chargé !");
    });
});