package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.*;

/**
 * gestion des personnes
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
public class Person {

    private Map<Long, Movie> movies;
    private Long id;
    private String firstName;
    private String lastName;

    /**
     * constructeur des personnes
     * 
     * @param id id
     * @param firstName prénom
     * @param lastName nom
     */
    public Person(final Long id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = new LinkedHashMap<>();
    }
    
    /**
     * ajoute le film à la liste des films vu
     * 
     * @param movie film à ajouter
     * @throws UniqueException si déjà dans la liste
     */
    public void addMovie(final Movie movie) throws UniqueException {
        if(movies.containsKey(movie.getId())) {
            throw new UniqueException("Ce film a déjà été vu par cette personne.");
        }
        
        movies.put(movie.getId(), movie);
        
        try {
            movie.addPerson(this);
        }catch(UniqueException ex) {
        }
    }
    
    /**
     * retourne l'id de la personne
     * 
     * @return id de la personne
     */
    public Long getId() {
        return this.id;
    }

    /**
     * modifie l'id de la personne
     * 
     * @param id id de la personne
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * renvoie le prénom de la personne
     * 
     * @return prénom de la personne
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * modifie le prénom de la personne
     * 
     * @param firstName prénom de la personne
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * renvoie le nom de la personne
     * 
     * @return nom de la personne
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * modifie le nom de la personne
     * 
     * @param lastName nom de la personne
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * renvoie combien de film à vu la personne
     * 
     * @return nombre de personne
     */
    public int getMoviesNumber() {
        return movies.size();
    }
    
    /**
     * liste de film vu 
     * 
     * @return liste de film
     */
    public List<Movie> getMovies() {
        return new ArrayList<>(movies.values());
    }
}
