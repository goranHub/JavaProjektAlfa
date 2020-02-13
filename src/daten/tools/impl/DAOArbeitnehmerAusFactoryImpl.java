package daten.tools.impl;

import java.util.List;

import daten.ErstellerVonArbeitnehmer;
import daten.teilnehmer.factory.Person;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusFactory;

public class DAOArbeitnehmerAusFactoryImpl implements DAOFuerArbeitnehmerAusFactory {
	
	
	List<Person> personenList;
	
	/**
	 * Mit der initaliesirung von den konstruktor initaliesieren wir die klasse ErstellVonArbeiter
	 * der verschiedene listen von personen zu verfügung stellt. 
	 * In diese implematation brauchen wir die getAllPersonen methode die liefert liste von personen züruck mit type Person
	 */
	
	public DAOArbeitnehmerAusFactoryImpl(){
		ErstellerVonArbeitnehmer macher = new ErstellerVonArbeitnehmer();
		personenList = macher.getAllePersonenAusFactory();
	}
	
	
	@Override
	public List<Person> getAllPersonen() {
		return personenList;
	}

	@Override
	public void addAllPersonen(Person name) {
		personenList.add(name);	
	}

	
	@Override
	public void deleteAllPersonen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAllPersonen() {
		ErstellerVonArbeitnehmer macher = new ErstellerVonArbeitnehmer();
		personenList =   macher.getAllePersonenAusFactory();

	}
	


	

}
