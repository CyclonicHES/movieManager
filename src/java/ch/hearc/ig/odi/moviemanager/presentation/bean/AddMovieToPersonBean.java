package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing Bean pour addMovieToPerson.xhtml
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
// nom de la page
@Named(value = "addMovieToPersonBean")

// mémorisé pour la session
@SessionScoped
public class AddMovieToPersonBean implements Serializable {
    
    private Person person;
    private DataModel<Movie> movies;
    

    @Inject
    private Services service;
    
    /**
     * liste des films que la personne n'a pas vu
     * 
     * @return liste des films
     */
    public DataModel<Movie> getMovies() {
        List<Movie> unseenMovies = new LinkedList<>(service.getMoviesList());
        
        for(Movie seenMovie : person.getMovies()) {
            if(unseenMovies.contains(seenMovie)) {
                unseenMovies.remove(seenMovie);
            }
        }
        
        movies = new ListDataModel<>();
        movies.setWrappedData(unseenMovies);
        
        return movies;
    }

    /**
     * ajoute les films à une personne
     * 
     * @param movie le film
     * @return retourn si c'est réussit ou échoué
     */
    public String addMovie(final Movie movie) {
        try {
            if(movie == null) {
                return "failure";
            }
            
            person.addMovie(movie);
            return "success";
        }catch(UniqueException ex) {
            return "failure";
        }
    }
    
    /**
     * reçois la personne pour affecter à un film
     * 
     * @param person la personne
     * @return retourn si c'est réussit ou échoué
     */
    public String getPerson(final Person person) {
        if(person != null) {
            this.person = person;
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * renvoie la personne pour qui va être ajouter à un film
     * 
     * @return la personne
     */
    public Person getPerson() {
        return person;
    }

    /**
     * modifie la personne pour ajouter à un film
     * 
     * @param person la personne
     */
    public void setPerson(final Person person) {
        this.person = person;
    }

}
