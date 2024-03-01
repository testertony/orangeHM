package com.EjerciciosDePrueba2024;

public class TablasMultiplicar {
	
	public static void main(String[] args) {
	
		int mult;
	
		for(int i = 1; i <= 30; i++) {
			for(int j = 1; j <= 100; j++) {
				mult = i * j;
				System.out.println(i + " * " + j + " = " + mult);
		}
			System.out.println();
		}
	
	}

}

