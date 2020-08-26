package com.company.modelos;

public class Caja {
    private int numeroCaja;
    private boolean esNueva;
    private boolean estaVacia;
    private int tiempo;

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public boolean isEsNueva() {
        return esNueva;
    }

    public void setEsNueva(boolean esNueva) {
        this.esNueva = esNueva;
    }

    public boolean isEstaVacia() {
        return estaVacia;
    }

    public void setEstaVacia(boolean estaVacia) {
        this.estaVacia = estaVacia;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
