package com.wongnai.interview.movie.search;

import java.util.ArrayList;
import java.util.List;

import com.wongnai.interview.movie.external.MovieData;
import com.wongnai.interview.movie.external.MoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MovieDataService;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {
	@Autowired
	private MovieDataService movieDataService;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 2 => Implement this method by using data from MovieDataService
		// All test in SimpleMovieSearchServiceIntegrationTest must pass.
		// Please do not change @Component annotation on this class

        List<Movie> moviesList = new ArrayList<>();
        MoviesResponse moviesResponse = movieDataService.fetchAll();
        for(MovieData movieData : moviesResponse){
            String movieTitle = movieData.getTitle();
            String parts[] = movieTitle.toLowerCase().split(" ");
            for(String word : parts){
                if(word.equals(queryText.toLowerCase())){
                    moviesList.add(new Movie(movieData));
                    continue;
                }
            }
        }
		return moviesList;
	}
}
