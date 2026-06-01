import static constructor1.Polynomialc1.construirTermino;
import static constructor1.Polynomialc1.obtenerSimbolo;
import static mul_c1.Polymonialmul.multiplicarCoeficientes;
import static sumas_c1_c2.Polynomialsumc1.sumarCoeficientes;

import constructor2.Polynomialc2;

public class Polynomial {

    private float[] coeficiente;

    public Polynomial(float[] cfs) {
        this.coeficiente = cfs;
    }

    public Polynomial() {
        this.coeficiente = new float[]{0};
    }

    public Polynomial(String s) {
        // 1. Si el texto es exactamente "0", evitamos procesos y creamos el array con un cero
        if (s.trim().equals("0")) {
            this.coeficiente = new float[]{0};
        } else {
            // 2. Si no es cero, llamamos a tu método mágico de la otra carpeta
            this.coeficiente = Polynomialc2.procesarPolinomio(s);
        }
    }

    public float[] roots() {
        return null;
    }


    // DENTRO DE LA CLASE POLYNOMIAL:
    public Polynomial add(Polynomial p) {
        float[] nuevosCoeficientes = sumarCoeficientes(this.coeficiente, p.coeficiente);

        return new Polynomial(nuevosCoeficientes);
    }

    // DENTRO DE LA CLASE POLYNOMIAL:
    public Polynomial mult(Polynomial p2) {
        // 1. Le mandamos los arrays al multiplicador de la otra carpeta
        float[] nuevosCoeficientes = multiplicarCoeficientes(this.coeficiente, p2.coeficiente);

        // 2. Devolvemos el nuevo Polinomio resultante
        return new Polynomial(nuevosCoeficientes);
    }

    public Polynomial[] div(Polynomial p2) {
        return null;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Polynomial) {
            Polynomial otro = (Polynomial) o;

            return this.toString().equals(otro.toString());
        }

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


}
