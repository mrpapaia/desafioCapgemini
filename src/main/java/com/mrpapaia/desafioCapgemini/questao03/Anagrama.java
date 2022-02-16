package com.mrpapaia.desafioCapgemini.questao03;

import java.util.ArrayList;
import java.util.List;

public class Anagrama {

	public Integer contarAnagramas(String palavra) {
		List<Integer[]> posicoes = verificarLetrasRepetidas(palavra);
		return contarSubString(posicoes);

	}

	public List<Integer[]> verificarLetrasRepetidas(String palavra) {		
		List<Integer[]> posicoes = new ArrayList<Integer[]>();
		for (int i = 0; i < palavra.length(); i++) {
			for (int j = i + 1; j < palavra.length(); j++) {
				if (Character.toLowerCase(palavra.charAt(i)) == Character.toLowerCase(palavra.charAt(j))) {
					Integer[] aux = new Integer[2];
					aux[0] = i;
					aux[1] = j;
					posicoes.add(aux);
				}
			}
		}

		return posicoes;
	}

	public Integer contarSubString(List<Integer[]> posicoes) {
		Integer aux = 0;
		if (posicoes.size() == 1) {
			return 3;
		}
		for (int i = 0; i < posicoes.size(); i++) {

			if (posicoes.get(i)[1] - posicoes.get(i)[0] > 1) {
				aux += 2;
			} else {
				aux++;
			}

		}
		return aux;

	}

}
