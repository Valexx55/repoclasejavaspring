//CÓDIGO JAVASC
console.log("HOLA ESTOY EN EL JAVASCRIPT");



var xmlHttpRequest = new XMLHttpRequest();

function traerDatos()
{
 console.log ("BOTON TRAER DATOS TOCADO");
 
 xmlHttpRequest.onreadystatechange = procesarRespuesta;//cuando avance la com, me llamas ahí
 xmlHttpRequest.open("GET", "http://localhost:8081/paciente/");
 xmlHttpRequest.send (null); //el cuerpo va desnudo 
}

//esta función, va a ser invocada, según avance la petición
function procesarRespuesta ()
{ 
	console.log (xmlHttpRequest.readyState);
	if (xmlHttpRequest.readyState==4)
	{
		console.log ("el servidor ha traido la respuesta");
		if (xmlHttpRequest.status==200)
		{
			console.log("cuerpo respuesta = " + xmlHttpRequest.responseText);
			//EXTRAERLOS Y MOSTRARLOS EN LA WEB
		} else {
		
			console.log("status = " + xmlHttpRequest.status);
		}
	}	
	
}

//vamos a traernos los datos del servidor
//vamos a consumir un servicio web





fetch("http://localhost:8081/paciente/") //pido al get "meto el cafe al micro"
.then (
	respuesta => {
		console.log("a la vuelta del fetch"); //he recibido a respuesta
		console.log(respuesta);
		//extraerlos 
		//mostrarlos en la web
		
	});
console.log("fetch ejecutado"); 

//Y LEDIGO, CUANDO VUELVAS, ME LLAMAS AQUÍ then(funcion)

/**
void gestionarRespuesta (respuesta)
{
  sysout (respuesta)
 }
 **/