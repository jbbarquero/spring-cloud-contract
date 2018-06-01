package com.malsolo.springframework.cloud.contract.frauddetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FraudDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudDetectionApplication.class, args);
	}
}

@RestController
class FraudController {

	@GetMapping("/fraud")
	ResponseEntity<List<String>> fraud() {
		return ResponseEntity.status(201).body(Arrays.asList("Javier", "Beneito"));
	}

}
