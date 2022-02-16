package com.mrpapaia.desafioCapgemini;

import java.util.Scanner;

import com.mrpapaia.desafioCapgemini.questao01.Escada;
import com.mrpapaia.desafioCapgemini.questao02.AjudanteDeSenha;
import com.mrpapaia.desafioCapgemini.questao03.Anagrama;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		Integer op = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (op >= 0) {				
				System.out.print("1 - QUESTÂO 1\n"
						+ "2 - QUESTÂO 2\n"
						+ "3 - QUESTÂO 3\n"
						+ "0 - SAIR\n");			
				System.out.print("Escolha uma opção: ");
				op = sc.nextInt();
				switch (op) {
				case 0:
					op = -1;
					break;
				case 1:
					System.out.println("Informe o tamanho da escada:");
					Escada escada =new Escada();
					escada.imprimeEscada(sc.nextInt());
					break;
				case 2:
					System.out.println("Informe a senha para analise:");
					AjudanteDeSenha ajudanteSenha= new AjudanteDeSenha();
					System.out.println(ajudanteSenha.validarSenha(sc.next()));
					break;
				case 3:
					System.out.println("Informe a palavra:");
					Anagrama anagrama= new Anagrama();
					System.out.println(anagrama.contarAnagramas(sc.next()));
					break;
				default:
					break;
				}
			}
		}
	}
}
