package com.company.ui;

import com.company.modelos.Caja;
import com.company.modelos.Persona;

import java.io.PrintStream;
import java.util.Scanner;

public class UIUtils {

    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);

    public Caja[] llenarCaja() throws Exception {
        output.println("Escriba la cantidad de cajas");
        int cantindadCajas = input.nextInt();
        Caja[] cajas = new Caja[cantindadCajas];
        for (int i = 0; i < cantindadCajas; i++) {
            System.out.println("Va llenar informacion de la caja "+ (i+1));
            Caja caja = new Caja();
            caja.setNumeroCaja(i+1);
            caja.setEstaVacia(true);
            output.println("Escriba true si es nueva, escriba false si tiene mas experiencia");
            caja.setEsNueva(input.nextBoolean());
            cajas[i] = caja;
        }
        return cajas;
    }

    public void print(String serializado){
        output.print(serializado);
    }
}