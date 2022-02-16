package com.mrpapaia.desafioCapgemini.questao03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class AnagramaTest {

	@Test
	public void testAnagramaSucesso() {
		Anagrama anagrama = mock(Anagrama.class);
		List<Integer[]> list = new ArrayList<Integer[]>();
		Integer[][] aux = { { 0, 3 }, { 8, 9 } };
		list.add(aux[0]);
		list.add(aux[1]);
		doCallRealMethod().when(anagrama).contarAnagramas(Mockito.anyString());
		when(anagrama.verificarLetrasRepetidas(Mockito.anyString())).thenReturn(list);
		when(anagrama.contarSubString(Mockito.anyListOf(Integer[].class))).thenReturn(3);	
		assertEquals(Integer.valueOf(3), anagrama.contarAnagramas("ifailuhkqq"));
		verify(anagrama, times(1)).contarSubString(list);
		verify(anagrama, times(1)).verificarLetrasRepetidas("ifailuhkqq");
	}
	
	@Test
	public void testAnagramaFalha() {
		Anagrama anagrama = mock(Anagrama.class);
		List<Integer[]> list = new ArrayList<Integer[]>();
		Integer[][] aux = { { 0, 3 }, { 8, 9 } };
		list.add(aux[0]);
		list.add(aux[1]);
		doCallRealMethod().when(anagrama).contarAnagramas(Mockito.anyString());
		when(anagrama.verificarLetrasRepetidas(Mockito.anyString())).thenReturn(list);
		when(anagrama.contarSubString(Mockito.anyListOf(Integer[].class))).thenReturn(3);		

		assertNotEquals(Integer.valueOf(0), anagrama.contarAnagramas("ifailuhkqq"));
		verify(anagrama, times(1)).contarSubString(list);
		verify(anagrama, times(1)).verificarLetrasRepetidas("ifailuhkqq");
	}

	@Test
	public void testContarSubStringCom3Caracteres() {
		Anagrama anagrama = new Anagrama();
		List<Integer[]> list = new ArrayList<Integer[]>();
		Integer[] aux = { 0, 2 };
		list.add(aux);
		assertEquals(Integer.valueOf(3), anagrama.contarSubString(list));
	}

	@Test
	public void testContarSubString() {
		Anagrama anagrama = new Anagrama();
		List<Integer[]> list = new ArrayList<Integer[]>();
		Integer[][] aux = { { 0, 3 }, { 8, 9 } };
		list.add(aux[0]);
		list.add(aux[1]);
		assertEquals(Integer.valueOf(3), anagrama.contarSubString(list));
	}

	@Test
	public void testComLetrasRepetidas() {
		Anagrama anagrama = new Anagrama();
		assertEquals(Integer.valueOf(2), Integer.valueOf(anagrama.verificarLetrasRepetidas("ifailuhkqq").size()));
	}

	@Test
	public void testSemLetrasRepetidas() {
		Anagrama anagrama = new Anagrama();
		assertEquals(Integer.valueOf(0), Integer.valueOf(anagrama.verificarLetrasRepetidas("abcde").size()));
	}

}
