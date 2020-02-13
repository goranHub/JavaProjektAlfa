package service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import daten.tools.impl.DAOArbeitnehmerAusBuilderImpl;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusBuilder;

public class ServiceArbeitnehmer {
	private List<ArbeitnehmerAusBuilder> alleArbeitnehmer;
	private DAOFuerArbeitnehmerAusBuilder quelle;
	private List<PersonAusBuilder> allePerson = new ArrayList<>();

	public ServiceArbeitnehmer(DAOFuerArbeitnehmerAusBuilder quelle) {
		this.quelle = quelle;
		alleArbeitnehmer = quelle.getAllArbeiter();
	}

	public List<ArbeitnehmerAusBuilder> listeArbeitnehmerAusService() {	
		return quelle.getAllArbeiter();
	}
	
	
	
	public List<PersonAusBuilder> listePersonenAusService() {		
		PersonAusBuilder person = null;		
		for (int i =0 ; i < alleArbeitnehmer.size(); i++) {
			 person = quelle.getAllArbeiter().get(i).getPersonB();	
			 allePerson.add(person);
		}			
		return allePerson;			
	}

	
	
	public List<ArbeitnehmerAusBuilder> filterVornameAusService(String name) {
		return alleArbeitnehmer.stream().filter(s -> s.getPersonB().getVorname().equals(name +"\t")).collect(Collectors.toList());
	}
		
	public List<ArbeitnehmerAusBuilder> filterBerufAusService(String name) {
		return alleArbeitnehmer.stream().filter(s -> s.getPersonB().getBeruf().equals(name +"\t")).collect(Collectors.toList());
	}	

	public List<ArbeitnehmerAusBuilder> filterIdAusService(String name) {
		System.out.println(name);
		return alleArbeitnehmer.stream().filter(s -> s.getIdString().equals(name)).collect(Collectors.toList());
	}	
		
	public List<ArbeitnehmerAusBuilder> filterAlterAusService(String name) {
		System.out.println(name);
		return alleArbeitnehmer.stream().filter(s -> s.getPersonB().getAlterString().equals(name)).collect(Collectors.toList());
	}	

	public List<ArbeitnehmerAusBuilder> filterAlterUndUrlaubAusService(String name, String name1) {
		System.out.println(name);
		return alleArbeitnehmer.stream().filter(s -> s.getPersonB().getAlterString().equals(name+"\t")).filter(s -> s.getPersonB().getAlterString().equals(name1)).collect(Collectors.toList());
	}	
	
	
	public List<ArbeitnehmerAusBuilder> neueArbeiteterErstellen() {
		return alleArbeitnehmer;

	}

	public void allesNeu() {
		((DAOArbeitnehmerAusBuilderImpl)quelle).updateAllArbeiter();
		
	}

}
