package sumas_c1_c2;

public class Polynomialsumc1 {
    // FUNCIÓN 1: Averigua el grado más alto entre dos arrays de coeficientes
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
    public static float obtenerValorPorGrado(float[] coeficiente, int gradoObjetivo) {
        int gradoPolinomio = coeficiente.length - 1;

        // Fórmula para traducir grado a la posición física del array
        int indice = gradoPolinomio - gradoObjetivo;

        // Si la posición existe dentro del array, devolvemos su número
        if (indice >= 0 && indice < coeficiente.length) {
            return coeficiente[indice];
        } else {
            // Si el polinomio es más pequeño y no tiene ese grado, devolvemos 0
            return 0.0f;
        }
    }

    // FUNCIÓN 3: El motor principal que hace el bucle y devuelve el array sumado
    public static float[] sumarCoeficientes(float[] c1, float[] c2) {
        int maxGrado = obtenerMaxGrado(c1, c2);
        float[] resultado = new float[maxGrado + 1];

        // Recorremos los grados de mayor a menor
        for (int grado = maxGrado; grado >= 0; grado--) {
            // Usamos la función 2 para pedir los números de forma segura
            float valor1 = obtenerValorPorGrado(c1, grado);
            float valor2 = obtenerValorPorGrado(c2, grado);

            // Sumamos los dos valores
            float sumaTotal = valor1 + valor2;

            // Lo guardamos en su sitio correspondiente del array resultado
            int indexResultado = maxGrado - grado;
            resultado[indexResultado] = sumaTotal;
        }

        return resultado;
    }
}
