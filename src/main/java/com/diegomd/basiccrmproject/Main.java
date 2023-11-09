package com.diegomd.basiccrmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		Client firstClient = new Client("David", "Osborne", "Junior",
				12345678910L, "davidosborne@some.com", 62_233_4567L,
				"13/08/1987", "States avn 127st", Genders.MASCULINE);
		System.out.printf(firstClient.toString());

		ClientBuilder clientWithIdentification = new ClientBuilder().withIdentification(
				"David","Osborne","Junior", 12345678910L,
				"13/08/1987",Genders.MASCULINE);

//		Client stClient = new Client("John", "Vonn", "Newmann", 12345678910L,
//				22_4525_3232L, 32, "23/09/1947", "Street 4, nt avenue",Genders.MASCULINE);
//
//		System.out.println(stClient);
		/*
		Se eu não me engano, existe um método isEmpty para objetos String
		* */
	}

}
