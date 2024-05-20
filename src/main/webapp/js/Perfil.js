window.onload = function() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "DatosPerfil", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            var usuario = JSON.parse(xhr.responseText);
            document.getElementById('dni').textContent = usuario.dni;
            document.getElementById('puesto').textContent = usuario.puesto;
            document.getElementById('nombre').textContent = usuario.nombre;
            document.getElementById('apellido1').textContent = usuario.apellido1;
            document.getElementById('apellido2').textContent = usuario.apellido2;
            document.getElementById('correo').textContent = usuario.correo;
            document.getElementById('telefono').textContent = usuario.telefono;
            
        }
    };
    xhr.send();
};
