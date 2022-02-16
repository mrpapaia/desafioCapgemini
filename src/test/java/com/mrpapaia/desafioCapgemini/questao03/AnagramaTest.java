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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AnagramaTest {

	private Anagrama anagramaMock;

	@Before
	public void setUp() {
		anagramaMock = mock(Anagrama.class);
	}

	@Test
	public void testAnagramaSucesso() {

		List<Integer[]> list = new ArrayList<Integer[]>();
		Integer[][] aux = { { 0, 3 }, { 8, 9 } };
		list.add(aux[0]);
		list.add(aux[1]);
		doCallRealMethod().when(anagramaMock).contarAnagramas(Mockito.anyString());
		when(anagramaMock.verificarLetrasRepetidas(Mockito.anyString())).thenReturn(list);
		when(anagramaMock.contarSubString(Mockito.anyList())).thenReturn(3);
		assertEquals(Integer.valueOf(3), anagramaMock.contarAnagramas("ifailuhkqq"));
		verify(anagramaMock, times(1)).contarSubString(list);
		verify(anagramaMock, times(1)).verificarLetrasRepetidas("ifailuhkqq");
	}

	@Test
	public void testAnagramaFalha() {

		List<Integer[]> list = new ArrayList<Integer[]>();
		Integer[][] aux = { { 0, 3 }, { 8, 9 } };
		list.add(aux[0]);
		list.add(aux[1]);
		doCallRealMethod().when(anagramaMock).contarAnagramas(Mockito.anyString());
		when(anagramaMock.verificarLetrasRepetidas(Mockito.anyString())).thenReturn(list);
		when(anagramaMock.contarSubString(Mockito.anyList())).thenReturn(3);

		assertNotEquals(Integer.valueOf(0), anagramaMock.contarAnagramas("ifailuhkqq"));
		verify(anagramaMock, times(1)).contarSubString(list);
		verify(anagramaMock, times(1)).verificarLetrasRepetidas("ifailuhkqq");
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
