package edu.ap.spring.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;

@Controller
@Scope("session")
public class JokeController {
   
	 @Autowired
	 JokeRepository repository;
	
   public JokeController() {
   }
       
   @RequestMapping("/joke")
   public String joke() {
	   
	   return "joke";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post(@RequestParam("firstName") String firstName, 
		   @RequestParam("firstName") String lastName, Model model) {
	   
	   String getURL = "http://api.icndb.com/jokes/random?firstName=" + firstName + "&lastame=" + lastName;
	   System.out.println(getURL);
	   
	   RestTemplate restTemplate = new RestTemplate();
	   HashMap<Joke,Map> answer = restTemplate.getForObject(getURL, new HashMap<>().getClass());
	   String jokeRaw = answer.values().toString();
	   String joke = jokeRaw.substring(24, jokeRaw.indexOf('.'));
	   model.addAttribute("joke", joke);
	   
	   Joke existingJoke = repository.findByJoke(joke);
	   if(existingJoke == null) {
		   Joke newJoke = new Joke(joke);
		   repository.save(newJoke);
		   repository.findAll().forEach(System.out::println);
	   }
	   
	   return "result";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
