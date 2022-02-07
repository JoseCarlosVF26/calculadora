package com.josemanuel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.josemanuel.funcion.FuncionArea;
import com.josemanuel.funcion.FuncionExitMenu;
import com.josemanuel.funcion.FuncionResta;
import com.josemanuel.funcion.FuncionSuma;
import com.josemanuel.menu.ExitMenuException;
import com.josemanuel.menu.ItemMenu;
import com.josemanuel.menu.Menu;

public class SuperCalculadora 
{

    public SuperCalculadora() { //Aquí creamos el constructor de la clase
        sc = new Scanner(System.in);
        this.inicializaMenus();
    }

    private Scanner sc;
    private Menu menuPrincipal;

    public static void main( String[] args ) 
    {
        SuperCalculadora superCalculadora = new SuperCalculadora(); //Instanciamos la clase creada anteriormente
        
        try {
            superCalculadora.getMenuPrincipal().bucle(); //Se genera el menú principal junto a un bucle
        } catch(ExitMenuException eme) { //Este es el comando encargado de salir del bucle
            System.out.println("FIN SUPERCALCULADORA");
            superCalculadora.getSc().close(); //Cerramos el programas y finalizamos la ejecución
        }

    }
 
    private void inicializaMenus() {
        
        String introOpc = "Introduzca opción:";
        ItemMenu itemMenuExit = new ItemMenu("Salir", new FuncionExitMenu()); //Instanciamos una clase con un String "salir" y una función que hace que retrocedamos en el menú o salgamos de él
        
        Map<String, ItemMenu> mapItemMenuAritmetica = new HashMap<String, ItemMenu>();
        mapItemMenuAritmetica.put("1", new ItemMenu("Operación suma", new FuncionSuma())); //Si pulsamos "1" nos mandaria a la función "FuncionSuma" y en ella se ejecutaria el resto del programa
        mapItemMenuAritmetica.put("2", new ItemMenu("Operación resta", new FuncionResta())); //En este caso con "2" iriamos a "FuncionResta" y ya en ella se realizaría las acciones necesarias
        mapItemMenuAritmetica.put("X", itemMenuExit); //Esta es la opción para salir al menú principal

        Menu menuAritmetica = new Menu("Menú de Aritmética", introOpc, mapItemMenuAritmetica, this.sc); //Se instancia el menu y por lo tanto se ejecuta las lineas 44 a la 47

        
        Map<String, ItemMenu> mapItemMenuAreaPi = new HashMap<String, ItemMenu>();
        mapItemMenuAreaPi.put("1", new ItemMenu("Área polígono regular", new FuncionArea())); //En este menú con la opción "1" podemos ir a la función "FuncionArea"
        mapItemMenuAreaPi.put("X", itemMenuExit); //Esta opción se encarga de retroceder al menú principal
        //mapItemMenuAreaPi.put("2", new ItemMenu("Tm. de Pitágoras", new FuncionResta())); //Esta linea se encuentra comentada y por lo tanto no podríamos acceder a la opción T. Pitágora

        Menu menuAreaPi = new Menu("Menú de área y Tm. de Pitágoras", introOpc, mapItemMenuAreaPi, this.sc);
        
        Map<String, ItemMenu> mapItemMenuPrincipal = new HashMap<String, ItemMenu>(); //Aquí se crea el menú principal y se ejecuta
        mapItemMenuPrincipal.put("A", new ItemMenu("Aritmética", menuAritmetica)); //Si selecionamos la opción "A" pasariamos a la linea 49
        mapItemMenuPrincipal.put("B", new ItemMenu("Área polígono regular y Tm. de Pitágoras", menuAreaPi)); //Con esta opción se ejecuta la linea 52 y con ella el submenú
        mapItemMenuPrincipal.put("X", itemMenuExit); //Opcion para abandonar el programa

        this.menuPrincipal = new Menu("Menú principal de Supercalculadora", introOpc, mapItemMenuPrincipal, this.sc);

    }

    public Menu getMenuPrincipal() { //Este es el método para pintar el menú principal
        return menuPrincipal;
    }

    public Scanner getSc() {
        return sc;
    }

}
