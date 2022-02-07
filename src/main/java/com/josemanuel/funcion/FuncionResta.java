package com.josemanuel.funcion;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;



public class FuncionResta implements Function<Scanner, Void>{

    @Override
    public Void apply(Scanner sc) { //A esta función se accede desde el programa principal, concretamente desde la linea 46
        
        System.out.println("\nOperación seleccionada resta:\n");
        System.out.println("A - B\n");
        
        System.out.println("Introduzca A:");
        String aStr = sc.next();
        BigDecimal aBD = new BigDecimal(aStr);

        System.out.println("Introduzca B:");
        String bStr = sc.next();
        BigDecimal bBD = new BigDecimal(bStr);

        System.out.println("\nResultado: " + aBD.subtract(bBD).toString() + "\n");

        return null;
    }

}
