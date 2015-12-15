package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 * Backing Bean pour personDetail.xhtml
 *
 * @author Alexandre Daidié <alexandre.daidie@he-arc.ch>
 */
// nom de la page
@Named(value = "personDetailBean")
// enregistré sur la session
@SessionScoped
public class PersonDetailBean implements Serializable {
    
    private Person person;

    /**
     * récupère la personne
     * 
     * @param person  la personne
     * @return retourn si c'est réussit ou échoué
     */
    public String getPersonToDetail(final Person person) {
        if(person != null) {
            this.person = person;
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * récupère la personne
     * 
     * @return La personne
     */
    public Person getPerson() {
        return person;
    }

    /**
     * modifie la personne
     * 
     * @param person La nouvelle
     */
    public void setPerson(final Person person) {
        this.person = person;
    }
    
}
