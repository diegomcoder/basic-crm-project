package com.diegomd.basiccrmproject;

import com.diegomd.basiccrmproject.repository.ProductRepository;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		ProductRepository productRepository = new ProductRepository();

//		Product product = new Product();
//		product.setName("Women's Classic Tapered Jean");
//		product.setDescription("High rise jean sits at natural waist with functional pockets, easy zipper fly, belt loops and slight taper leg for the fit you love.");
//		product.setPrice(199.99);
//		product.setImageUrl("https://m.media-amazon.com/images/I/71K-DiwFxOL._AC_SX569_.jpg");
//
//		productRepository.save(product);
//		System.out.println(productRepository.findById(1));

		System.out.println();

		// TODO: Product Repository's Delete Method
		productRepository.deleteById(2);
		productRepository.findAll().forEach(System.out::println);
	}

}



/*

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

*/
