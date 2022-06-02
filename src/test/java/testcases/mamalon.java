package testcases;

import java.util.Scanner;

public class mamalon {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        int numero[] = new int[10], memoria = 0;//la memoria es por si alguien elige un numero en el 10 y luego lo quiere desplazar para atras
        boolean activador8 = false, activador9 = false; // para indicar si se coloco un numero ahi (8 es 9 y 9 es 10)
        
        System.out.println("Almacenando numeros.");
        for(int i=0; i<8;i++){
            System.out.print("Digite el "+(i+1)+" numero: ");
            numero[i] = entrada.nextInt();
        }
        
        int eleccion, banca;// Eleccion es la posicion que digite el usario y banca el numero que quiere insertar
        for(int i=0; i<2; i++){
            
            do{
                System.out.print("Indique la posicion en la que desea digitar el numero: ");
                eleccion = entrada.nextInt();
                if(eleccion <1 || eleccion>10){
                    System.out.println("\nLa posicion debe ser del 1 al 10\n");
                }
                }while(eleccion <1 || eleccion>10);
                eleccion--; //para que se le haga comodo al usario digitar la posicion.
                
                System.out.print("Digite un numero: ");
                banca = entrada.nextInt();
            
                if(eleccion<=7){ // En caso de que la posicion sea 8 para abajo
                    for(int j = 0; j<eleccion;j++){ //Esto es el mecanismo para reccorer hacia atras la posicion de los numeros desde la posicion del usario
                    numero[j] = numero[(j+1)]; // es como si 2 se fuera 1 y 3 se fuera a 2 etc
                 }
                  numero[eleccion] = banca;
                } 
                
                else if(eleccion>7 && activador8 == false && activador9 == false){
                 numero[eleccion] = banca;
                    if(eleccion==8){
                        activador8 = true;
                    }
                    else if(eleccion==9){
                        activador9 = true;
                        memoria+=banca;
                    }
                   }
                
                else if(eleccion==8 && activador9 == true){
                    numero[eleccion] = banca;
                }    
                else if(eleccion==8 && activador8 == true){
                    for(int j = 0; j<eleccion;j++){ //Esto es el mecanismo para reccorer hacia atras la posicion de los numeros desde la posicion del usario
                    numero[j] = numero[(j+1)]; // es como si 2 se fuera 1 y 3 se fuera a 2 etc
                 }
                  numero[eleccion] = banca;                
                }
                else if(eleccion==9 && activador8 == true){
                    numero[eleccion] = banca;
                }
                else if(eleccion==9 && activador9 == true){
                    numero[8]= memoria;
                    numero[9]= banca;
                }  
        }        
        System.out.println("Orden del arreglo");
        for (int i = 0; i < 10; i++) {
            System.out.print(numero[i]+" ");
        }
    }

	}

