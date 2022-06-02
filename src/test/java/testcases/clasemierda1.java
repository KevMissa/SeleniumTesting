package testcases;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class clasemierda1 {

	    Scanner entrada = new Scanner(System.in);
	     private int tablero[][] = new int[10][10];
	     private boolean meta = false;
	     char movimiento;
	     private int posX =1;
	     private int posY =8;

	    public void preparar(){
	        for(int i=0; i<10; i++){
	            for(int j=0; j<10;j++){
	                if(i==0 || i==9){
	                    tablero[i][j] = 1;
	                }
	                else if(j==0 || j==9){
	                    tablero[i][j] = 1;
	                }
	                else{
	                    tablero[i][j] = 0;
	                }
	            }
	        }
	        tablero[8][1] = 3;
	        tablero[0][8] = 4;
	    }



	    public void jugar(){
	        JOptionPane.showMessageDialog(null,"Para jugar y ver el tablero es desde la consola de comandos xd");

	        while(meta == false){
	            for(int i=0; i<10; i++){
	                for(int j=0; j<10;j++){
	                    System.out.print(tablero[i][j]+" ");
	                }
	                System.out.println();
	            }

	            System.out.print("\nDigite un movimiento: ");
	            movimiento = entrada.next().charAt(0);

	            switch (movimiento){
	                case 'w','W':
	                    if(tablero[(posY-1)][posX] == 1){
	                        JOptionPane.showMessageDialog(null, "No se puede ir mas arriba.");
	                    }
	                    else if(tablero[(posY-1)][posX] == 4){
	                        meta = true;
	                    }
	                    else{
	                        tablero[(posY-1)][posX] = 3;
	                        tablero[(posY)][posX] = 0;
	                        posY--;
	                    }
	                    break;
	                case 's','S':
	                    if(tablero[(posY+1)][posX] == 1){
	                        JOptionPane.showMessageDialog(null, "No se puede ir mas abajo.");
	                    }
	                    else{
	                        tablero[(posY+1)][posX] = 3;
	                        tablero[(posY)][posX] = 0;
	                        posY++;
	                    }
	                    break;
	                case 'a','A':
	                    if(tablero[posY][(posX-1)] == 1){
	                        JOptionPane.showMessageDialog(null, "No se puede ir mas a la izquierda.");
	                    }
	                    else{
	                        tablero[posY][(posX-1)] = 3;
	                        tablero[(posY)][posX] = 0;
	                        posX--;
	                    }
	                    break;
	                case 'd','D':
	                    if(tablero[posY][(posX+1)] == 1){
	                        JOptionPane.showMessageDialog(null, "No se puede ir mas a la derecha.");
	                    }
	                    else{
	                        tablero[posY][(posX+1)] = 3;
	                        tablero[(posY)][posX] = 0;
	                        posX++;
	                    }
	            }
	        }
	        JOptionPane.showMessageDialog(null,"Gracias por jugar :)");
	    }
	    public void mostrartablero(){
	        for(int i=0; i<10; i++){
	            for(int j=0; j<10;j++){
	                System.out.print(tablero[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }

	    public void tutorial(){
	        JOptionPane.showMessageDialog(null, "Bienvenido a algo mejor que lol");
	        JOptionPane.showMessageDialog(null, "Instrucciones:\nTu seras representado con un 3\n" +
	                "La meta sera el 4.\nLas paredes son los 1");
	        JOptionPane.showMessageDialog(null, "Movimiento:\n" +
	                "W: Moverse una casilla ariba.\nS: Moverse una casilla abajo.\nA: Moverse una casilla a la izquierda\n" +
	                "D: Moverse una casilla a la derecha.");
	    }
	}

