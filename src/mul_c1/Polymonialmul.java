package mul_c1;

public class Polymonialmul {

    public static float[] crearCasillero(float[] c1, float[] c2) {
        int tamanyoResultado = c1.length + c2.length - 1;
        return new float[tamanyoResultado];
    }

    public static float[] multiplicarCoeficientes(float[] c1, float[] c2, float[] resultado) {
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                float producto = c1[i] * c2[j];
                resultado[i + j] += producto;
            }
        }
        return resultado;
    }
}
