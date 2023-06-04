package com.ayseozcan.SBstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bu sinifin bir spring boot uygulamasina ait oldugu ve gerekli
 * olan bagimliliklarin buradan itibaren tarandigi belirtiliyor.
 */
@SpringBootApplication
public class SBstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBstartApplication.class, args);
	}

}
