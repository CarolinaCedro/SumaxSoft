package io.github.CarolinaCedro.sumaxSoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SumaxSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SumaxSoftApplication.class, args);
	}

}
