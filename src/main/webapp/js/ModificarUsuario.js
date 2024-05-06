

window.onload = function() {
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
