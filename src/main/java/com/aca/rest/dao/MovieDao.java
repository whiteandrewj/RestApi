package com.aca.rest.dao;

import java.util.ArrayList;
import java.util.List;
import com.aca.rest.model.Movie;

public class MovieDao {

	private static List<Movie> movies = new ArrayList<Movie>();
	
	static {
		movies.add(new Movie("The World is Not Enough", "action", "12/12/2012", 98));
		movies.add(new Movie("Logan", "action", "11/11/11", 67));
		movies.add(new Movie("Lego: Batman", "family", "10/10/10", 80));
	}
	
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		movies.addAll(MovieDao.movies);
		
		return movies;
	}
	
	public List<Movie> getMoviesByGenre(String genre) {
		List<Movie> movies = new ArrayList<Movie>();
		for ( Movie movie : MovieDao.movies) {
			if (movie.getGenre().equals(genre)) {
				movies.add(movie);
			}
		}
		return movies;
	}
}
