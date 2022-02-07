package com.josemanuel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SuperCalculadoraTest { //Este archivo es un test para probar el programa y ver si funciona correctamente
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach //Esta sentencia se ejecuta siempre antes de iniciar el Test
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test //Este es el test principal
    @DisplayName("Test entrada a Menú de Aritmética, opción A")
    public void testCasoMenuAritmetica() {
       
        provideInput("A\n1\n10\n33\nX\nX");
        //Este test realiza lo siguiente: se selecciona la opcion "A"(Aritmética), a continuacion la opción "1" (Operación suma), introduce los números 10 y 23. Finalmente sale del submenú "X" y acaba el programa "X"
        
        SuperCalculadora.main(new String[0]);
        assertThat(getOutput(), containsString("Resultado: 43") ); //Aquí se indica el resultado que se debe obtener del test para saber que se realiza correctamente
        
    }

    @AfterEach //Se ejecuta siempre al finalizar un test
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }



}
