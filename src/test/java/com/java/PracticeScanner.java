package com.java;

import java.util.Scanner;

public class PracticeScanner {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Cual es tu nombre?");
		
		String nombre = entrada.nextLine();
		
		System.out.println("Cual es tu apellido");
		
		String apellido = entrada.nextLine();
		System.out.println("Mi nombre es: " + nombre + " "+ apellido);
		
	}
}