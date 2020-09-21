package com.assign.task;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void actuatorEndpointContainsGitInformation() {
    this.webTestClient
      .get()
      .uri("/version")
      .exchange()
      .expectBody()
      .jsonPath("$.lastcommitsha").isNotEmpty()
      .jsonPath("$.description").isNotEmpty()
      .jsonPath("$.version").isNotEmpty();

  }

}
