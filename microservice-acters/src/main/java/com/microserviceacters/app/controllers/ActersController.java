package com.microserviceacters.app.controllers;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microserviceacters.app.dto.ActersDto;
import com.microserviceacters.app.dto.MovieDto;

@RestController
@RequestMapping("/acters")
public class ActersController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/moviesList")
	public MovieDto getMovies() {

		System.out.println("in");
		MovieDto movieDto = restTemplate.getForObject("http://movie-microservice/movie/getMovies", MovieDto.class);

		return movieDto;

	}

	@GetMapping("/moviesListById")
	public MovieDto getMovies(@PathParam("movieId") int movieId) {

		System.out.println(movieId);

		MovieDto sendMovieDto = new MovieDto();
		sendMovieDto.setMovieName("" + movieId);

//		MovieDto movieDto = restTemplate.getForObject("http://movie-microservice/movie/getMovies/" + movieId,
//				MovieDto.class);

		MovieDto movieDto = restTemplate.postForObject("http://movie-microservice/movie/postMoviesById", sendMovieDto, MovieDto.class);

		return movieDto;

	}

}
