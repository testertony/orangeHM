package com.ejemplos;

public class Main {

	public static void main(String[] args) {
		
		Humano Montana = new Humano(); 
		Montana.altura = 1.80;
		Montana.peso = 85.5;
		Montana.sexo = "masculino";
		Montana.colorCabello = "negro";
		
		System.out.println("El sexo de Montana es: "+ Montana.sexo + " dice el");
		
	
		Humano erick = new Humano(1.80, 80.5, "masculino",  "negro");
		System.out.println("El sexo de Erick es: " + erick.sexo);
		
		System.out.print("Erick ");
		erick.Caminar();
		
	}

}
