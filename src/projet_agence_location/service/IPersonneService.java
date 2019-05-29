package projet_agence_location.service;

import java.util.List;

import projet_agence_location.model.Admin;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;

public interface IPersonneService extends IManagerService<Personne>{

	public Personne getbyLoginAndPwd (String login, String password);
	public void authentification(String login, String password);
	public void editPersonne(Personne personne);
	public List<Client> findAllClient();
	public List<Admin> findAllAdmin();
	
}
