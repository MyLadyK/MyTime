function llamada(){
	 fetch('ListarTurno')
	 .then(response => response.json())		 
	 .then(data => listarTablaTurno(data));  	
	 
 }
 
 function listarTablaTurno(datos){
    let html = "<table class='tablaTurno'>";
    
    html += "<tr><th>Año</th><th>Mes</th><th>Horario</th></tr>";
    
    for(let i=0;i<datos.length;i++){    
        html += "<tr><td>"+datos[i].anno+"</td>";
        html += "<td>"+datos[i].mes+"</td>";
        html += "<td>"+datos[i].tipoTurno+"</td>";
    }
    html +="</table>";
    document.getElementById("listado").innerHTML = html;
}
 
 
 
let mostrarTodo = false;

window.onload = function(){
    llamada();
    
}
