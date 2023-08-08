import './style.css';
import _ from 'underscore';
import javascriptLogo from './javascript.svg';
import viteLogo from '/vite.svg';
import { setupCounter } from './counter.js';

/**
 * 2C = Two of Clovers (Tréboles)
 * 2D = Two of Diamonds (Diamantes)
 * 2H = Two of Hearts (Corazones)
 * 2S = Two of Spades (Picas)
 */

const modulo = (() => {
	'use strict';

	let deck = [];
	const types = ['C', 'D', 'H', 'S'],
		letters = ['A', 'J', 'K', 'Q'];

	let puntosJugadores = [];

	// Referencias HTML
	const btnRefreshGame = document.querySelector('#btnRefreshGame'),
		btnNewCard = document.querySelector('#btnNewCard'),
		btnStopGame = document.querySelector('#btnStopGame');

	const score = document.querySelectorAll('small'),
		win = document.querySelectorAll('span');

	const divCartasJugadores = document.querySelectorAll('.divCartas');

	// Esta función inicializamos
	const inicializarJuego = (numJugadores = 2) => {
		deck = createDeck();

		puntosJugadores = [];

		for (let i = 0; i < numJugadores; i++) {
			puntosJugadores.push(0);
		}

		score.forEach(elem => (elem.innerText = 0));
		divCartasJugadores.forEach(elem => (elem.innerHTML = ''));

		btnNewCard.disabled = false;
		btnStopGame.disabled = false;
	};

	// Esta función crea una nueva baraja
	const createDeck = () => {
		deck = [];
		for (let i = 2; i <= 10; i++) {
			for (const type of types) {
				deck.push(`${i}${type}`);
			}
		}

		for (const type of types) {
			for (const letter of letters) {
				deck.push(`${letter}${type}`);
			}
		}

		return _.shuffle(deck);
	};

	// Se pide una carta, lo que hace es eliminar la ultima carta del deck y antes de eliminarla hace toda la lógica
	const pedirCarta = () => {
		if (deck.length === 0) {
			throw 'No hay mas cartas en el deck...';
		}

		return deck.pop();
	};

	// Esta función nos da el valor de la carta
	const valorCarta = carta => {
		const valor = carta.substring(0, carta.length - 1);
		return isNaN(valor) ? (valor === 'A' ? 11 : 10) : valor * 1;
	};

	// Turno: 0 = primer jugador y el último será la computadora
	const acumularPuntos = (card, turno) => {
		puntosJugadores[turno] = puntosJugadores[turno] + valorCarta(card);
		score[turno].innerText = puntosJugadores[turno];
		return puntosJugadores[turno];
	};

	const crearCarta = (card, turno) => {
		const imgCard = document.createElement('img');
		imgCard.src = `./assets/cartas/${card}.png`;
		imgCard.classList = 'carta';
		divCartasJugadores[turno].append(imgCard);
	};

	const determinarGanador = () => {
		const [puntosMinimos, puntosComputadora] = puntosJugadores;

		setTimeout(() => {
			if (puntosComputadora === puntosMinimos) {
				alert('Empate, inténtalo nuevamente 🤷🏻‍♂️');
			} else if (puntosMinimos > 21) {
				alert('Perdiste, mejor suerte para la proxima😵😪');
				win[1].innerText++;
			} else if (puntosComputadora > 21) {
				alert('Ganaste!!! 🏆🥇🥳');
				win[0].innerText++;
			} else if (puntosMinimos < puntosComputadora) {
				alert('Perdiste, mejor suerte para la proxima😵😪');
				win[1].innerText++;
			} else if (puntosComputadora < puntosMinimos) {
				alert('Ganaste!!! 🏆🥇🥳');
				win[0].innerText++;
			}
		}, 240);
	};

	// Turno de la computadora
	const turnoComputadora = puntosMinimos => {
		let puntosComputadora = 0;

		do {
			const card = pedirCarta();
			puntosComputadora = acumularPuntos(
				card,
				puntosJugadores.length - 1
			);

			crearCarta(card, puntosJugadores.length - 1);

			// if (puntosMinimos > 21) {
			// 	break;
			// }
		} while (puntosComputadora < puntosMinimos && puntosMinimos <= 21);

		determinarGanador();
	};

	// --------------- Eventos  ---------------
	btnNewCard.addEventListener('click', () => {
		const card = pedirCarta();
		const puntosJugador = acumularPuntos(card, 0);

		crearCarta(card, 0);

		if (puntosJugador > 21) {
			btnNewCard.disabled = true;
			btnStopGame.disabled = true;
			console.warn('Te pasaste de 21, perdiste 😵');
			turnoComputadora(puntosJugador);
		} else if (puntosJugador === 21) {
			btnNewCard.disabled = true;
			btnStopGame.disabled = true;
			console.warn('21, Genial!! 🥳');
			turnoComputadora(puntosJugador);
		}
	});

	btnStopGame.addEventListener('click', () => {
		btnStopGame.disabled = true;
		btnNewCard.disabled = true;
		turnoComputadora(puntosJugadores);
	});

	return {
		nuevoJuego: inicializarJuego,
	};
})();
