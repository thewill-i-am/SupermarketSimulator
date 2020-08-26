package com.company.tda;

import com.company.modelos.Persona;
import com.company.ui.UIUtils;

public class Cola {
    Persona[] personas;
    private int tamanio = 0;

    public Persona getHead() {
        return personas[head];
    }

    private int head = -1;
    private int tail = -1;

    public Cola(int tamanio){
        this.tamanio = tamanio;
        personas = new Persona[tamanio];
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    private boolean isFull() {
        if (head == 0 && tail == this.tamanio - 1) {
            return true;
        }
        if (head == tail + 1) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (tail == -1)
            return true;
        else
            return false;
    }

    public void enQueue(Persona newPersona) {
        UIUtils ui = new UIUtils();
        try {
            if (isFull()) {
                throw new Exception("La cola esta llena");
            } else {
                if (head == -1)
                    head = 0;
                tail = (tail + 1) % this.tamanio;
                personas[tail] = newPersona;
            }
        }catch (Exception e){
            ui.print(e.getMessage());
        }
    }

    public Persona deQueue() throws Exception {
        UIUtils ui = new UIUtils();
        try {
            Persona persona;
            if (isEmpty()) {
                throw new Exception("La cola esta vacia");
            } else {
                persona = personas[head];
                if (head == tail) {
                    head = -1;
                    tail = -1;
                }
                else {
                    head = (head + 1) % this.tamanio;
                }
            }
            return persona;
        }catch (Exception e){
            ui.print(e.getMessage());
        }
        return null;
    }
}

