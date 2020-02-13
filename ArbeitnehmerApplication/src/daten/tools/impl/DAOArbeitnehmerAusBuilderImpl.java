package daten.tools.impl;


import java.util.List;

import daten.ErstellerVonArbeitnehmer;
import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusBuilder;

/**
 * Implementierung von DAO pattern 
 * dient für die anbindung an die daten 
 * @author GoranS
 *
 */

public class DAOArbeitnehmerAusBuilderImpl implements DAOFuerArbeitnehmerAusBuilder {


	List<ArbeitnehmerAusBuilder> arbeitnehmerList;
	/**
	 * Mit der initaliesirung von den konstruktor initaliesieren wir die klasse ErstellVonArbeiter
	 * der verschiedene listen von arbeitnehmer zu stellt gibt. In diese implematation brauchen wir
	 * die getAlleArbeitnehmer methode die liefert liste von arbeitnehmer züruck mit type ArbeitnehmerAusBuilder
	 */
	
	public DAOArbeitnehmerAusBuilderImpl() {
		ErstellerVonArbeitnehmer macher = new ErstellerVonArbeitnehmer();
		arbeitnehmerList = macher.getAlleArbeitnehmer();
	}
	
	
	@Override
	public List<ArbeitnehmerAusBuilder> getAllArbeiter() {
		return arbeitnehmerList;
	}
	
	
	@Override
	public void addAllArbeiter(ArbeitnehmerAusBuilder name) {
		arbeitnehmerList.add(name);
	}



	@Override
	public void deleteAllArbeiter() {
		// TODO Auto-generated method stub
	}


	@Override
	public void updateAllArbeiter() {
		ErstellerVonArbeitnehmer macher = new ErstellerVonArbeitnehmer();
		arbeitnehmerList =   macher.getAlleArbeitnehmer();
		
	}




}
