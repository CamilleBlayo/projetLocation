package projet_agence_location.service.impl;

import projet_agence_location.dao.IVoitureDao;
import projet_agence_location.dao.impl.VoitureDao;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.IVoitureService;

public class VoitureService extends ManagerService<Voiture> implements IVoitureService{
	
	IVoitureDao vdao=new VoitureDao();

	public void editVoiture(Voiture currentVoiture) {
		vdao.updateObject(currentVoiture);
	}

}
