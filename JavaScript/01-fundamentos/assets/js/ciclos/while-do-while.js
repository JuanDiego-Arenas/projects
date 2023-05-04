const carros = ['Ford', 'Mazda', 'Honda', 'Toyota'];

let i = 0;

// while (i < carros.length) {
// 	console.log(carros[i]);
// 	i++;
// }

console.warn('<------- While ------->');
while (carros[i]) {
	if (i === 2) {
		// break;
		i++;
		continue;
	}
	console.log(carros[i]);
	i++;
}

// Va a ejecutar el primer bloque, al menos 1 ves, así sea 'false'
console.warn('<------- Do While ------->');
let j = 0;

do {
	console.log(carros[j]);
	j++;
} while (carros[j]);
