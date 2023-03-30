/**
 * 2C = Two of Clovers (Tréboles)
 * 2D = Two of Diamonds (Diamantes)
 * 2H = Two of Hearts (Corazones)
 * 2S = Two of Spades (Picas)
 */

let deck = [];
const types = ['C', 'D', 'H', 'S'];
const letters = ['A', 'J', 'K', 'Q'];

let puntosJugador = 0,
	puntosComputadora = 0;

// Referencias HTML
const btnNewCard = document.querySelector('#btnNewCard');
const score = document.querySelectorAll('small');
const divPlayerCard = document.querySelector('#jugador-cartas');

// Esta función crea una nueva baraja
const createDeck = () => {
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

	deck = _.shuffle(deck);
	console.log(deck);
	return deck;
};

createDeck();

const pedirCarta = () => {
	if (deck.length === 0) {
		throw 'No hay mas cartas en el deck...';
	}

	let carta = deck.pop();
	return carta;
};

// pedirCarta();
const valorCarta = carta => {
	const valor = carta.substring(0, carta.length - 1);
	return isNaN(valor) ? (valor === 'A' ? 11 : 10) : valor * 1;
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
		console.warn('Te pasaste de 21, perdiste 😵');
	} else if (puntosJugador === 21) {
        btnNewCard.disabled = true;
		console.warn('21, Genial!! 🥳');
        
    }
});
