package com.github.gustavoaos.logviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogViewerApplication.class, args);

		// System.out.println(">> codenation123 encrypted:" + (new BCryptPasswordEncoder().encode("codenation123")).toString());
		// System.out.println(">> codenation321 encrypted:" + (new BCryptPasswordEncoder().encode("codenation321")).toString());
	}

}
