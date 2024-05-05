function llamada(){
	 fetch('ListarUsuario')
	 .then(response => response.json())		 
	 .then(data => listarTablaParcial(data));  	
	 
 }
 
 function listarTablaParcial(datos){
    let html = "<table border='2'>";
    for(let i=0;i<datos.length;i++){    
        html += "<tr><td>"+datos[i].puesto+"</td>";
        html += "<td>"+datos[i].nombre+"</td>";
        html += "<td>"+datos[i].apellido1+"</td>";
        html += "<td>"+datos[i].apellido2+"</td></tr>";
    }
    html +="</table>";
    document.getElementById("listado").innerHTML = html;
}
 
 
 function listarTablaCompleta(datos){
	 
	 let html = "<table border='2'>";
			
		for(let i=0;i<datos.length;i++){	
						
				html +="<tr><td>"+datos[i].idSupervisor+"</td>";
				html += "<tr><td>"+datos[i].dni+"</td>";
				html += "<td>"+datos[i].puesto+"</td>";
				html += "<td>"+datos[i].nombre+"</td>";
				html += "<td>"+datos[i].apellido1+"</td>";
				html += "<td>"+datos[i].apellido2+"</td>";
				html += "<td>"+datos[i].correo+"</td>";
				html += "<td>"+datos[i].telefono+"</td>";
				html += "<td><a href='ListaUsuario.html?id="+datos[i].idSupervisor+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].idSupervisor+")'>Borrar</a></td>";
				html +="</tr>";
				}
		
		html +="</table>";
		
		document.getElementById("listado").innerHTML = html;
 }
 
let mostrarTodo = false;

window.onload = function(){
    llamada();
    document.getElementById("mostrarTodo").addEventListener("click", function(){
        mostrarTodo = !mostrarTodo;
        if (mostrarTodo) {
            fetch('ListarUsuario')
            .then(response => response.json())         
            .then(data => listarTablaCompleta(data));
            document.getElementById("mostrarTodo").innerText = "Mostrar menos";
        } else {
            fetch('ListarUsuario')
            .then(response => response.json())         
            .then(data => listarTablaParcial(data));
            document.getElementById("mostrarTodo").innerText = "Mostrar más";
        }
    });
}
 
