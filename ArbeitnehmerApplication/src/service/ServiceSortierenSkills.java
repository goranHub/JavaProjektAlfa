package service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import daten.teilnehmer.ArbeitnehmerAusBuilder;


public class ServiceSortierenSkills {

	public List<ArbeitnehmerAusBuilder> soritereNachSkills(List<ArbeitnehmerAusBuilder> list) {			
		Comparator<ArbeitnehmerAusBuilder> cmp = Comparator.<ArbeitnehmerAusBuilder> comparingInt(p -> p.getSkill()).thenComparingInt(p -> p.getId());
		Collections.sort(list, cmp); 
		return list; 		
	}
	
}

