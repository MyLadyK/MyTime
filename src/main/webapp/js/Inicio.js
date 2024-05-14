window.onload = function() {
    document.getElementById('Login').addEventListener('submit', function(event) {
        event.preventDefault();

        var correo = document.getElementsByName('correo')[0].value;
        var contrasena = document.getElementsByName('contrasena')[0].value;
        

        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'Sesion', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
    var permiso = this.getResponseHeader("permiso");
    if (permiso === "supervisor") {
        window.location.href = "/My_Time/PerfilSupervisor.html";
    } else if (permiso === "trabajador") {
        window.location.href = "/My_Time/PerfilTrabajador.html";
    }
} else if (this.readyState === XMLHttpRequest.DONE) {
    alert("Error al iniciar sesión");
            }
        }
        xhr.send("correo=" + correo + "&contrasena=" + contrasena);
    });
};
