package com.posgrado.ecommerce;

import com.posgrado.ecommerce.entity.Category;
import com.posgrado.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/*
		Category category1 = new Category();
		category1.setName("SPORT");
		category1.setDescription("Mochilas deportivas");

		Category category2 = new Category();
		category2.setName("TRAVEL");
		category2.setDescription("Mochilas para viajar");

		Category categoryResult1 = categoryRepository.save(category1);
		Category categoryResult2 = categoryRepository.save(category2);

		System.out.println(categoryResult1.getId().toString());
		System.out.println(categoryResult2.getId().toString());
		*/
	}
}

