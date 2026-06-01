package sumas_c1_c2;

public class Polynomialsumc1 {
    public static int obtenerMaxGrado(float[] c1, float[] c2) {
        int grado1 = c1.length - 1;
        int grado2 = c2.length - 1;

        if (grado2 > grado1) {
            return grado2;
        } else {
            return grado1;
        }
    }

    // FUNCIÓN 2: Saca el número de un grado de forma segura (con el escudo protector)
    public static float obtenerValorPorGrado(float[] coeficiente, int grado) {
        int gradoPolinomio = coeficiente.length - 1;

        int indice = gradoPolinomio - grado;

        if (indice >= 0 && indice < coeficiente.length) {
            return coeficiente[indice];
        } else {
            return 0.0f;
        }
    }

    public static float[] sumarCoeficientes(float[] c1, float[] c2) {
        int maxGrado = obtenerMaxGrado(c1, c2);
        float[] resultado = new float[maxGrado + 1];

        for (int grado = maxGrado; grado >= 0; grado--) {
            float valor1 = obtenerValorPorGrado(c1, grado);
            float valor2 = obtenerValorPorGrado(c2, grado);

            float sumaTotal = valor1 + valor2;

            int index = maxGrado - grado;
            resultado[index] = sumaTotal;
        }

        return resultado;
    }
}
