package constructor2;

public class Polynomialc2 {

    public static String[] separarPorTrozos(String s) {
        String limpio = s.replace(" ", "");
        limpio = limpio.replace("-", " -").replace("+", " +");
        return limpio.split(" ");
    }

    public static int calcularGradoMayor(String[] terminos) {
        int maxGrado = 0;

        for (int i = 0; i < terminos.length; i++) {
            if (terminos[i].isEmpty()) continue;

            int gradoActual = descubrirGrado(terminos[i]);
            if (gradoActual > maxGrado) {
                maxGrado = gradoActual;
            }
        }
        return maxGrado;
    }

    public static float[] procesarPolinomio(String s) {
        String[] terminos = separarPorTrozos(s);
        int maxGrado = calcularGradoMayor(terminos);

        float[] coeficientesFinales = new float[maxGrado + 1];

        for (int i = 0; i < terminos.length; i++) {
            if (terminos[i].isEmpty()) continue;

            int grado = descubrirGrado(terminos[i]);
            float coef = descubrirCoeficiente(terminos[i]);

            int posicion = maxGrado - grado;
            coeficientesFinales[posicion] += coef;
        }

        return coeficientesFinales;
    }

    private static int descubrirGrado(String termino) {
        if (termino.contains("^")) {
            String textoGrado = "";
            boolean empezarALeer = false;

            for (int i = 0; i < termino.length(); i++) {
                if (empezarALeer) {
                    textoGrado += termino.charAt(i);
                }
                if (termino.charAt(i) == '^') {
                    empezarALeer = true;
                }
            }
            return Integer.parseInt(textoGrado);
        }

        if (termino.contains("x")) {
            return 1;
        }

        return 0;
    }

    private static float descubrirCoeficiente(String termino) {
        String textoNumero = "";

        for (int i = 0; i < termino.length(); i++) {
            if (termino.charAt(i) == 'x') {
                break;
            }
            textoNumero += termino.charAt(i);
        }

        if (textoNumero.equals("") || textoNumero.equals("+")) {
            return 1.0f;
        }
        if (textoNumero.equals("-")) {
            return -1.0f;
        }

        return Float.parseFloat(textoNumero);
    }
}