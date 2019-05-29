package projet_agence_location.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Reservation")
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769171568150431505L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reservation")
	private Long id_reservation;
	
	@Column(name="date_debut")
	private Date date_debut;
	
	@Column(name="date_fin")
	private Date date_fin;
	
	@Column(name="assurance")
	private boolean assurance;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_personne")
	private Personne personne;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_voiture")
	private Voiture voiture;

	// CONSTRUCTEURS
	public Reservation() {
		super();
	}

	public Reservation(Date date_debut, Date date_fin, boolean assurance) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.assurance = assurance;
	}

	public Reservation(Long id_reservation, Date date_debut, Date date_fin, boolean assurance) {
		super();
		this.id_reservation = id_reservation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.assurance = assurance;
	}

	//GETTER&SETTER

	public Long getId_reservation() {
		return id_reservation;
	}


	public void setId_reservation(Long id_reservation) {
		this.id_reservation = id_reservation;
	}

	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public boolean isAssurance() {
		return assurance;
	}


	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}
	
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Reservation [id_reservation=" + id_reservation + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", assurance=" + assurance + "]";
	}
	
	


}
