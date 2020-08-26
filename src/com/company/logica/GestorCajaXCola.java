package com.company.logica;

import com.company.modelos.Caja;
import com.company.modelos.Persona;
import com.company.tda.Cola;

import java.util.ArrayList;

public class GestorCajaXCola {
    public ArrayList<Persona> anadirPersonaACaja(Caja[] cajas, Cola cola, Cola colaPrioridad, ArrayList<Persona> personasSalen, ArrayList<Persona> personasQuedan) throws Exception {
        for (int i = 1; i < 481; i++) {
            System.out.println("Estamos en el minuto : " + i);
            Caja caja = hayCajaLibres(cajas);
            if (caja.isEstaVacia()) {
                if (colaPrioridad.getHead().getRound() == 1 && !colaPrioridad.getHead().isAtendido()) {
                    for (int j = 0; j < obtenerTodosLosQueDeberianSalir(colaPrioridad); j++) {
                        Caja cajaPrioridad = hayCajaLibres(cajas);
                        if (cajaPrioridad.isEstaVacia()) {
                            System.out.println("Va a salir una persona con prioridad");
                            Persona personaPrioridad = colaPrioridad.deQueue();
                            personasSalen.add(personaPrioridad);
                            cajaPrioridad.setTiempo(personaPrioridad.getTiempo());
                            System.out.println("El numero de caja a la que va a salir es : " + cajaPrioridad.getNumeroCaja());
                            personaPrioridad.setRound(0);
                            personaPrioridad.setAtendido(true);
                            cajaPrioridad.setEstaVacia(false);
                        }
                    }
                }
                if (cola.getHead().getRound() == 1  && !cola.getHead().isAtendido()) {
                    for (int j = 0; j < obtenerTodosLosQueDeberianSalir(cola); j++) {
                        Caja cajaNormal = hayCajaLibres(cajas);
                        if (cajaNormal.isEstaVacia()) {
                            System.out.println("Va a salir una persona normal");
                            Persona persona = cola.deQueue();
                            personasSalen.add(persona);
                            cajaNormal.setTiempo(cajaNormal.isEsNueva() ? persona.getTiempo() + 1: persona.getTiempo());
                            System.out.println("La caja libre es : " + cajaNormal.getNumeroCaja());
                            persona.setRound(0);
                            persona.setAtendido(true);
                            cajaNormal.setEstaVacia(false);
                        }
                    }
                }
            } else {
                for (int j = 0; j < cajas.length; j++) {
                    if (cajas[j].getTiempo() == 0) {
                        cajas[j].setEstaVacia(true);
                    } else {
                        cajas[j].setTiempo(cajas[j].getTiempo() - 1);
                        if (cajas[j].getTiempo() == 0) {
                            cajas[j].setEstaVacia(true);
                        }
                    }
                }
                System.out.println("--------------- No hay cajas ahorita abiertas --------------------------");
                aumentarTiempo(cola);
                aumentarTiempo(colaPrioridad);
            }
            if(obtenerTodosLosQueDeberianSalir(cola) == 0){
                decrementarTodos(cola);
            }
            if(obtenerTodosLosQueDeberianSalir(colaPrioridad) == 0){
                decrementarTodos(colaPrioridad);
            }
            System.out.println();
        }
        aumentarTiempo(cola);
        aumentarTiempo(colaPrioridad);
        return personasSalen(cola,colaPrioridad);
    }

    private Caja hayCajaLibres(Caja[] cajas) {
        int numeroCaja = 0;
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i].isEstaVacia()) {
                numeroCaja = i;
            }
        }
        return cajas[numeroCaja];
    }

    private int obtenerTodosLosQueDeberianSalir(Cola colaComparacion) {
        int cuantosDeberianSalir = 0;
        for (int i = 0; i < colaComparacion.getPersonas().length; i++) {
            if (colaComparacion.getPersonas()[i].getRound() == 1) {
                cuantosDeberianSalir++;
            }
        }
        return cuantosDeberianSalir;
    }

    private void decrementarTodos(Cola colaComparacion) {
        for (int i = 0; i < colaComparacion.getPersonas().length; i++) {
            if (colaComparacion.getPersonas()[i].getRound() != 1 || colaComparacion.getPersonas()[i].getRound() != 0) {
                colaComparacion.getPersonas()[i].setRound(colaComparacion.getPersonas()[i].getRound() - 1);
            } else {
                System.out.println("");
            }
        }
    }

    private void aumentarTiempo(Cola colaComparacion) {
        for (int i = 0; i < colaComparacion.getPersonas().length; i++) {
            if (!colaComparacion.getPersonas()[i].isAtendido()) {
                colaComparacion.getPersonas()[i].
                        setTiempoEnCola(colaComparacion.getPersonas()[i].getTiempoEnCola() + 1);
            }
        }
    }

    private ArrayList<Persona> personasSalen(Cola colaComparacion, Cola colaComparacionPrioridad) {
        ArrayList<Persona> personasSalen = new ArrayList<Persona>();
        for (int i = 0; i < colaComparacion.getPersonas().length; i++) {
            if (!colaComparacion.getPersonas()[i].isAtendido()) {
                personasSalen.add(colaComparacion.getPersonas()[i]);
            }
        }
        for (int i = 0; i < colaComparacionPrioridad.getPersonas().length; i++) {
            if (!colaComparacionPrioridad.getPersonas()[i].isAtendido()) {
                personasSalen.add(colaComparacionPrioridad.getPersonas()[i]);
            }
        }
        return personasSalen;
    }
}
