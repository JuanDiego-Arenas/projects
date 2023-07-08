/**
 * 2C = Two of Clovers (Tréboles)
 * 2D = Two of Diamonds (Diamantes)
 * 2H = Two of Hearts (Corazones)
 * 2S = Two of Spades (Picas)
 */

(() => {
	'use strict';

	let deck = [];
	const types = ['C', 'D', 'H', 'S'],
		letters = ['A', 'J', 'K', 'Q'];

	// let puntosJugador = 0,
	// 	puntosComputadora = 0;
	let puntosJugadores = [];

	// Referencias HTML
	const btnNewCard = document.querySelector('#btnNewCard'),
		btnStopGame = document.querySelector('#btnStopGame'),
		btnRefreshGame = document.querySelector('#btnRefreshGame');

	const score = document.querySelectorAll('small'),
		win = document.querySelectorAll('span');

	const divPlayerCard = document.querySelector('#jugador-cartas'),
		divComputerCard = document.querySelector('#computadora-cartas');

	const inicializarJuego = (numJugadores = 1) => {
		deck = createDeck();
		for (let i = 0; i < numJugadores; i++) {
			const element = numJugadores[i];
			
		}
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

	const pedirCarta = () => {
		if (deck.length === 0) {
			throw 'No hay mas cartas en el deck...';
		}

		return deck.pop();
	};

	const valorCarta = carta => {
		const valor = carta.substring(0, carta.length - 1);
		return isNaN(valor) ? (valor === 'A' ? 11 : 10) : valor * 1;
	};

	const acumularPuntos = () => {};

	// Turno de la computadora
	const turnoComputadora = puntosMinimos => {
		do {
			const card = pedirCarta();

			puntosComputadora = puntosComputadora + valorCarta(card);
			score[1].innerText = puntosComputadora;

			// <img class="carta" src="./assets/cartas/2H.png" alt="carta">
			const imgCard = document.createElement('img');
			imgCard.src = `./assets/cartas/${card}.png`;
			imgCard.classList = 'carta';
			divComputerCard.append(imgCard);

			if (puntosMinimos > 21) {
				break;
			}
		} while (puntosComputadora < puntosMinimos && puntosMinimos <= 21);

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

	// Eventos
	btnNewCard.addEventListener('click', () => {
		const card = pedirCarta();

		puntosJugador = puntosJugador + valorCarta(card);
		score[0].innerText = puntosJugador;

		// <img class="carta" src="./assets/cartas/2H.png" alt="carta">
		const imgCard = document.createElement('img');
		imgCard.src = `./assets/cartas/${card}.png`;
		imgCard.classList = 'carta';
		divPlayerCard.append(imgCard);

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
		turnoComputadora(puntosJugador);
	});

	const cleanBoard = board => {
		const div = document.querySelector(board);
		const img = div.querySelectorAll('img');
		img.forEach(carta => {
			carta.remove();
		});
	};

	btnRefreshGame.addEventListener('click', () => {
		cleanBoard('#jugador-cartas');
		cleanBoard('#computadora-cartas');

		deck = [];
		deck = createDeck();

		puntosJugador = 0;
		puntosComputadora = 0;

		score[0].innerText = 0;
		score[1].innerText = 0;

		btnNewCard.disabled = false;
		btnStopGame.disabled = false;
	});
})();
