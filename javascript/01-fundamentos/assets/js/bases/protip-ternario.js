const elMayor = (a, b) => (a > b ? a : b);

const tieneMembresia = miembro => (miembro ? '2 Dólares' : '10 Dólares');

console.log(elMayor(20, 15));
console.log(tieneMembresia(false));
