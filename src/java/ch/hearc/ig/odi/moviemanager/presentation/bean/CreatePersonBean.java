package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.services.Services;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing Bean pour createPerson.xhtml
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
// nom de la page
@Named(value = "createPersonBean")

// enregistrer sur la session
@RequestScoped
public class CreatePersonBean {
    
    private Long id;
    private String firstName;
    private String lastName;
    
    @Inject
    private Services service;
    
    /**
     * enregistre la personne
     * 
     * @return retourn si c'est réussit ou échoué
     */
    public String submit() {
        try {
            service.savePerson(id, firstName, lastName);
            return "success";
        } catch(UniqueException ex) {
            return "failure";
        }
    }

    /**
     * renvoie l'id de la personne
     * 
     * @return id de la peronne
     */
    public Long getId() {
        return id;
    }

    /**
     * modifie l'id de la personne
     * 
     * @param id id de la peronne
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * renvoie le présnom de la personne
     * 
     * @return prénom de la personne
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * modifie le prénom de la personne
     * 
     * @param firstName  prénom de la personne
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
        return lastName;
    }

    /**
     * modifie le nom de la personne
     * 
     * @param lastName  nom de la personne
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
}
