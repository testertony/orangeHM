package com.ejemplos;

public class Humano {
	
	
	// State
	Double altura;
	Double peso;
	String sexo;
	String colorCabello;
	
	// Constructors
	public Humano() {
	}
	
	public Humano(Double altura, Double peso, String sexo, String colorCabello){
		this.altura = altura;
		this.peso = peso;
		this.sexo = sexo;
		this.colorCabello = colorCabello;
	}
	
	// Metodo	
	public void Caminar() {
		System.out.println("esta camindando");
	}
	
}
