const heroes = ['Batman', 'Superman', 'Mujer Maravilla', 'Aquaman'];

console.log('<------- For ------->');
for (let i = 0; i < heroes.length; i++) {
	console.log(heroes[i]);
}

console.log('<------- For in ------->');
for (let i in heroes) {
	console.log(heroes[i]);
}

console.log('<------- For in ------->');
for (let heroe of heroes) {
	console.log(heroe);
}
