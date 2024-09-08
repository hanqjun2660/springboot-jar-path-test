package com.example.springbootjarpathtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootjarpathtestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjarpathtestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// InputStream을 사용하지 않고 file에 접근하는 경우
		try {
			File file = new File("src/main/resources/static/dir/text.txt");
			String content = new String(Files.readAllBytes(file.toPath()));
			System.out.println("File content (without InputStream): " + content);
		} catch (Exception e) {
			System.out.println("Error reading file without InputStream: " + e.getMessage());
		}

		// InputStream을 사용하고 file에 접근한 경우
		try {
			InputStream inputStream = getClass().getResourceAsStream("static/dir/text.txt");
			Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8.name());
			String content = sc.useDelimiter("\\A").next();
			System.out.println("File content (without InputStream): " + content);
		} catch (Exception e) {
			System.out.println("Error reading file with InputStream: " + e.getMessage());
		}

		// String으로 경로 받아오기
		try {
			String resourcePath = getClass().getResource("/static/dir/text.txt").getPath();

			if(resourcePath == null) {
				System.out.println("Resource path not found");
				return;
			}

			System.out.println("File path: " + resourcePath);
		} catch (Exception e) {
			System.out.println("Error file path: " + e.getMessage());
		}
	}
}
