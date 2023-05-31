
var xmlHttpRequest = new XMLHttpRequest();//ambito global

function buscarPaciente()
{
console.log ("buscando paciente");
//1 OBTENER EL VALOR QUE EL USUARIO HA METIDO EN EL INPUT
let inputid = document.getElementById("idpaciente"); //obtengo el elemento input
let idpac = inputid.value;//accedo al valor del elemento/caja
console.log (`ID paciente = ${idpac}`); //lo muestro
//LLAAMAR AL SERVICIO CONSULTA API WEB http://localhost:8081/paciente/id
llamarServcioWeb(idpac);

}

function llamarServcioWeb(idpaciente)
{

 xmlHttpRequest.onreadystatechange = procesarRespuesta;//cuando avance la com, me llamas ahí
 let urlSerivicioWEb = "http://localhost:8081/paciente/"+idpaciente;
 console.log ("llamando a " + urlSerivicioWEb);
 xmlHttpRequest.open("GET", urlSerivicioWEb);
 xmlHttpRequest.send (null); //el cuerpo va desnudo
  
}


function procesarRespuesta ()
{ 
	console.log (xmlHttpRequest.readyState);
	if (xmlHttpRequest.readyState==4)
	{
		console.log ("el servidor ha traido la respuesta");
		if (xmlHttpRequest.status==200)
		{
			console.log("cuerpo respuesta = " + xmlHttpRequest.responseText);
			var paciente = JSON.parse(xmlHttpRequest.responseText);
			
		} else if (xmlHttpRequest.status==204) {
		
			console.log("El paciente solicitado no existe");
			window.alert("El paciente solicitado no existe"); //mostramos ventana
			
		}
	}	
	
}