package daten.tools.interfaces;

import java.util.List;

import daten.teilnehmer.ArbeitnehmerAusBuilder;



public interface DAOFuerArbeitnehmerAusBuilder {
  
	public List<ArbeitnehmerAusBuilder> getAllArbeiter();
	public void addAllArbeiter(ArbeitnehmerAusBuilder name);
	public void deleteAllArbeiter();
	public void updateAllArbeiter();

}
