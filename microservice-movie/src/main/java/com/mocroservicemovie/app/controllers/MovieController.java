package com.mocroservicemovie.app.controllers;

import javax.websocket.server.PathParam;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mocroservicemovie.app.dto.MovieDto;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@GetMapping("/getMovies")
	public MovieDto getMovies() {

		MovieDto movieDto = new MovieDto();
		movieDto.setMovieName("test name");

		return movieDto;

	}

	@GetMapping("/getMovies/{movieId}")
	public MovieDto getMoviesById(@PathVariable("movieId") int movieId) {

		MovieDto movieDto = new MovieDto();
		movieDto.setMovieName("test name - " + movieId);

		return movieDto;

	}
	
	@PostMapping("/postMoviesById")
	public MovieDto postMoviesById(@RequestBody MovieDto movieDto) {

		MovieDto rmovieDto = new MovieDto();
		rmovieDto.setMovieName("test name - " + movieDto.getMovieName());

		return rmovieDto;

	}

}
