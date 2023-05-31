//CÓDIGO JAVASC
console.log("HOLA ESTOY EN EL JAVASCRIPT");


//String palabra = new String();

var xmlHttpRequest = new XMLHttpRequest();
//JSON
var pacienteGlobal = {
  "id": 2,
  "nombre": "Mariajo",
  "edad": 20,
  "creadoEn": "2023-05-24T02:00:00",
  "email": null,
  "apellido": "martinez",
  "fotoHashCode": null
};

console.log(pacienteGlobal.apellido);

let dpto = {
  "departamento":8,
  "nombredepto":"Ventas",
  "director": "Juan Rodríguez",
  "empleados":[
    {
      "nombre":"Pedro",
      "apellido":"Fernández"
    },{
      "nombre":"Jacinto",
      "apellido":"Benavente"
    } 
  ]
};

console.log(dpto.empleados[1].apellido);
console.log(`APELLIDLO EMPLEADO 2 =  ${dpto.empleados[1].apellido}`);//


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
			var listaPacientes = JSON.parse(xmlHttpRequest.responseText);
			//Y MOSTRARLOS EN LA WEB
			console.log("listapacientes = " + listaPacientes);
			console.log("NOMBRE REGISTRO 0 listaPacientes[0].nombre " + listaPacientes[0].nombre); 
		} else {
		
			console.log("status = " + xmlHttpRequest.status);
			//DESERIALIZAR EL JSON
			//RX TEXTO -- OBJETO JAVASCRITP  GSON JEE JACKSON SPRING
			//JSON.parse(string):objeto - DESERIALIZAR - pasamos de TEXTO A VARIABLE JAVASCRIPT
			//JSON.stringify(objeto):string - SERIALIZAR - pasamos de un OBJETO JS a UN STIRNG EN JSON
			
		}
	}	
	
}

//vamos a traernos los datos del servidor
//vamos a consumir un servicio web



/*
//ÁMBITO GLOBAL (NO ESTÁ ENVUELTO EN NINGÚN FUNCIÓN)- SE EJECUTA al cargar inicio.js
fetch("http://localhost:8081/paciente/") //pido al get "meto el cafe al micro"
.then (
	respuesta => {
		console.log("a la vuelta del fetch"); //he recibido a respuesta
		console.log(respuesta);
		//extraerlos 
		//mostrarlos en la web
		
	});
console.log("fetch ejecutado"); */ 

//Y LEDIGO, CUANDO VUELVAS, ME LLAMAS AQUÍ then(funcion)

/**
void gestionarRespuesta (respuesta)
{
  sysout (respuesta)
 }
 **/