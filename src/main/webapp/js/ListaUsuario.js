function llamada(){
	 fetch('ListarUsuario')
	 .then(response => response.json())		 
	 .then(data => listarTabla(data));  	
	 
 }
 
 
 function listarTabla(datos){
	 
	 let html = "<table border='2'>";
			
		for(let i=0;i<datos.length;i++){	
						
				html +="<tr><td>"+datos[i].idSupervisor+"</td>";
				html += "<td>"+datos[i].dni+"</td>";
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
 
window.onload = function(){
	 
	 llamada();
	 
 }
 
