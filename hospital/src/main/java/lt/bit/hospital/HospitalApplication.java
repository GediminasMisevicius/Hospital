package lt.bit.hospital;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lt.bit.hospital.recipe.RecipePdfWriter;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
		
		System.out.println("PASILEIDZIA beveik, bet nesipullina");
	}
}
