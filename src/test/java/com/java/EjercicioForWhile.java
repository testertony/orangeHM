package com.java;

import java.util.Scanner;

public class EjercicioForWhile {
	public static void main (String[] args) {
		
		Scanner sn = new Scanner(System.in);
		
        System.out.println("Inserta un numero mayor que 1");
        int num;
        
        do{
        num=sn.nextInt();  
        if(num<=1);
        System.out.println("Error");
        }while(num<=1);
        
        
        int suma=0;
                
        for(int contador5=1;contador5<=num;contador5++){
            suma+=contador5;
        }
        System.out.println("La suma es "+suma);
	}        
}
