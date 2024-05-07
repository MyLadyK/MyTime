
function validar(){
	let dni = doucument.getElementById('dni').value;
	let puesto = doucument.getElementById('puesto').value;
	let nombre = doucument.getElementById('nombre').value;
	let apellido1 = doucument.getElementById('apellido1').value;
	let apellido2 = doucument.getElementById('apellido2').value;
	let correo = doucument.getElementById('correo').value;
	let telefono = doucument.getElementById('telefono').value;
	
	let ok = true;
	if(dni == ""){
		of = false;
		document.getElementById('dni').style.background = "red";
	}
	if(dni == ""){
		of = false;
		document.getElementById('puesto').style.background = "red";
	}
	
	if (ok == true){
		document.getElementById("AltaUsuario").submit();
	}
	
	
	
	
}