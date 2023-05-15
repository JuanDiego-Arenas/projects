
public class Ejercicio4 {
    public static void main(String[] args) {
        int numeroif = -23;
        int numeroWhile = 0;
        String estacion = "Juan Diego";

        if (numeroif < 0) {
            System.out.println("Negativo");
        }else if (numeroif > 0) {
            System.out.println("Positivo");
        }else {
            System.out.println(0);
        }

        while (numeroWhile < 3) {
            System.out.println(numeroWhile);
            numeroWhile++;
        }

        do {
            System.out.println(numeroWhile);
            numeroWhile++;
        }while (numeroWhile < 3);

        for (int nuemroFor = 0; nuemroFor <= 3; nuemroFor++) {
            System.out.println(nuemroFor);
        }

        switch (estacion) {
            case "primavera":
                System.out.println("Es primavera");
                break;
            case "verano":
                System.out.println("Es verano");
                break;
            case "otoño":
                System.out.println("Es otoño");
                break;
            case "invierno":
                System.out.println("ES invierno");
                break;
            default:
            System.out.println("La variable 'estación' no es una estación");
        }

    }
}