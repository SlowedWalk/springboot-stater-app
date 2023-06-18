package tech.hidetora.security.controller.demo;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Hidden
public class DemoController {

  @GetMapping("/api/v1/demo-controller")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

  @GetMapping
  public ResponseEntity<String> welcome() {
    return ResponseEntity.ok("Welcome To The Spring Boot Starter Application.");
  }

}
