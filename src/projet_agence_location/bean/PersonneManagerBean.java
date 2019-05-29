package projet_agence_location.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.hibernate.Session;

import projet_agence_location.model.Admin;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;
import projet_agence_location.service.IPersonneService;
import projet_agence_location.service.impl.PersonneService;
import projet_agence_location.util.HibernateUtil;

@ManagedBean(name = "personneManager")
public class PersonneManagerBean {
	
	IPersonneService personneService = new PersonneService();
	
	private Personne personne ;
	private Personne personneSelected;


	
	/**
	 * @return the personneSelected
	 */
	public Personne getPersonneSelected() {
		return personneSelected;
	}


	/**
	 * @param personneSelected the personneSelected to set
	 */
	public void setPersonneSelected(Personne personneSelected) {
		this.personneSelected = personneSelected;
	}


	/**
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}


	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	
	@PostConstruct
	public void initTable(){
		Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		personne = new Client();
		personneSelected = new Personne();
	}
	
	public void updateToEdit(Personne currentPersonne) {
		personne = personneSelected;
	}
	
	
	public List<Personne> getListPersonne(){
		return personneService.findAll(Personne.class);
	}
	
	public List<Client> getListClient(){
		return personneService.findAllClient();
	}
	
	public List<Admin> getListAdmin(){
		return personneService.findAllAdmin();
	}
	
	public void save() {
		System.out.println(personne.toString());
		personneService.addObject(personne);
	}
	
	public void edit() {
		personne.setId_personne(personneSelected.getId_personne());
		personneService.editPersonne(personne);
	}
	
	public void delete() {
		personne.setId_personne(personneSelected.getId_personne());
		personneService.deleteObject(personne);
	}
}
