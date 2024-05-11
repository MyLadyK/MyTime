
window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var idUsuario = urlParams.get('id');
    console.log('idUsuario obtenido de la URL: ', idUsuario);
    document.getElementById('idUsuario').value = idUsuario;

    var botonVolver = document.getElementById('botonVolver');
    botonVolver.addEventListener('click', function() {
        window.location.href = 'ListaUsuario.html';
    });

    var formModificarUsuario = document.forms['ModificarUsuario'];
    formModificarUsuario.addEventListener('submit', function(event) {
        event.preventDefault();  

        if (!confirm('¿Desea guardar los cambios?')) {
            return;  // Confirmar los cambios
        }

        var data = {
            idSupervisor: formModificarUsuario.idUsuario.value,
            dni: formModificarUsuario.dni.value,
            puesto: formModificarUsuario.puesto.value,
            nombre: formModificarUsuario.nombre.value,
            apellido1: formModificarUsuario.apellido1.value,
            apellido2: formModificarUsuario.apellido2.value,
            correo: formModificarUsuario.correo.value,
            telefono: formModificarUsuario.telefono.value,
            permiso: formModificarUsuario.permiso.value
        };

        fetch(formModificarUsuario.action, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            window.location.href = 'ListaUsuario.html';  // Redirige a ListaUsuario
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    });
}
