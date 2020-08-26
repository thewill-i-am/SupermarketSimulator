package com.company.ejecutables;

import com.company.operaciones.OperacionesSobreArchivo;
import com.company.acessodatos.ProcesadorTexto;
import com.company.logica.GestorCajaXCola;
import com.company.modelos.Caja;
import com.company.modelos.GestorColas;
import com.company.modelos.Persona;
import com.company.ui.UIUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        GestorCajaXCola gestorCajaXCola = new GestorCajaXCola();
        UIUtils uiUtils = new UIUtils();
        OperacionesSobreArchivo operacionesSobreArchivo = new OperacionesSobreArchivo();
        ArrayList<Persona> listaPersonasSalen = new ArrayList<Persona>();
        ArrayList<Persona> listaPersonasQuedan = new ArrayList<Persona>();
        Caja[] cajas = uiUtils.llenarCaja();

        System.out.println("Empieza la simulacion .........................");
        System.out.println("Empieza la simulacion .........................");
        System.out.println("Empieza la simulacion .........................");

        ProcesadorTexto procesadorTexto =
                new ProcesadorTexto
                        ("src/com/company/Datos.txt");
        GestorColas gestorColas = procesadorTexto.processFile();

        listaPersonasQuedan =   gestorCajaXCola.anadirPersonaACaja
                    (cajas, gestorColas.getColaNormal(), gestorColas.getColaPrioridad(), listaPersonasSalen, listaPersonasQuedan);


        System.out.println("Simulacion terminada");

        System.out.println();
        System.out.println("Resultados son: ");
        System.out.println();
        System.out.println("Tiempo Promedio Personas en espera Cola " + operacionesSobreArchivo.obtenerTiempoPromedioEspera(listaPersonasSalen));
        System.out.println("Tiempo Promedio Personas de tramite Cola " + operacionesSobreArchivo.obtenerTiempoPromedioTramite(listaPersonasSalen));
        System.out.println("Tiempo Promedio de " + operacionesSobreArchivo.obtenerTiempoPromedioTotal(listaPersonasSalen));
        System.out.println("Tiempo Promedio Personas en espera Cola " + operacionesSobreArchivo.obtenerTiempoPromedioEspera(listaPersonasQuedan));
        System.out.println();


    }
}
