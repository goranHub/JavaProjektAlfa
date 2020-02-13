package daten.teilnehmer;

import java.io.Serializable;

import daten.teilnehmer.builder.build.PersonenBuilder;

/**
 * This class implements a Person that be create with builder pattern
 * 
 * @author GoranS
 *
 */

public class PersonAusBuilder implements Serializable {

	private static final long serialVersionUID = -45332704927136242L;
	private final String vorname;
	private final String beruf;
	private final int alter;

	public PersonAusBuilder(PersonenBuilder builder) {
		this.vorname = builder.vorname;
		this.beruf = builder.beruf;
		this.alter = builder.alter;
	}

	@Override
	public String toString() {
		return "\t[Vorname=" + vorname + "Beruf=" + beruf + "\tAlter=" + alter + "]\t";
	}

	public String getVorname() {
		return vorname;
	}

	public String getBeruf() {
		return beruf;
	}

	public int getAlter() {
		return alter;
	}

	public String getAlterString() {
		String str1 = Integer.toString(alter);
		return str1;
	}

	public PersonAusBuilder getPersonB() {
		return this;
	}

}
