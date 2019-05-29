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


public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException, InterruptedException {
		// TODO Auto-generated method stub
		Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		

	}

}
