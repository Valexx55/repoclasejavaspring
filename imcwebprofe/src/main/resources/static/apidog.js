var xmlHttpRequest = new XMLHttpRequest();//ámbito global

const urlSerivicioWEb = "https://dog.ceo/api/breeds/image/random";

function buscarPerro()
{
	llamadaServicioRandomDog();

}

function llamadaServicioRandomDog()
{

	 xmlHttpRequest.onreadystatechange = procesarRespuesta;
	 xmlHttpRequest.open("GET", urlSerivicioWEb);
	 xmlHttpRequest.send (null);
  
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
			let respuestaRandomDog = JSON.parse(xmlHttpRequest.responseText);
			
			
			let elementoFotoPerro = document.getElementById("random-foto-perro");
			elementoFotoPerro.src = respuestaRandomDog.message;
			elementoFotoPerro.style.display = "inline-block";	
			
		} else{
		
			window.alert("Ha ocurrido un error.");
			
		}
	}	
	
}