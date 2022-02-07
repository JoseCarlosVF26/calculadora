package com.josemanuel.funcion;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

public class FuncionArea implements Function<Scanner, Void>{

    @Override
    public Void apply(Scanner sc) {
        
        System.out.println(" P * A / 2");
        
        System.out.println("Introduzca (P)erímetro:");
        String pStr = sc.next();
        BigDecimal pBD = new BigDecimal(pStr);

        System.out.println("Introduzca (A)potema:");
        String aStr = sc.next();
        BigDecimal aBD = new BigDecimal(aStr);

        System.out.println("Resultado" + pBD.multiply(aBD).divide(BigDecimal.valueOf(2)).toString()); //Se pinta la palabra "Resultado" junto con el resultado de multiplicar las dos variables pedidas y dividirla entre 2

        return null; //En todo la función se usan las variables de tipo "BigDecimal"
    }

    
}
