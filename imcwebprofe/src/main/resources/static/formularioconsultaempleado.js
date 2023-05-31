window.onload = iniciarPagina; //cuando se cargue la página , llamas a esta función

//iniciarPagina(); //s/e se eejucta la llamada con los paréntisis en ese momento

//() => {console.log("soy una función anónima");}

//Esta linea falla, porque el elemento datosPaciente aún no existe
//document.getElementById("datosPaciente").style.visibility = "hidden";

function iniciarPagina ()
{
  console.log("pagina cargada");
  //poner invisible el card
  document.getElementById("datosPaciente").style.visibility = "hidden";
}

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
			console.log("paciente = " + paciente);
			//<h5 class="card-title" id="nombrepaciente">Card title</h5>
			
			let etiquetaH5 = document.getElementById("nombrepaciente");
			etiquetaH5.innerHTML = paciente.nombre + " "+ paciente.apellido+ " " +paciente.edad;
			
			//si el paciente tiene foto,
			if (paciente.fotoHashCode)//!=null
			{
				console.log("paciente con foto");
				let urlFoto = "http://localhost:8081/paciente/obtenerFoto/"+paciente.id;
				let imgPaciente = document.getElementById("fotoPaciente");
				imgPaciente.src = urlFoto;
				
				
			}  else
			{
				console.log("paciente SIN foto");
			}
				//ponemos img con la foto del servidor de ese paciente
			
			
			
			document.getElementById("datosPaciente").style.visibility = "visible";
			
			
		} else if (xmlHttpRequest.status==204) {
		
			console.log("El paciente solicitado no existe");
			window.alert("El paciente solicitado no existe"); //mostramos ventana
			
		}
	}	
	
}