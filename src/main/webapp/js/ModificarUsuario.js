
window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var idSupervisor = urlParams.get('id');
    console.log('idSupervisor obtenido de la URL: ', idSupervisor);
    document.getElementById('idSupervisor').value = idSupervisor;

    var botonVolver = document.getElementById('botonVolver');
    botonVolver.addEventListener('click', function() {
        window.location.href = 'ListaUsuario.html';
    });

    var formModificarUsuario = document.forms['ModificarUsuario'];
    formModificarUsuario.addEventListener('submit', function(event) {
        event.preventDefault();  // Evita que el formulario se envíe de la manera predeterminada

        if (!confirm('¿Desea guardar los cambios?')) {
            return;  // Si el usuario no confirma, no hagas nada
        }

        var data = {
            idSupervisor: formModificarUsuario.idSupervisor.value,
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
            window.location.href = 'ListaUsuario.html';  // Redirige después de que la solicitud se haya completado con éxito
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    });
}






/* Con método doPost, que no modifica

window.onload = function() {
	
	var urlParams = new URLSearchParams(window.location.search);
	var idSupervisor = urlParams.get('id');
	
	console.log('idSupervisor obtenido de la URL: ', idSupervisor);

    document.getElementById('idSupervisor').value = idSupervisor;
    
    
    // Obtén el botón por su id
    var botonVolver = document.getElementById('botonVolver');

    // Añade un event listener para el evento click
    botonVolver.addEventListener('click', function() {
        window.location.href = 'ListaUsuario.html';
    });

    // Obtén el formulario por su nombre
    var formModificarUsuario = document.forms['ModificarUsuario'];

    // Añade un event listener para el evento submit
    formModificarUsuario.addEventListener('submit', function() {
        return confirm('¿Desea guardar los cambios?');
    });
}
*/