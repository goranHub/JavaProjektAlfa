package daten.teilnehmer;


import java.io.Serializable;

import daten.teilnehmer.builder.build.ArbeitnehmerBuilder;




public class ArbeitnehmerAusBuilder implements Serializable {
	
	private static final long serialVersionUID = 1445604024416769863L;
	
	
	private int id;
	private int urlaub;
	private int lohn;
	private int skill;
	private PersonAusBuilder person;

	
	
	
	public ArbeitnehmerAusBuilder(ArbeitnehmerBuilder builder1) {

		this.id = builder1.id;
		this.urlaub = builder1.urlaub;
		this.lohn = builder1.lohn;
		this.skill = builder1.skill;
		this.person = builder1.person;
	}


	
	
	@Override
	public String toString() {
		return "Id=  " + id + person + "Urlaub=" + urlaub + "\tGehalt=" + lohn + "\tSkills=" + skill + "]";
	}


	public int getId() {
		return id;
	}

	public String getIdString() {
		String str1 = Integer.toString(id);
		return str1;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUrlaub() {
		return urlaub;
	}

	public String getUrlaubString() {
		String str1 = Integer.toString(urlaub);
		return str1;
	}

	public void setUrlaub(int urlaub) {
		this.urlaub = urlaub;
	}

	public int getLohn() {
		return lohn;
	}

	public String getLohnString() {
		String str1 = Integer.toString(lohn);
		return str1;
	}

	public void setLohn(int lohn) {
		this.lohn = lohn;
	}

	public int getSkill() {
		return skill;
	}

	public String getSkillString() {
		String str1 = Integer.toString(skill);
		return str1;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public PersonAusBuilder getPersonB() {
		return person;
	}

	public void setPerson1(PersonAusBuilder person1) {
		this.person = person1;
	}

}

