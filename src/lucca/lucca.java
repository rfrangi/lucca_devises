package lucca;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import models.TauxDeChange;
import services.GestionDevises;

public class lucca {

	public static void main(String[] args) {
		String nameFile =  args[0];
		TauxDeChange init = null;
		List<TauxDeChange> data = new ArrayList<TauxDeChange>();
		
		try {
			String content = Files.readString(Paths.get(nameFile), StandardCharsets.UTF_8);
			String[] str = content.split("\n");
			 for(int i = 0;  i < str.length; i++) {
				String[] value = str[i].split(";");

				if(i == 0) {//Ligne 1: Demande de Taux
					init = new TauxDeChange(value[0], value[2], new BigDecimal(value[1]));

				}
				
				if(i >= 2) { //Add init data
					String d1 = value[0];
					String d2 = value[1];
					String taux = value[2].replaceAll("\n", "").replaceAll("\r", "");
					data.add(new TauxDeChange(d1, d2, new BigDecimal(taux)));
				}
			 }
			 

			GestionDevises metier = new GestionDevises(data);
			metier.getTaux(init, init.getD1(), new ArrayList<TauxDeChange>());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
	
	
