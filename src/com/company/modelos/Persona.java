package com.company.modelos;

public class Persona {
    private boolean tieneDiscapacidad;
    private int tiempo = 0;
    private int tiempoEnCola;
    private int round;
    private boolean atendido = false;

    public int getTiempo() {
        return this.tiempo;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public void setTiempo(){
        double random = (Math.random() * ((1 - 0) + 1)) + 0;
        if (random <= 0.2) {
            this.tiempo = 1;
        }
        if (random > 0.2 && random <= 0.4) {
            this.tiempo = 2;
        }
        if (random > 0.4 && random <= 0.6) {
            this.tiempo = 3;
        }
        if (random > 0.6 && random <= 0.8) {
            this.tiempo = 5;
        }
        if (random > 0.8 && random <= 0.9) {
            this.tiempo = 8;
        }
        if (random > 0.9 && random <= 0.95) {
            this.tiempo = 13;
        }
        if (random > 0.95) {
            this.tiempo = 13 + (int) (13 * Math.random());
        }
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public int getTiempoEnCola() {
        return tiempoEnCola;
    }

    public void setTiempoEnCola(int tiempoEnCola) {
        this.tiempoEnCola = tiempoEnCola;
    }

}
