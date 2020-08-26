package com.company.acessodatos;

import com.company.modelos.GestorColas;
import com.company.modelos.Persona;
import com.company.tda.Cola;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcesadorTexto extends FileProcessor {
    public ProcesadorTexto(String fileName) {
        super(fileName);
    }

    @Override
    protected GestorColas readLines(Scanner reader) throws FileNotFoundException {
        GestorColas gestorColas = new GestorColas();
        int minuto = 1;
        int contadorNormal = 0;
        int contadorPrioridad = 0;
        while (reader.hasNextLine()) {
            String onePersona = reader.nextLine();
            String[] currentPersona = getPersonaFromString(onePersona);
            contadorNormal = contadorNormal + Integer.parseInt(currentPersona[0]);
            contadorPrioridad = contadorPrioridad + Integer.parseInt(currentPersona[1]);
        }
        Cola cola = new Cola(contadorNormal);
        Cola colaPrioridad = new Cola(contadorPrioridad);
        Scanner reader2 = openFile();
        while (reader2.hasNextLine()) {
            String onePersona = reader2.nextLine();
            String[] currentPersona = getPersonaFromString(onePersona.concat(","+ minuto));
            if (Integer.parseInt(currentPersona[0]) != 0){
                for (int i = 0; i < Integer.parseInt(currentPersona[0]); i++) {
                    Persona persona = new Persona();
                    persona.setTiempo();
                    persona.setTieneDiscapacidad(false);
                    persona.setRound(minuto);
                    cola.enQueue(persona);
                }
            }
            if (Integer.parseInt(currentPersona[1]) != 0){
                for (int i = 0; i < Integer.parseInt(currentPersona[1]); i++) {
                    Persona persona = new Persona();
                    persona.setTiempo();
                    persona.setTieneDiscapacidad(true);
                    persona.setRound(minuto);
                    colaPrioridad.enQueue(persona);
                }
            }
            minuto++;
        }
        gestorColas.setColaNormal(cola);
        gestorColas.setColaPrioridad(colaPrioridad);
        return gestorColas;
    }


    private String[] getPersonaFromString(String personaData) {
        String[] cantidadPersona = new String[2];
        String[] data = personaData.split(",");
        cantidadPersona[0] = data[0];
        cantidadPersona[1] = data[1];
        return cantidadPersona;
    }
}
