package daten.tools.interfaces;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import javafx.collections.ObservableList;

public interface DAOFuerFX {
	
	public ObservableList<ArbeitnehmerAusBuilder> getAllBArbeitnehmer();
	public ObservableList<PersonAusBuilder> getAllBPerson();
	
}
