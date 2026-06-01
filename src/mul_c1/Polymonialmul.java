package mul_c1;

public class Polymonialmul {
    public static float[] multiplicarCoeficientes(float[] c1, float[] c2) {
        // 1. El tamaño del array resultante es siempre la suma de los tamaños menos 1
        int tamanyoResultado = c1.length + c2.length - 1;
        float[] resultado = new float[tamanyoResultado];

        // 2. Un doble bucle "todos contra todos" para multiplicar cada término
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {

                // 3. Multiplicamos los coeficientes
                float producto = c1[i] * c2[j];

                // 4. ¡La magia! Lo acumulamos directamente en la posición i + j
                resultado[i + j] += producto;
            }
        }

        return resultado;
    }
}
