package com.delalama.backingtracks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BackingtracksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackingtracksApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {

	}
}
