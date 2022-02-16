package com.mrpapaia.desafioCapgemini.questao01;

public class Escada {

	public void imprimeEscada(Integer n) {
		for (int i = 0; i < n; i++) {
			for (int j = n; j >= 0; j--) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
