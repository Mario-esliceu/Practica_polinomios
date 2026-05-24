package constructor1;

public class Polynomialc1 {
    public static String obtenerSimbolo(float coef, boolean esPrimerPrint) {
        if (coef > 0) {
            if (esPrimerPrint) {
                return "";
            } else {
                return " + ";
            }
        } else {
            if (esPrimerPrint) {
                return "-";
            } else {
                return " - ";
            }
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

