let juegos = ['Zelda', 'Mario', 'Metroid', 'Chrono'];
// console.log('Largo:', juegos.length);

let primero = juegos[0];
let ultimo = juegos[juegos.length - 1];

// console.log({ primero, ultimo });

juegos.forEach((elemento, indice, arr) => {
	// console.log({ elemento, indice, arr });
});

let nuevaLongitud = juegos.push('F-Zero');
console.log({ nuevaLongitud, juegos });

nuevaLongitud = juegos.unshift('Fire Emblem');
console.log({ nuevaLongitud, juegos });

nuevaLongitud = juegos.pop();
console.log({ nuevaLongitud, juegos });

let pos = 1;

let juegosBorrados = juegos.splice(pos, 2);
console.log({ juegoBorrados: juegosBorrados, juegos });

let marioIndex = juegosBorrados.indexOf('Mario');
console.log({ marioIndex });
