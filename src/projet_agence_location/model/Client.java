package projet_agence_location.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Client") 
public class Client extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column (name="numero_permis")
	private String numero_permis;
	
	@Column (name= "telephone")
	private int telephone;
	
	@Column (name="annee_permis")
	private Date annee_permis;
	
	@Column (name="utilisateur")
	private boolean utilisateur;

	// CONSTRUCTEURS
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String login, String password, String email) {
		super(nom, prenom, login, password, email);
	}

	public Client(String numero_permis, int telephone, Date annee_permis, boolean utilisateur) {
		super();
		this.numero_permis = numero_permis;
		this.telephone = telephone;
		this.annee_permis = annee_permis;
		this.utilisateur = utilisateur;
	}
	
	

	// GETTER&SETTER
	public String getNumero_permis() {
		return numero_permis;
	}

	public void setNumero_permis(String numero_permis) {
		this.numero_permis = numero_permis;
	}
	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public Date getAnnee_permis() {
		return annee_permis;
	}

	public void setAnnee_permis(Date annee_permis) {
		this.annee_permis = annee_permis;
	}
	public boolean isUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(boolean utilisateur) {
		this.utilisateur = utilisateur;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Client [numero_permis=" + numero_permis + ", telephone=" + telephone + ", annee_permis=" + annee_permis
				+ ", utilisateur=" + utilisateur + "]";
	}

}
