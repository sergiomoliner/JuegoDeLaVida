/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberusjuegovida;


/**
 *
 * @author Sergio
 */
class Vida {
    private int dimension;
    private boolean[][]tablero;
    private int generacion;

    public Vida() {
    }

    public Vida(int dimension) {
        this.dimension = dimension;
        this.tablero = tablero;
        this.generacion = generacion;
        crearTablero();
    }
       
    //Creamos el tablero y posicionamos las celulas
    private void crearTablero() {
        boolean[][]nuevoTablero = new boolean[dimension][dimension];
        for (int i = 0; i < nuevoTablero.length; i++) {
            for (int j = 0; j < nuevoTablero[i].length; j++) {
                nuevoTablero[i][j] = (Math.random() < 0.3);
            }
        }
        tablero = nuevoTablero;
    }
    
    //Pintamos el tablero en consola
    public void pintarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j]==(true)) {
                    System.out.print("O");
                }else{
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Nueva generación: "+generacion);
    }
    
    //Siguientes generaciones
    public void nuevaGen(){
        boolean[][] nuevoTablero = new boolean[dimension][dimension];
        for (int i = 0; i < nuevoTablero.length; i++) {
            for (int j = 0; j < nuevoTablero[i].length; j++) {
                nuevoTablero[i][j] = celulasViva(i, j);
            }
        }
        tablero = nuevoTablero;
        generacion++;
    }

    //Planteamos las condiciones para saber si la celula esta viva (true) o muerta (false)
    private boolean celulasViva(int i, int j) {
        int contador = 0;
        boolean celulaViva = tablero[i][j];
        
        for (int k = -1; k <= 1; k++) {
            int fila = i+k;
            if (fila<0) {
                fila = dimension -1;
            }else if (fila>=dimension) {
                fila = 0;
            }
            for (int l = -1; l <= 1; l++) {
                int columna = j+l;
                if (columna < 0) {
                    columna = dimension -1;
                }else if(columna>=dimension){
                    columna = 0;
                }
                
                if (tablero[fila][columna]) {
                    contador++;
                }
            }
        }
        
        //Una célula viva con menos de 2 células vecinas muere por soledad     
        //Una célula viva con 2 o 3 células vecinas vivas sigue viva
        //Una célula viva con más de 3 células vecinas muere por superpoblación
        //Una célula muerta con exactamente 3 células vecinas vivas "nace" (es decir, al turno siguiente estará viva).
        if (celulaViva) {
            contador--;
        }
        
        if (contador == 2 && celulaViva || contador == 3) {
            return true;
        } else {
            return false;
        }
    }
}
