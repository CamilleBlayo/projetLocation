package projet_agence_location.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import projet_agence_location.model.Admin;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;
import projet_agence_location.service.IPersonneService;
import projet_agence_location.service.impl.PersonneService;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	private String login;
	private String password;

	IPersonneService personneService = new PersonneService();

	public String connect() {

		personneService.authentification(login, password);
		if (login == null || login.length() == 0 || password == null || password.length() == 0) {
			return ("wrong-user");
		}
		else {
			if (Personne.connectedUser instanceof Client) {
				return ("client");
			} else if (Personne.connectedUser instanceof Admin) {
				return ("admin");
			}
			else {
				return ("wrong-user");
			}
		}	
	}

	public String getlogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Personne getConnectedUser() {
		return getConnectedUser();
	}

	public static void setConnectedUser(Personne connectedUser) {
		Personne.connectedUser = connectedUser;
	}

}
