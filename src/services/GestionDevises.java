package services;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import models.TauxDeChange;

public class GestionDevises {

	
	private List<TauxDeChange> data = new ArrayList<TauxDeChange>();

	
	public GestionDevises(List<TauxDeChange> data) {
		this.data = data;
	}

	
	public void getTaux(TauxDeChange tauxResult, String val, List<TauxDeChange> listAddTaux) {
		if(tauxResult.getD2().trim().equals(val.trim())) {
			System.out.println(tauxResult.getTaux().setScale(0, RoundingMode.CEILING));
			return;
		}
		
		this.data.stream()
			.filter(t -> (t.getD1().equals(val) || t.getD2().equals(val)) && !listAddTaux.contains(t))
			.forEach(taux -> {
				listAddTaux.add(taux);
				if(taux.getD1().equals(val)) {
					tauxResult.setTaux(tauxResult.getTaux().multiply(taux.getTaux()).setScale(4, RoundingMode.HALF_UP));
					this.getTaux(tauxResult, taux.getD2(), listAddTaux);
				}
				if(taux.getD2().equals(val)) {
					listAddTaux.add(taux);
					tauxResult.setTaux(tauxResult.getTaux().divide(taux.getTaux(), 4, RoundingMode.HALF_UP));
					this.getTaux(tauxResult, taux.getD1(), listAddTaux);
				}
			});
	}
}
