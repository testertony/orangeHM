package com.interview;

import java.util.Scanner;

public class Interview {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);			
		
		
		System.out.println("Cual es su nombre?");
		String nombre = entrada.nextLine();
		
		System.out.println("Cual es su edad?");
		String apellido = entrada.nextLine();
		
		System.out.println("Su nombre es " + nombre + " " + apellido);
		
	}
		
	
}
