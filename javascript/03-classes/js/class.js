class Persona {
	nombre;
	identidad;
	frase;

	constructor(nombre, identidad, frase) {
		this.nombre = nombre;
		this.identidad = identidad;
		this.frase = frase;
	}

	quienSoy() {
		console.log(`Soy ${this.nombre} y mi identidad es ${this.identidad}`);
	}

    miFrase() {
        this.quienSoy();
        console.log(`${this.identidad} dice: ${this.frase}`);    
    }
}

const spiderman = new Persona(
	'pitter Parker',
	'Spiterman',
	'un gran poder conlleva una gran responsabilidad'
);
const ironman = new Persona('Tony Stark', 'Ironman', "I'am Ironman");

spiderman.miFrase();
ironman.miFrase();

console.log(spiderman);
console.log(ironman);
