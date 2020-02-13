package service;

import java.util.List;

import daten.teilnehmer.factory.Person;
import daten.tools.impl.DAOArbeitnehmerAusFactoryImpl;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusFactory;

public class ServiceFactory {
	
	private DAOFuerArbeitnehmerAusFactory quelle;
	
	List<Person> allePersonen;

	public ServiceFactory(DAOFuerArbeitnehmerAusFactory quelle) {
			this.quelle = quelle;
		
	}
	
	
	public List<Person> zeigeAllePersonenAusFactory() {
		return allePersonen = quelle.getAllPersonen();		
	}


	public void allesNeu() {
		((DAOArbeitnehmerAusFactoryImpl)quelle).updateAllPersonen();
	}
	
	
}
