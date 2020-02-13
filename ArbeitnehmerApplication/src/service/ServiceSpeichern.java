package service;


import java.util.List;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusBuilder;


public class ServiceSpeichern {
		
	private DAOFuerArbeitnehmerAusBuilder quelle;
	private ArbeitnehmerAusBuilder name1; 
	
	
	public ServiceSpeichern(DAOFuerArbeitnehmerAusBuilder quelle) {	
		this.quelle = quelle;
	
	}
	

	public void mSpeichernObjekt(ArbeitnehmerAusBuilder name) {		
			quelle.addAllArbeiter(name);	
	}
	

	public void mSpeichernListe(List<ArbeitnehmerAusBuilder> name) {
		for(int i = 0; i< name.size(); i++) {
			name1 = name.get(i);
			quelle.addAllArbeiter(name1);
		}	
	}
	
	
	public List<ArbeitnehmerAusBuilder> listeLesen() {
		System.out.println("test");
		return quelle.getAllArbeiter();			
	}
	
	
	public void mDeleteFile() {
		quelle.deleteAllArbeiter();
	}

}
