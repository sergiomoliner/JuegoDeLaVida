package hiberusjuegovida;

import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class HiberusJuegoVida {

    public static void main(String[] args) throws InterruptedException {
        //Solicitamos que introduzcan el número de casillas del tablero
        System.out.println("Introduce el número de casillas del tablero");
        Scanner sc = new Scanner(System.in);
        int casillas = sc.nextInt();
        Vida vida = new Vida(casillas);
        
        //Llamamos a los metodos
        vida.pintarTablero();
        while (true) {
            //Tiempo en ms que transcurre entre la impresion de una gen y otra
            Thread.sleep(1200);
            vida.nuevaGen();
            vida.pintarTablero();
        }
    }
    
}
