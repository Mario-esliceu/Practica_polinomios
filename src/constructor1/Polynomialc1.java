package constructor1;

public class Polynomialc1 {

    public static String convertirATexto(float[] coeficiente) {
        StringBuilder cuerpoPolinomio = construirCuerpo(coeficiente);

        if (cuerpoPolinomio.isEmpty()) {
            return "0";
        } else {
            return cuerpoPolinomio.toString();
        }
    }

    private static StringBuilder construirCuerpo(float[] coeficiente) {
        StringBuilder resultado = new StringBuilder();
        boolean esPrimerTermino = true;

        for (int i = 0; i < coeficiente.length; i++) {
            float coef = coeficiente[i];

            if (coef != 0) {
                int grado = coeficiente.length - 1 - i;

                String simbolo = obtenerSimbolo(coef, esPrimerTermino);
                String termino = construirTermino(simbolo, Math.abs(coef), grado);

                resultado.append(termino);
                esPrimerTermino = false;
            }
        }
        return resultado;
    }

    public static String obtenerSimbolo(float coef, boolean esPrimerPrint) {
        if (coef > 0) {
            if (esPrimerPrint) return "";
            else return " + ";
        } else {
            if (esPrimerPrint) return "-";
            else return " - ";
        }
    }

    public static String construirTermino(String simbolo, float valorAbs, int grado) {
        int numeroInt = (int) valorAbs;

        if (grado > 1) {
            String parteNumero = "";
            if (numeroInt != 1) {
                parteNumero = String.valueOf(numeroInt);
            }
            return simbolo + parteNumero + "x^" + grado;
        }

        if (grado == 1) {
            String parteNumero = "";
            if (numeroInt != 1) {
                parteNumero = String.valueOf(numeroInt);
            }
            return simbolo + parteNumero + "x";
        }

        return simbolo + numeroInt;
    }
}