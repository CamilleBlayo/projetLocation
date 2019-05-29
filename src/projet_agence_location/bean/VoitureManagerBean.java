package projet_agence_location.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import projet_agence_location.model.Voiture;
import projet_agence_location.service.IVoitureService;
import projet_agence_location.service.impl.VoitureService;
import projet_agence_location.util.HibernateUtil;

@ManagedBean(name="voitureManager")
@SessionScoped
public class VoitureManagerBean {
	
	IVoitureService voitureService = new VoitureService();
	
	private Voiture voiture;
	private Voiture selectedVoit;	

	private List<Voiture> voitures;

	@SuppressWarnings("unused")
	@PostConstruct
	public void initTable() {
		Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void create() {
		voitureService.addObject(voiture);
	}
	public void clear() {
		voitureService.deleteObject(selectedVoit);
	}
	
	public void edit() {
		voitureService.editVoiture(voiture);
	}
	
	public void updateToEdit(Voiture currentVoiture) {
		voiture = selectedVoit;
	}

	public Voiture getSelectedVoit() {
		return selectedVoit;
	}
	public void setSelectedVoit(Voiture selectedVoit) {
		this.selectedVoit = selectedVoit;
	}
	
	public List<Voiture> getListVoiture(){
		return voitureService.findAll(Voiture.class);
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	
	
//	public void delete(Voiture voiture) {
//		voitureService.deleteObject(voiture);
//	}
	
//	public void put(String marque, String immatriculation, String categorie_vehicule, Boolean etat_voiture, int nombre_de_place, String couleur, Boolean disponibilite, int kilometrage, double prix_location) {
//		Voiture v = new Voiture();
//		
//		v.setMarque(marque);
//		v.setImmatriculation(immatriculation);
//		v.setCategorie_vehicule(categorie_vehicule);
//		v.setEtat_voiture(etat_voiture);
//		v.setNombre_de_place(nombre_de_place);
//		v.setCouleur(couleur);
//		v.setDisponibilite(disponibilite);
//		v.setKilometrage(kilometrage);
//		v.setPrix_location(prix_location);
//		
//	}


//	public void setListVoitures(List<Voiture> listVoitures) {
//		this.listVoitures = listVoitures;
//	}
	

}
