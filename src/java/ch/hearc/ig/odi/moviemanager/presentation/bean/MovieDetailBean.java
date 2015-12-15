package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Backing Bean pour personDetail.xhtml
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
// nom de la page
@Named(value = "movieDetailBean")

// enregistré sur la session
@SessionScoped
public class MovieDetailBean implements Serializable {
    
    private Movie movie;

    /**
     * récupère le film à détailler
     * 
     * @param movie le film
     * @return retourn si c'est réussit ou échoué
     */
    public String getMovieToDetail(final Movie movie) {
        if(movie != null) {
            this.movie = movie;
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * récupère le film à détailler
     * 
     * @return le film
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * modifie le film
     * 
     * @param movie  le film
     */
    public void setMovie(final Movie movie) {
        this.movie = movie;
    }
}
