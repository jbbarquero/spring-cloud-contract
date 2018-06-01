package com.malsolo.springframework.cloud.contract.carrental;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8081)
public class CarRentalApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test_should_return_all_frauds() {
		String json = "{\"Javier\", \"Beneito\"}";

		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/frauds"))
				.willReturn(WireMock.aResponse().withBody(json).withStatus(201)));

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity = restTemplate
				.getForEntity("http://localhost:8081/frauds", String.class);

		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(201);
		BDDAssertions.then(entity.getBody()).isEqualTo(json);

	}
}
