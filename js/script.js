const form = document.getElementById("formulario");
form.addEventListener("submit", (e) => {

    e.preventDefault();
    const user = document.getElementById("user").value;
    const password = document.getElementById("password").value;
    if (user === "ademar" && password === "123456") {
        window.alert("vc esta acessando o google");
        window.location.href = "https://www.google.com";

    }

});
