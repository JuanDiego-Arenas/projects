let characters = {
	name: 'Tony Stark',
	codeName: 'Ironman',
	alive: false,
	age: 40,
	coords: {
		lat: 34.034,
		lng: -118.7,
	},
	suits: ['Mark I', 'Mark V', 'Hulkbuster'],
	direction: {
		zip: '10880, 90265',
		location: 'Malibu, California',
	},
};

console.log({ characters });
console.log('Nombre:', characters.name);
console.log('Nombre:', characters['name']);
console.log('Edad:', characters.age);

console.log('Coors:', characters.coords);
console.log('Lat:', characters.coords.lat);

console.log('No. Suits:', characters.suits.length);
console.log('Ultimo traje:', characters.suits[characters.suits.length - 1]);

const x = 'alive';
console.log('Vivo:', characters[x]);

// Mas detalles

// "delete" elimina propiedades en los objetos.
delete characters.age;
console.log(characters);

characters.casado = true;

// Objeto a Array
const arrCharacters = Object.entries(characters);
console.log(arrCharacters);

const propiedades = Object.getOwnPropertyNames(characters);
const valores = Object.values(characters)
console.log({ propiedades, valores });
