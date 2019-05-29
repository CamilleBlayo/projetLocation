package projet_agence_location.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import projet_agence_location.model.Admin;
import projet_agence_location.model.Agence;
import projet_agence_location.model.Client;
import projet_agence_location.model.Reservation;
import projet_agence_location.model.Ville;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.IAgenceService;
import projet_agence_location.service.IPersonneService;
import projet_agence_location.service.IReservationService;
import projet_agence_location.service.IVilleService;
import projet_agence_location.service.IVoitureService;
import projet_agence_location.service.impl.AgenceService;
import projet_agence_location.service.impl.PersonneService;
import projet_agence_location.service.impl.ReservationService;
import projet_agence_location.service.impl.VilleService;
import projet_agence_location.service.impl.VoitureService;
import projet_agence_location.util.HibernateUtil;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		IVilleService vser = new VilleService();
		Ville ville1 = new Ville("Nantes", 44000);
		vser.addObject(ville1);
		
		IAgenceService aser = new AgenceService();
		Agence agence1 = new Agence("hertz", "rue crebillon", 5, ville1);
		aser.addObject(agence1);
		
		IVoitureService voser = new VoitureService();
		Voiture voiture1 = new Voiture("Renault", "494YRE44", "citadine", true, 4, "verte", true, 45000, 80, agence1);
		voser.addObject(voiture1);
		Voiture voiture2 = new Voiture("Opel", "494YRE44", "citadine", true, 5, "verte", false, 45000, 80, agence1);
		voser.addObject(voiture2);
		
		agence1.getListeVoiture().add(voiture1);
		aser.updateObject(agence1);
		
		
		IPersonneService pser = new PersonneService();
		Admin admin1= new Admin("nom1", "prenom1", "admin1","123", "admin@agence.fr");
		admin1.setAdmin(true);
		pser.addObject(admin1);
		
		
		Client client3 = new Client("testNom",
				"testPrenom", "testlogin" , "123", "test@gmail.fr");
		client3.setNumero_permis("A4785");
		client3.setTelephone(128575);
		client3.setAnnee_permis(dateFormat.parse("05/11/2018"));
		client3.setUtilisateur(true);
		pser.addObject(client3);
		
		IReservationService rser = new ReservationService();
		Reservation resa1 = new Reservation(dateFormat.parse("02/02/2019"), dateFormat.parse("09/02/2019"), true);
		resa1.setPersonne(client3);
		resa1.setVoiture(voiture1);
		rser.addObject(resa1);
		
		Reservation resa2 = new Reservation(dateFormat.parse("02/02/2019"), dateFormat.parse("09/02/2019"), true);
		resa2.setPersonne(client3);
		resa2.setVoiture(voiture2);
		rser.addObject(resa2);
		
		Reservation resa3 = new Reservation(dateFormat.parse("02/02/2019"), dateFormat.parse("09/02/2019"), true);
		resa3.setPersonne(client3);
		resa3.setVoiture(voiture2);
		rser.addObject(resa2);
				

	}

}
