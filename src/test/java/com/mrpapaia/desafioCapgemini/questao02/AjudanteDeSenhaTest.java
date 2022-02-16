package com.mrpapaia.desafioCapgemini.questao02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class AjudanteDeSenhaTest {
	private AjudanteDeSenha ajudanteDeSenhaMock;

	@Before
	public void setUp() {
		ajudanteDeSenhaMock = mock(AjudanteDeSenha.class);
	}

	@Test
	public void testSenhaValida() {
		
		doCallRealMethod().when(ajudanteDeSenhaMock).validarSenha(Mockito.anyString());
		when(ajudanteDeSenhaMock.verificarTamanho(Mockito.anyInt())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarCaracterEspecial(Mockito.anyString())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMaiscula(Mockito.anyString())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMinuscula(Mockito.anyString())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarSeExisteNumero(Mockito.anyString())).thenReturn(true);
		assertEquals(Integer.valueOf(0),ajudanteDeSenhaMock.validarSenha("ABc1@a"));
	}
	@Test
	public void testSenhaNaoCumpreNenhumRequisito() {
		
		doCallRealMethod().when(ajudanteDeSenhaMock).validarSenha(Mockito.anyString());
		when(ajudanteDeSenhaMock.verificarTamanho(Mockito.anyInt())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarCaracterEspecial(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMaiscula(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMinuscula(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteNumero(Mockito.anyString())).thenReturn(false);		
		assertEquals(Integer.valueOf(5),ajudanteDeSenhaMock.validarSenha(" "));
	}
	
	@Test
	public void testSenhaSoContemNumeros() {
		
		doCallRealMethod().when(ajudanteDeSenhaMock).validarSenha(Mockito.anyString());
		when(ajudanteDeSenhaMock.verificarTamanho(Mockito.anyInt())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarCaracterEspecial(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMaiscula(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMinuscula(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteNumero(Mockito.anyString())).thenReturn(true);			
		assertEquals(Integer.valueOf(3),ajudanteDeSenhaMock.validarSenha(" "));
		verify(ajudanteDeSenhaMock,times(1)).verificarTamanho(Mockito.anyInt());
		verify(ajudanteDeSenhaMock,times(1)).verificarCaracterEspecial(Mockito.anyString());
		verify(ajudanteDeSenhaMock,times(1)).verificarSeExisteLetraMaiscula(Mockito.anyString());
		verify(ajudanteDeSenhaMock,times(1)).verificarSeExisteLetraMinuscula(Mockito.anyString());
		verify(ajudanteDeSenhaMock,times(1)).verificarSeExisteNumero(Mockito.anyString());
	}
	
	@Test
	public void testSenhaSoContemLetras() {
		
		doCallRealMethod().when(ajudanteDeSenhaMock).validarSenha(Mockito.anyString());
		when(ajudanteDeSenhaMock.verificarTamanho(Mockito.anyInt())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarCaracterEspecial(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMaiscula(Mockito.anyString())).thenReturn(false);
		when(ajudanteDeSenhaMock.verificarSeExisteLetraMinuscula(Mockito.anyString())).thenReturn(true);
		when(ajudanteDeSenhaMock.verificarSeExisteNumero(Mockito.anyString())).thenReturn(false);			
		assertEquals(Integer.valueOf(3),ajudanteDeSenhaMock.validarSenha(" "));
		verify(ajudanteDeSenhaMock,times(1)).verificarTamanho(Mockito.anyInt());
		verify(ajudanteDeSenhaMock,times(1)).verificarCaracterEspecial(Mockito.anyString());
		verify(ajudanteDeSenhaMock,times(1)).verificarSeExisteLetraMaiscula(Mockito.anyString());
		verify(ajudanteDeSenhaMock,times(1)).verificarSeExisteLetraMinuscula(Mockito.anyString());
		verify(ajudanteDeSenhaMock,times(1)).verificarSeExisteNumero(Mockito.anyString());
	}
	
	@Test
	public void verificarTamanhoMaiorQue() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertTrue(ajudanteDeSenha.verificarTamanho(7));
	}

	@Test
	public void verificarTamanhoMenorQue() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarTamanho(2));
	}

	@Test
	public void testExisteLestraMaiscula() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertTrue(ajudanteDeSenha.verificarSeExisteLetraMaiscula("abC"));
	}
	@Test
	public void testNaoExisteLestraMaiscula() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarSeExisteLetraMaiscula("abc"));
	}

	@Test
	public void testNaoExisteLestraMaisculaUsandoEspaco() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarSeExisteLetraMaiscula(" abc "));
	}
	
	
	@Test
	public void testExisteLestraMinuscula() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertTrue(ajudanteDeSenha.verificarSeExisteLetraMinuscula("abC"));
	}
	@Test
	public void testNaoExisteLestraMinuscula() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarSeExisteLetraMinuscula("ABC"));
	}

	@Test
	public void testNaoExisteLestraMinusculaUsandoEspaco() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarSeExisteLetraMinuscula(" ABC1 "));
	}
	
	@Test
	public void testExisteNumero() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertTrue(ajudanteDeSenha.verificarSeExisteNumero("abC1@"));
	}
	@Test
	public void testNaoExisteNumero() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarSeExisteNumero("ABC@"));
	}
	@Test
	public void testExisteCaractereEspecial() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertTrue(ajudanteDeSenha.verificarCaracterEspecial("ABC@"));
	}
	
	@Test
	public void testNaoExisteCaractereEspecial() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();
		assertFalse(ajudanteDeSenha.verificarCaracterEspecial("ABC"));
	}
	
/*	@Test
	public void testSenhaValida() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertEquals(Integer.valueOf(0),ajudanteDeSenha.validarSenha("ABc1@a"));
	}
	@Test
	public void testSenhaInvalidaSemCaractereEspecial() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertFalse(ajudanteDeSenha.validarSenha("ABca1a").equals(0));
	}
	@Test
	public void testSenhaInvalidaSemNumero() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertFalse(ajudanteDeSenha.validarSenha("ABca@a").equals(0));
	}	

	
	@Test
	public void testSenhaInvalidaSemLetraMaiscula() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertFalse(ajudanteDeSenha.validarSenha("abca@a1").equals(0));
	}
	@Test
	public void testSenhaInvalidaSemLetraMinuscula() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertFalse(ajudanteDeSenha.validarSenha("ABCDE1@").equals(0));
	}
	
	@Test
	public void testSenhaInvalidaSemTamanhoMinimo() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertFalse(ajudanteDeSenha.validarSenha("A1@").equals(0));
	}
	
	@Test
	public void testSenhaInvalidaSemTamanhoMinimo2() {
		AjudanteDeSenha ajudanteDeSenha = new AjudanteDeSenha();		
		assertFalse(ajudanteDeSenha.validarSenha("A1@a").equals(0));
	}
	*/
	
}
