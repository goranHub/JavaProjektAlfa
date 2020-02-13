package daten.tools.impl;

import java.util.List;

import daten.ErstellerVonArbeitnehmer;
import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import daten.tools.interfaces.DAOFuerFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * DAO implemation die zu daten aus daten schicht zuzugreifen, die benutzen man dan in den javaFx klassen  
 * desswegen geben die methoden ObservableList type züruck
 * @author GoranS
 *
 */
public class DAOFuerFXImpl implements DAOFuerFX {

	List<PersonAusBuilder> personenList;
	List<ArbeitnehmerAusBuilder> arbeitnehmerList;
	
	
	/**
	 * Mit der initaliesirung von den konstruktor initaliesieren wir die klasse ErstellVonArbeiter
	 * der verschiedene listen von arbeitnehmer zu verfügung stellt. 
	 * Mit der getAllePersonAusBuilder methode die liefert liste von personen züruck mit type PersonAusBuilder.
	 * Die methode getAlleArbeitnehmer methode die liefert liste von arbeitnehmer züruck mit type ArbeitnehmerAusBuilder.
	 * 
	 */
	
	public DAOFuerFXImpl() {
		ErstellerVonArbeitnehmer macher = new ErstellerVonArbeitnehmer();
		personenList = macher.getAllePersonAusBuilder(); 			
		arbeitnehmerList =   macher.getAlleArbeitnehmer(); 
	}
	
	
	@Override
	public ObservableList<ArbeitnehmerAusBuilder> getAllBArbeitnehmer() {
		return FXCollections.observableArrayList(arbeitnehmerList);
	}
	
	
	
	@Override
	public ObservableList<PersonAusBuilder> getAllBPerson() {
		return  FXCollections.observableArrayList(personenList);
	}

}