package com.diegomd.basiccrmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicCrmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicCrmProjectApplication.class, args);
		Client stClient = new Client("John", "Vonn", "Newmann", 12345678910L,
				22_4525_3232L, 32, "23/09/1947", "Street 4, nt avenue",Genders.MASCULINE);

		System.out.println(stClient);
	}

}
