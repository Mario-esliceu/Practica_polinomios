import static constructor1.Polynomialc1.construirTermino;
import static constructor1.Polynomialc1.obtenerSimbolo;
import static mul_c1.Polymonialmul.crearCasillero;
import static mul_c1.Polymonialmul.multiplicarCoeficientes;
import static sumas_c1_c2.Polynomialsumc1.sumarCoeficientes;

import constructor1.Polynomialc1;
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
        if (s.trim().equals("0")) {
            this.coeficiente = new float[]{0};
        } else {
            this.coeficiente = Polynomialc2.procesarPolinomio(s);
        }
    }

    public float[] roots() {
        return null;
    }

    public Polynomial add(Polynomial p) {
        float[] nuevosCoeficientes = sumarCoeficientes(this.coeficiente, p.coeficiente);

        return new Polynomial(nuevosCoeficientes);
    }

    public Polynomial mult(Polynomial p2) {
        float[] casilleroVacio = crearCasillero(this.coeficiente, p2.coeficiente);

        float[] nuevosCoeficientes = multiplicarCoeficientes(this.coeficiente, p2.coeficiente, casilleroVacio);

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
        if (this.coeficiente == null || this.coeficiente.length == 0) {
            return "0";
        }

        return Polynomialc1.convertirATexto(this.coeficiente);
    }


}
