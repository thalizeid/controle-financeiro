package br.com.fintech.torre.teste;

import br.com.fintech.torre.bo.EmailBO;

public class TesteEnviarEmail {
	
	public static void main (String[] args) {
		try {
			
			EmailBO m = new EmailBO();
			
			m.enviarEmail("thalita.zeid@gmail.com", "Teste", "test body ");
			
			System.out.println("Mail sent");

			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
