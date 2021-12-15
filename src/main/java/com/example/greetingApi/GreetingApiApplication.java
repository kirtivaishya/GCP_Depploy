package com.example.greetingApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class GreetingApiApplication {
  ArrayList<String> quotes =new ArrayList<String>(List.of("everything is possible","you are the limit for yourself"));
	public static void main(String[] args) {
		SpringApplication.run(GreetingApiApplication.class, args);
	}

	@GetMapping("/quotes")
	ArrayList<String> getGreetings(){
	return quotes;
	}

	@GetMapping("/quotes/{id}")
	String getGreetings(@PathVariable int id){
		return quotes.get(id);
	}

	@PostMapping("/quotes")
	public ArrayList<String> createQuote(@RequestBody String quote){
		quotes.add(quote);
		return quotes;
	}
}
