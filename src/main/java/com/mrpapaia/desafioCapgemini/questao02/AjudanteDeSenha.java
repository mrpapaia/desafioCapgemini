package com.mrpapaia.desafioCapgemini.questao02;

public class AjudanteDeSenha {
	public Integer validarSenha(String senha) {		
			Integer caracteresAdicionais = 0;			
			if (!verificarTamanho(senha.length())) {
				caracteresAdicionais= 6 - senha.length();
				if(caracteresAdicionais>=3) {
					return caracteresAdicionais;
				} 
			} 
			if (!verificarSeExisteLetraMaiscula(senha)) {				
				caracteresAdicionais++;
			}
			if (!verificarSeExisteLetraMinuscula(senha)) {				
				caracteresAdicionais++;
			}
			if (!verificarSeExisteNumero(senha)) {				
				caracteresAdicionais++;
			}
			if (!verificarCaracterEspecial(senha)) {				
				caracteresAdicionais++;
			}			
			return caracteresAdicionais;		
	}

	public boolean verificarTamanho(Integer tamanhoSenha) {
		return tamanhoSenha >= 6;
	}

	public boolean verificarSeExisteLetraMaiscula(String senha) {
		for (int i = 0; i < senha.length(); i++) {
			if ((int) senha.charAt(i) >= 65 && (int) senha.charAt(i) <= 90) {
				return true;
			}
		}
		return false;
	}

	public boolean verificarSeExisteLetraMinuscula(String senha) {
		for (int i = 0; i < senha.length(); i++) {
			if ((int) senha.charAt(i) >= 97 && (int) senha.charAt(i) <= 122) {
				return true;
			}
		}
		return false;
	}

	public boolean verificarSeExisteNumero(String senha) {
		for (int i = 0; i < senha.length(); i++) {
			if ((int) senha.charAt(i) >= 48 && (int) senha.charAt(i) <= 57) {
				return true;
			}
		}
		return false;
	}

	public boolean verificarCaracterEspecial(String senha) {
		String caracteresEspeciais = "!@#$%^&*()-+";
		for (int i = 0; i < senha.length(); i++) {
			for (int j = 0; j < caracteresEspeciais.length(); j++) {
				if (senha.charAt(i) == caracteresEspeciais.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

}
