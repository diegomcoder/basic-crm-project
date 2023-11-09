package com.diegomd.basiccrmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		Client firstClient = new Client("David", "Osborne", "Junior",
				12345678910L, "davidosborne@some.com", "(62) 233 4567",
				"13/08/1987", "States avn 127st", Genders.MASCULINE);

		ClientBuilder clientWithIdentification = new ClientBuilder().withIdentification(
				"David","Osborne","Junior", 12345678910L,
				"13/08/1987",Genders.MASCULINE);

		ClientBuilder client2 = new ClientBuilder().withContactInfo("davidosborne@some.com",
				"States avn 127st", "(62) 233 4567");

		ClientBuilder client3 = new ClientBuilder().withIdentification("David", "Osborne", "Junior",
				12345678910L, "13/08/1987", Genders.MASCULINE);

		System.out.printf(firstClient.toString());
		System.out.println(clientWithIdentification);
		System.out.println(client2.toStringContactInfo());
		System.out.println(client3.toStringPersonalData());

	}

}
