package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {
		@Id
	    @GeneratedValue
	    private Long id;
		
		@Column
		private String joke;
		
		public Joke() {
			
		}
		
		public Joke(String joke) {
			this.joke = joke;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getJoke() {
			return joke;
		}

		public void setJoke(String joke) {
			this.joke = joke;
		}

		@Override
		public String toString() {
			return "Joke [id=" + id + ", joke=" + joke + "]";
		}
		
		
}
