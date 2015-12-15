package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
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
@Named(value = "peopleBean")
// enregistré sur la session
@RequestScoped
public class PeopleBean implements Serializable {
    
    private DataModel<Person> people;
    
    @Inject
    private Services services;
    
    /**
     * récupère la liste des personnes
     * 
     * @return liste des personnes
     */
    public DataModel<Person> getPeople() {
        people = new ListDataModel<>();
        people.setWrappedData(services.getPeopleList());
        
        return people;
    }
}
