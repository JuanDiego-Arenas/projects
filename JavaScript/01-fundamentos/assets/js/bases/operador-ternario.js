const day = 1;
const horaActual = 10;

let horaApertura;
let mensaje;

horaApertura = [0, 6].includes(day) ? 9 : 11;

mensaje =
	horaActual >= horaApertura
		? 'Está abierto'
		: `Está cerrado, hoy abrimos a las ${horaApertura}`;

console.log({ horaActual, mensaje });
