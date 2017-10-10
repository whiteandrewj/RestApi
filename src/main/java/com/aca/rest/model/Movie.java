package com.aca.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "movie")
public class Movie {
	
	@XmlElement( name = "title")
	private String title;
	
	@XmlElement( name = "genre")
	private String genre;
	
	@XmlElement( name = "releasedate")
	private String releaseDate;
	
	@XmlElement( name = "score")
	private int score;
	
	//a "no argument" constructor is needed for jersey/jaxb
	public Movie() {
	}
	
	public Movie(String title, String genre, String releasedate, int score) {
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.score = score;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	//tells jersey to ignore the getter method as an element, otherwise will get a 500 error because there are "duplicate" elements
	@XmlTransient
	public String getGenre() {
		return genre;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
