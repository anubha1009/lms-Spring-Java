package com.lms.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.lms.books"})
public class LmsBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsBooksApplication.class, args);
	}

}
