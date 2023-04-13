package br.edu.infnet.donationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DonationappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationappApplication.class, args);
	}

}
