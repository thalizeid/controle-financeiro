package br.com.fintech.torre.teste;

import br.com.fintech.torre.util.CriptografiaUtils;

public class TesteCriptografia {
	
	public static void main (String[] args) {
		try {
			System.out.println(
					CriptografiaUtils.criptografar("1234568"));
			System.out.println(
					CriptografiaUtils.criptografar("1234568"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
