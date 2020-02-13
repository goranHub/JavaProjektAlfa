package daten;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import daten.teilnehmer.builder.build.ArbeitnehmerBuilder;
import daten.teilnehmer.builder.build.PersonenBuilder;
import daten.teilnehmer.factory.ArbeitgeberAusFactory;
import daten.teilnehmer.factory.ArbeitgeberFactory;
import daten.teilnehmer.factory.Person;
import daten.teilnehmer.factory.PersonFactory;
import daten.tools.Skills;
import service.util.random.IdGeneratorSingelton;
import service.util.random.Random10;


/**
 * Klasse ErstellerVonArbeitnehmer ist zustäding für generieren von objekten mit verschiedenen typen 
 * wie ArbeitnehmerAusBuilder, PersonAusBuilder, Person und die objekte vereint in passende typisierte liste
 * @author GoranS
 *
 */


public class ErstellerVonArbeitnehmer {


	private List<ArbeitnehmerAusBuilder> alleArbeiterAusBuilder1 = new ArrayList<>();
	private List<PersonAusBuilder> allePerson = new ArrayList<>();
	private List<Person> allePersonAusFactory = new ArrayList<>();
	
	String[] namenArray = { 
			"Goran\t", "Thomas\t", "Bernd\t", "Maik\t", "Andreas\t", "Emir\t",
			"Florian\t", "Nico\t", "ThoSchu\t", "Erdem\t", "David\t", "Bernahrd\t", "Gunnar\t",
			"Henning\t", "Frank\t", "Klaus\t", "Susanne\t", "Carola\t", "Steffi\t", "Juilete\t",
			"Erika\t", "Jenny\t", "Iness\t", "Anna\t" }; // 16M//8F// =24
	
	
	String[] berufeArray = { 
			"ReinigungsKraft\t", "Hartz IV\t\t","Mechaniker\t", "Dieb\t\t", "Software-Entwickler\t",
			"Elektroniker\t", "Krankenpfleger\t", "IT-Berater\t","IT-Analysten\t", "Mathematiker\t",
			"Kundenbetreuer\t","Betriebswirte\t", "Account Manager\t", "Produktionshelfer\t","Vertriebsmitarbeiter\t",
			"Vertriebsassistenten\t", "Sales Manager\t","Produktmanager\t", "Architekten\t", "Bauingenieur\t",
			"Lkv Fahrer\t","Mcdonalds MA\t", "Fitnes Trainer\t","Spengler\t" };
	
	
/**
 * Mit diesem konstruktor wird die methodeErsteller abgerufen damit werden die objekte von Arbeitnehmer hergestellt
 * und in passende liste addiert
 */
	
	public ErstellerVonArbeitnehmer() {
		methodeErsteller(); 
	}

	
/**
 * die methode erstellt arbeitnehmer und arbeitgeber mit builder pattern und factory pattern
 * ergestellte objekte werden in passende liste hinzufügt
 * die einzelne attribute werden random gesetzt
 */

	public void methodeErsteller() {
		
		int[] random24R10 = IdGeneratorSingelton.getInstance().uniqueRandom(15);
		int[] random10Int = Random10.uniqueRandom(15);
		
		for (int i = 0; i < 15; i++) {
			
			int skill = 		 Skills.BELASTBAR.berechneSkills(random10Int[i])
								+Skills.AUSBILDUNG.berechneSkills((new Random().nextInt(45)));
			
			
			String randomName = namenArray[random24R10[i]];
				
			PersonenBuilder personenBuilder = new PersonenBuilder();
						    personenBuilder.vorname(randomName)
						    				.alter(18 + (new Random().nextInt(45)))
						    				.beruf(berufeArray[random10Int[i]])
						    				.build();

			PersonAusBuilder neuePerson = new PersonAusBuilder(personenBuilder);
				
			
			ArbeitnehmerBuilder arbeitnehmerBuilder = new ArbeitnehmerBuilder();
					 			arbeitnehmerBuilder
					 					.id(i)
					 					.lohn(1000 + (new Random().nextInt(6000)))
					 					.urlaub(30)
					 					.skill(skill)
					 					.person(neuePerson).build();
					 
		ArbeitnehmerAusBuilder neuerAusBuilder1 = new ArbeitnehmerAusBuilder(arbeitnehmerBuilder);		 
					 
		allePersonAusFactory.add(PersonFactory.getArbeitgeberF(new ArbeitgeberAusFactory(new ArbeitgeberFactory().beruf("testBeruf").id(7).vorname(randomName))));	
		//allePersonAusFactory.add(PersonFactory.getArbeitnehmerF(new ArbeitnehmerAusFactory(new ArbeitnehmerFactory().id(8).beruf("testBeruf").alter(100).vorname(randomName))));
		
		allePerson.add(neuePerson);
		alleArbeiterAusBuilder1.add(neuerAusBuilder1);
		
		
		}
	}

	public List<ArbeitnehmerAusBuilder> getAlleArbeitnehmer() {
		return alleArbeiterAusBuilder1;
	}
	
	public List<PersonAusBuilder> getAllePersonAusBuilder() {
		return allePerson;
	}

	
	public List<Person> getAllePersonenAusFactory(){
		return allePersonAusFactory;
	}
	
	
}
