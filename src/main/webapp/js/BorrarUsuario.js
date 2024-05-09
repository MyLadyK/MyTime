function borrar(idSupervisor) {
    if (confirm('¿Desea eliminar al usuario?')) {
        fetch('EliminarUsuario?id=' + idSupervisor, {
            method: 'DELETE',
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            llamada();  // Actualiza la lista de usuarios después de eliminar
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }
}