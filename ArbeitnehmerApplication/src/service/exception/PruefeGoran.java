package service.exception;

import java.util.List;

import daten.teilnehmer.ArbeitnehmerAusBuilder;


public class PruefeGoran {

	public void prufe(List<ArbeitnehmerAusBuilder> alle) throws GoranException {

		for (ArbeitnehmerAusBuilder name : alle) {
			if ((name.getPersonB().getVorname().equals("Goran\t") && name.getIdString().equals("14"))) {
				throw new GoranException();
			}
		}
	}
}
