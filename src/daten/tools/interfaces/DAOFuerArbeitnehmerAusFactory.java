package daten.tools.interfaces;

import java.util.List;

import daten.teilnehmer.factory.Person;

public interface DAOFuerArbeitnehmerAusFactory {
	
	
	public List<Person> getAllPersonen();
	public void addAllPersonen(Person name);
	public void deleteAllPersonen();
	public void updateAllPersonen();
	

}
