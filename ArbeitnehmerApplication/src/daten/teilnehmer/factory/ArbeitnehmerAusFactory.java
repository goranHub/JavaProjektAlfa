package daten.teilnehmer.factory;

import java.io.Serializable;




public class ArbeitnehmerAusFactory extends Person implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3398591278017496208L;
	private int id;
	private int urlaub;
	private int lohn;
	private int skill;
	private String vorname;
	private int alter;
	private String beruf;
	

	public ArbeitnehmerAusFactory(ArbeitnehmerFactory builder) {
			
		this.id = builder.id;
		this.urlaub = builder.urlaub;
		this.lohn = builder.lohn;
		this.skill = builder.skill;
		this.vorname = builder.vorname;
		this.alter = builder.alter;
		this.beruf = builder.beruf;

	}


	
	
	@Override
	public String toString() {
		return "Id=  " + id +   "Urlaub=" + urlaub + "\tGehalt=" + lohn + "\tSkills=" + skill + "]";
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


	@Override
	public String getVorname() {
		return vorname;
	}


	@Override
	public int getAlter() {
		return alter;
	}


	@Override
	public String getBeruf() {		
		return beruf;
	}

}
