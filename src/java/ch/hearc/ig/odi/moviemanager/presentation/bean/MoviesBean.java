package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing Bean pour index.xhtml
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
// nom de la page
@Named(value = "moviesBean")
// enregistré sur la session
@RequestScoped
public class MoviesBean implements Serializable {
    
    private DataModel<Movie> movies;
    
    @Inject
    private Services service;
    
    /**
     * récupère la liste des films
     * 
     * @return la liste des films
     */
    public DataModel<Movie> getMovies() {
        movies = new ListDataModel<>();
        movies.setWrappedData(service.getMoviesList());
        
        return movies;
    }
}
