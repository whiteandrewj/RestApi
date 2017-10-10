package com.aca.rest.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.aca.rest.model.Movie;
import com.aca.rest.service.MovieService;


/**
 * The controller classes/methods are identified in the web.xml file.
 *The 'Path' annotation maps to the URL's path resources.
 *The 'GET' annotation identifies the HTTP method that is accepted.
 *The 'Produces' annotation identifies the MEdia Types (e.g. json, text, xml, etc) that this class/method can produce
 *
 *This class/method ill only accept a request with the following
 *1. HTTP Get
 *2. path '/RestApiApp/rest/movie'
 *3. HTTP header Accept = application/xml
 *
 */

@Path("/movie")
public class MovieController {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Movie> getAllMovies() {
		
		MovieService service = new MovieService();
		List<Movie> movies = service.getAllMovies();
		
		return movies;
	}
	
	@Path("/genre/{genreValue}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Movie> getMoviesByGenre(@PathParam("genreValue") String genre) {
		
		MovieService service = new MovieService();
		List<Movie> movies = service.getMoviesByGenre(genre);		
			
		return movies;
	}

}
