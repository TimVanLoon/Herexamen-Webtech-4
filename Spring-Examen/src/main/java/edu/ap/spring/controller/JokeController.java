package edu.ap.spring.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import edu.ap.spring.jpa.Joke;

@Controller
@Scope("session")
public class JokeController {
   
	String getURL = "http://api.icndb.com/jokes/random";
	
	
   public JokeController() {
   }
       
   @RequestMapping("/joke")
   public String joke(Model model) {
	   RestTemplate restTemplate = new RestTemplate();
	   HashMap<Joke,Map> answer = restTemplate.getForObject(getURL, new HashMap<>().getClass());
	   String jokeRaw = answer.values().toString();
	   String joke = jokeRaw.substring(24, jokeRaw.indexOf('.'));
	   System.out.println(joke);
	   
	   return "joke";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post() {
	   return "";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
