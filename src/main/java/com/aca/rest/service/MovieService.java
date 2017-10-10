package com.aca.rest.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.aca.rest.dao.MovieDao;
import com.aca.rest.model.Movie;

public class MovieService {
	
	public List<Movie> getAllMovies() {
		
		MovieDao dao = new MovieDao();
		return dao.getAllMovies();
	}
	
	public List<Movie> getMoviesByGenre(String genre) {
		validateGenre(genre);
		MovieDao dao = new MovieDao();		
		return dao.getMoviesByGenre(genre);
	}

	private boolean validateGenre(String genre) {
		if (genre.equals("action") || genre.equals("family")) {
			return true;
		} else {
			Response response = Response.status(400)
				.entity("invalid response for genre '" + genre + "', valid values are Action, Family")
				.build();
			throw new WebApplicationException(response);
		}
	}
}
