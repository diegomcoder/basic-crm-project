package com.diegomd.basiccrmproject;

public class Main {

	public static void main(String[] args) {

		Client client1 = new Client("David", "Osborne", "Junior",
				12345678910L, "davidosborne@some.com", "(62) 233 4567",
				"13/08/1987", "States avn 127st", Genders.M);

		Client client2 = new Client("John", "Von", "Newman",
				12345678910L,"email@email.com", "927 234", "29/11/1995",
				"endereço", Genders.M);


		ClientBuilder clientWithIdentification = new ClientBuilder().withIdentification(
				"David","Osborne","Junior", "123.456.789-10",
				"13/08/1987",Genders.M);

		ClientBuilder client4 = new ClientBuilder().withContactInfo("davidosborne@some.com",
				"States avn 127st", "(62) 233 4567");

		ClientBuilder client5 = new ClientBuilder().withIdentification("David", "Osborne", "Junior",
				"123.456.789-10", "13/08/1987", Genders.M);

		System.out.printf(client1.toString());
		System.out.println(client2);
		System.out.println(clientWithIdentification);
		System.out.println(client4.toStringContactInfo());
		System.out.println(client5.toStringPersonalData());

	}

}
