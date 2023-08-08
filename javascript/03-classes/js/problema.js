const juanDiego = {
	nombre: 'Juan Diego',
	edad: 20,
	imprimir() {
		console.log(`Nombre: ${this.nombre} - edad: ${this.edad}`);
	},
};

const marianaCadena = {
	nombre: 'Mariana Cadena',
	edad: 19,
	imprimir() {
		console.log(`Nombre: ${this.nombre} - edad: ${this.edad}`);
	},
};

// Es poco practico crear varios de estos objetos json, para crear varias personas

// Esta es una función que anteriormente aparentaba ser una "clase"
function Persona(nombre, edad) {
	// Acá se llama a cada atributo, para que se puedan ver en la instancia
	this.nombre = nombre;
	this.edad = edad;
	this.imprimir = function () {
		console.log(`Nombre: ${this.nombre} - edad: ${this.edad}`);
	};
}

//   nombre   instancia   (     Atributos     )
const juan = new Persona('Juan Diego Arenas', 20);
const mariana = new Persona('Mariana Cadena Cadena', 19);
console.log(mariana);
mariana.imprimir();
