package io.project.cryptography.web.controller;

import io.project.cryptography.service.CaeserCipherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaesarCipherController {
	
   @Autowired
   CaeserCipherService caeserCipherService;
   
   @PostMapping("/api/v1/shift")
   public String ceaserchiper(@RequestBody CsesarCipherInput input) {
	   
	   return caeserCipherService.process(input.getShift(), input.getText());
	   
   }
	
   @GetMapping("/api/v1/hello")
   public String test() {
	   return "Hello";
   }

}
