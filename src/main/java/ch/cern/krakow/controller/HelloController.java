package ch.cern.krakow.controller;

import ch.cern.krakow.service.CommunicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

  private final CommunicationService communicationService;

  public HelloController(CommunicationService communicationService) {
    this.communicationService = communicationService;
  }

  @GetMapping("/czesc")
  public String sayHi() {
    return "czesc";
  }

  @PostMapping("/czesc")
  public String sendHi(Model model) {
    String communicationAnswer = communicationService.sayHi();
    model.addAttribute("helloAnswer", communicationAnswer);
    return "czesc";
  }
}
