package constructor2;

public class Polynomialc2 {

    public static String[] separarPorTrozos(String s) {
        String limpio = s.replace(" ", "");
        limpio = limpio.replace("-", " -").replace("+", " +");
        return limpio.split(" ");
    }

    public static float[] procesarPolinomio(String s) {
        String[] terminos = separarPorTrozos(s);

        // Paso 1: Buscar el grado más alto de todos para saber el tamaño del array
        int maxGrado = 0;
        for (int i = 0; i < terminos.length; i++) {
            if (terminos[i].isEmpty()) continue;

            int gradoActual = descubrirGrado(terminos[i]);
            if (gradoActual > maxGrado) {
                maxGrado = gradoActual;
            }
        }

        // Paso 2: Crear el casillero con el tamaño correcto
        float[] coeficientesFinales = new float[maxGrado + 1];

        // Paso 3: Colocar cada número en su sitio (y sumarlos si se repiten)
        for (int i = 0; i < terminos.length; i++) {
            if (terminos[i].isEmpty()) continue;

            int grado = descubrirGrado(terminos[i]);
            float coef = descubrirCoeficiente(terminos[i]);

            // Fórmula mágica para saber la posición en el array de mayor a menor
            int posicion = maxGrado - grado;

            // Se acumula con += para que "3x - 3x" dé 0 o "31x^7 + 3x^7" dé 34
            coeficientesFinales[posicion] += coef;
        }

        return coeficientesFinales;
    }

    private static int descubrirGrado(String termino) {
        // Caso 1: Tiene un exponente (ej: "31x^7" o "-x^2")
        if (termino.contains("^")) {
            // Buscamos dónde está el "^"
            int posicionSombrerito = termino.indexOf("^");
            // Cortamos el texto para quedarnos solo con lo que hay DESPUÉS del "^"
            String textoGrado = termino.substring(posicionSombrerito + 1);
            // Lo convertimos a un número entero
            return Integer.parseInt(textoGrado);
        }

        // Caso 2: Tiene 'x' pero no tiene '^' (ej: "-5x" o "+x")
        if (termino.contains("x")) {
            return 1;
        }

        // Caso 3: No tiene 'x' por ningún lado, es el número suelto (ej: "+20" o "-9")
        return 0;
    }

    private static float descubrirCoeficiente(String termino) {
        String textoNumero = termino;

        // Paso 1: Si el término tiene una 'x', nos interesa SOLO lo que hay ANTES de la 'x'
        if (termino.contains("x")) {
            int posicionX = termino.indexOf("x");
            textoNumero = termino.substring(0, posicionX); // Corta desde el principio hasta la 'x'
        }

        // Paso 2: Controlar las trampas de los "unos invisibles" que quedaron al quitar la x
        // Si el texto se quedó vacío (ej: era "x") o solo con un más (ej: era "+x")
        if (textoNumero.equals("") || textoNumero.equals("+")) {
            return 1.0f;
        }

        // Si el texto se quedó solo con un menos (ej: era "-x" o "-x^5")
        if (textoNumero.equals("-")) {
            return -1.0f;
        }

        // Paso 3: Si no era ninguno de los casos raros anteriores, significa que es un
        // número normal (ej: "31", "-12", "+20"). Lo convertimos a float tranquilamente.
        return Float.parseFloat(textoNumero);
    }
}