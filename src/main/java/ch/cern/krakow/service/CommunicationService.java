package ch.cern.krakow.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommunicationService {

  private final RestTemplate restTemplate;

  public CommunicationService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String sayHi() {
    return restTemplate.getForObject("/bonjour", String.class);
  }
}
