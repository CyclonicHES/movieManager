package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing Bean pour createMovie.xhtml
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
// nom de la page
@Named(value = "createMovieBean")

//mémoriser sur la session
@RequestScoped
public class CreateMovieBean implements Serializable {
    
    private Long id;
    private String name;
    private String producer;
    
    @Inject
    private Services service;
    
    /**
     * enregistrer le nouveau film
     * 
     * @return retourn si c'est réussit ou échoué
     */
    public String submit() {
        try {
            service.saveMovie(id, name, producer);
            return "success";
        } catch(UniqueException ex) {
            return "failure";
        }
    }

    /**
     * renvoe l'id du film
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * modifie l'id
     * 
     * @param id id du film
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * renvoie le nom du film
     * 
     * @return nom du film
     */
    public String getName() {
        return name;
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
     * renvoie le producteur du film
     * 
     * @return producteur du film
     */
    public String getProducer() {
        return producer;
    }

    /**
     * modifie le producteur du film
     * 
     * @param producer producteur du film
     */
    public void setProducer(final String producer) {
        this.producer = producer;
    }
}
