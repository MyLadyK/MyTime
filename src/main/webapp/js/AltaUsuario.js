document.getElementById('validar').addEventListener('click', function(event) {
	let dni = document.getElementById('dni').value;
	let nombre = document.getElementById('nombre').value;
	let apellido1 = document.getElementById('apellido1').value;
	let correo = document.getElementById('correo').value;
	
	let ok = true;
	if(dni == ""){
		ok = false;
		document.getElementById('dni').style.background = "red";
	} else {
		document.getElementById('dni').style.background = "white";
	}
	if(nombre == ""){
		ok = false;
		document.getElementById('nombre').style.background = "red";
	} else {
		document.getElementById('nombre').style.background = "white";
	}
	if(apellido1 == ""){
		ok = false;
		document.getElementById('apellido1').style.background = "red";
	} else {
		document.getElementById('apellido1').style.background = "white";
	}
	if(correo == ""){
		ok = false;
		document.getElementById('correo').style.background = "red";
	} else {
		document.getElementById('correo').style.background = "white";
	}
	
	
	
});
	
	
	
	/*
	if (ok == true){
		
		let agregarMas = confirm("¿Deseas agregar más usuarios?");
		if (agregarMas) {
			
			window.location.href = "http://localhost:8080/My_Time/AltaUsuario.html";
		} else {
			
			window.location.href = "http://localhost:8080/My_Time/ListaUsuario.html";
		}
	} else {
		// Previene el envío del formulario si la validación falla
		event.preventDefault();
	}
});
*/
