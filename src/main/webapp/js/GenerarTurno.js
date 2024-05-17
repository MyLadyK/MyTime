document.getElementById('validar').addEventListener('click', function(event) {
	let anno = document.getElementById('anno').value;
	let mes = document.getElementById('mes').value;
	let diaInicio = document.getElementById('diaInicio').value;
	let diaFin = document.getElementById('diaFin').value;
	let horaInicio = document.getElementById('horaInicio').value;
	let horaFin = document.getElementById('horaFin').value;
	let numTrabajadores = document.getElementById('numTrabajadores').value;

	
		let ok = true;
	if(anno == ""){
		ok = false;
		document.getElementById('anno').style.background = "red";
	} else {
		document.getElementById('anno').style.background = "white";
	}
	if(mes == ""){
		ok = false;
		document.getElementById('mes').style.background = "red";
	} else {
		document.getElementById('mes').style.background = "white";
	}
	if(diaInicio == ""){
		ok = false;
		document.getElementById('diaInicio').style.background = "red";
	} else {
		document.getElementById('diaInicio').style.background = "white";
	}
	if(diaFin == ""){
		ok = false;
		document.getElementById('diaFin').style.background = "red";
	} else {
		document.getElementById('diaFin').style.background = "white";
	}
	if(horaInicio == ""){
		ok = false;
		document.getElementById('horaInicio').style.background = "red";
	} else {
		document.getElementById('horaInicio').style.background = "white";
	}
	if(horaFin == ""){
		ok = false;
		document.getElementById('horaFin').style.background = "red";
	} else {
		document.getElementById('horaFin').style.background = "white";
	}
	if(numTrabajadores == ""){
		ok = false;
		document.getElementById('numTrabajadores').style.background = "red";
	} else {
		document.getElementById('numTrabajadores').style.background = "white";
	}
	
	
});
