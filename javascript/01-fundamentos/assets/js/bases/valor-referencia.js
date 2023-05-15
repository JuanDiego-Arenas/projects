let juan = { nombre: 'Juan' };
let ana = { ...juan };
ana.nombre = 'Ana';

console.log({ juan, ana });

const cambiarNombre = ({ ...persona }) => {
	persona.nombre = 'Tony';
	return persona;
	// return 1 + 2;
};

let peter = { nombre: 'Peter' };
let tony = cambiarNombre(peter);

console.log({ peter, tony });
