package com.company.operaciones;

import com.company.modelos.Persona;

import java.util.ArrayList;

public class OperacionesSobreArchivo {
    public double obtenerTiempoPromedioEspera(ArrayList<Persona> personasLista) {
        int acumulador = 0;
        for (int i = 0; i < personasLista.size(); i++) {
            acumulador = acumulador + personasLista.get(i).getTiempoEnCola();
        }
        return acumulador / personasLista.size();
    }

    public double obtenerTiempoPromedioTramite(ArrayList<Persona> personasLista) {
        int acumulador = 0;
        for (int i = 0; i < personasLista.size(); i++) {
            acumulador = acumulador + personasLista.get(i).getTiempo();
        }
        return acumulador / personasLista.size();
    }

    public double obtenerTiempoPromedioTotal(ArrayList<Persona> personasLista) {
        int acumulador = 0;
        int acumuladorTramite = 0;
        for (int i = 0; i < personasLista.size(); i++) {
            acumulador = acumulador + personasLista.get(i).getTiempoEnCola();
            acumuladorTramite = acumulador + personasLista.get(i).getTiempo();
        }
        return (acumulador + acumuladorTramite) / personasLista.size();
    }
}
