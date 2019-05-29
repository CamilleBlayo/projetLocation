package projet_agence_location.service.impl;

import java.util.ArrayList;
import java.util.List;

import projet_agence_location.dao.IPersonneDao;
import projet_agence_location.dao.impl.PersonneDao;
import projet_agence_location.model.Admin;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;
import projet_agence_location.service.IPersonneService;

public class PersonneService extends ManagerService<Personne> implements IPersonneService {

	IPersonneDao pdao = new PersonneDao();
	
	@Override
	public Personne getbyLoginAndPwd(String login, String password) {
		return pdao.getbyLoginAndPwd(login, password);
	}
	
//	public void authentification() {
//		for (Personne p : pdao.findAll(Personne.class)) {
//			System.out.println(p.toString());
//			if (getbyLoginAndPwd("login", "password") != null) {
//				Personne.connectedUser = p;
//			}
//			
//		}
	public void authentification( String login, String password) {
		for (Personne p : pdao.findAll(Personne.class)) {
			if (p.getLogin().equals(login) && p.getPassword().equals(password)){
				Personne.connectedUser = p;
			}
			
		}
	}
	public void editPersonne(Personne currentPersonne) {
		pdao.updateObject(currentPersonne);
	}

	public List<Client> findAllClient(){
		List<Client> listeClient = new ArrayList<Client>();
		
		for (Personne p : pdao.findAll(Personne.class)) {
			if(p instanceof Client) {
				listeClient.add((Client) p);
			}
		}
		return listeClient;	
	}
	
	public List<Admin> findAllAdmin(){
		List<Admin> listeAdmin = new ArrayList<Admin>();
		
		for (Personne p : pdao.findAll(Personne.class)) {
			if(p instanceof Admin) {
				listeAdmin.add((Admin) p);
			}
		}
		return listeAdmin;	
	}
}