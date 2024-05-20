window.onload = function() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "DatosPerfil", true);
     xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var usuario = JSON.parse(xhr.responseText);
                    document.getElementById('dni').textContent = usuario.dni;
                    document.getElementById('puesto').textContent = usuario.puesto;
                    document.getElementById('nombre').textContent = usuario.nombre;
                    document.getElementById('apellido1').textContent = usuario.apellido1;
                    document.getElementById('apellido2').textContent = usuario.apellido2;
                    document.getElementById('correo').textContent = usuario.correo;
                    document.getElementById('telefono').textContent = usuario.telefono;
                } catch (e) {
                    console.error("Error parsing JSON response: ", e);
                    alert("Error al cargar los datos del usuario 1.");
                }
            } else {
                console.error("Failed to load user data, status: " + xhr.status);
                alert("Error al cargar los datos del usuario 2.");
            }
        }
    };
    xhr.send();
};
