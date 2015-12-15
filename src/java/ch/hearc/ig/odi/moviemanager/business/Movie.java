package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.*;

/**
 * Classe permettant la gestion de films.
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
public class Movie {

    private Map<Long, Person> people;
    private Long id;
    private String name;
    private String producer;

    /**
     * constructeur des films
     * 
     * @param id id du film
     * @param name nom du film
     * @param producer producteur du film
     */
    public Movie(final Long id, final String name, final String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.people = new LinkedHashMap<>();
    }
    
    /**
     * ajout des personnes dans la liste de ceux qui ont vu le film
     * 
     * @param person personne à ajouter
     * @throws UniqueException si personne déjà dans la liste
     */
    public void addPerson(final Person person) throws UniqueException {
        if(people.containsKey(person.getId())) {
            throw new UniqueException("Cette personne à déjà vu ce film.");
        }
        
        people.put(person.getId(), person);
        
        try {
            person.addMovie(this);
        }catch(UniqueException ex) {
        }
    }

    /**
     * revoie l'id du film
     * 
     * @return id du film
     */
    public Long getId() {
        return this.id;
    }

    /**
     * modifie l'id d'un film
     * 
     * @param id id du film
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * revoie le nom du film
     * 
     * @return nom du film
     */
    public String getName() {
        return this.name;
    }

    /**
     * modifie le nom du film
     * 
     * @param name nom du film
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * renvoie le producteur
     * 
     * @return producteur du film
     */
    public String getProducer() {
        return this.producer;
    }

    /**
     * modifie le producteur
     * 
     * @param producer producteur du film
     */
    public void setProducer(final String producer) {
        this.producer = producer;
    }

    /**
     * renvoie combien de personne a vu le film
     * 
     * @return nombre de personne
     */
    public int getPeopleNumber() {
        return people.size();
    }
    
    /**
     * liste des gens qui ont vu le film
     * 
     * @return liste de personne
     */
    public List<Person> getPeople() {
        return new ArrayList<>(people.values());
    }
}
