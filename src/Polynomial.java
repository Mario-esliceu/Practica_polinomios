import java.util.Arrays;

public class Polynomial {

    private float[] coeficiente;

    public Polynomial(float[] cfs) {
        this.coeficiente = cfs;
    }

    public Polynomial() {
        this.coeficiente = new float[]{0};
    }

    public Polynomial(String s) {

    }

    public float[] roots() {
        return null;
    }

    public Polynomial add(Polynomial p) {
       return null;
    }


    public Polynomial mult(Polynomial p2) {
        return null;
    }

    public Polynomial[] div(Polynomial p2) {
        return null;
    }
    
    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        if (coeficiente == null || coeficiente.length == 0) {
            return "0";
        }

        StringBuilder polinomioFinal = new StringBuilder();
        int grado = coeficiente.length - 1;
        boolean primerPrint = true;

        for (int i = 0; i < coeficiente.length; i++) {
            float coef = coeficiente[i];

            if (coef == 0) {
                grado--;
                continue;
            }

            String simbolo = obtenerSimbolo(coef, primerPrint);
            primerPrint = false;

            String termino = construirTermino(simbolo, Math.abs(coef), grado);
            polinomioFinal.append(termino);

            grado--;
        }

        // Cambiado: Ahora es un if-else normal y corriente
        if (polinomioFinal.isEmpty()) {
            return "0";
        } else {
            return polinomioFinal.toString();
        }
    }

    private String obtenerSimbolo(float coef, boolean esPrimerPrint) {
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

    private String construirTermino(String simbolo, float valorAbs, int grado) {
        int numeroInt = (int) valorAbs;

        // Caso 1: Grados mayores que 1 (ej: 4x^3 o x^2)
        if (grado > 1) {
            String parteNumero = "";
            if (numeroInt != 1) {
                parteNumero = String.valueOf(numeroInt); // Si no es 1, guardamos el número (ej: "4")
            }
            return simbolo + parteNumero + "x^" + grado;
        }

        // Caso 2: Grado 1 (ej: 5x o x)
        if (grado == 1) {
            String parteNumero = "";
            if (numeroInt != 1) {
                parteNumero = String.valueOf(numeroInt); // Si no es 1, guardamos el número (ej: "5")
            }
            return simbolo + parteNumero + "x";
        }

        // Caso 3: Grado 0 (El número suelto del final, ej: 5)
        // Aquí el 1 SÍ se pincha siempre, así que no necesitamos ningún if
        return simbolo + numeroInt;
    }
}
