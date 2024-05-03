package com.example.onetoone;

import com.example.onetoone.Repository.CityRepository;
import com.example.onetoone.Repository.CountryRepository;
import com.example.onetoone.oneToMany.City;
import com.example.onetoone.oneToMany.Country;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Arrays;
@EntityScan
@SpringBootApplication
@ToString
public class OneToOneApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Country country = new Country();

		country.setName("Turkey");
		City city1 = new City();
		city1.setName("Ankara");
		city1.setCountry(country);

		City city2 = new City();
		city2.setName("Izmir");
		city2.setCountry(country);

		City city3 = new City();
		city3.setName("Istanbul");
		city3.setCountry(country);

		City city4 = new City();
		city4.setName("Adana");
		city4.setCountry(country);

		City city5 = new City();
		city5.setName("Mersin");
		city5.setCountry(country);

		country.setCities(Arrays.asList(city1, city2, city3, city4, city5));


		Country savedCountry = countryRepository.save(country);
		System.out.println(savedCountry);

	}
}
