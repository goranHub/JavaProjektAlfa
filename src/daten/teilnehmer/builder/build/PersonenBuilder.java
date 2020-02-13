package daten.teilnehmer.builder.build;

import daten.teilnehmer.PersonAusBuilder;

public class PersonenBuilder {
	public String vorname;
	public String beruf;
	public int alter;

	public PersonenBuilder vorname(final String vorname) {
		this.vorname = vorname;
		return this;
	}

	public PersonenBuilder beruf(final String beruf) {
		this.beruf = beruf;
		return this;
	}

	public PersonenBuilder alter(final int alter) {
		this.alter = alter;
		return this;
	}

	/**
	 * by creating a person object we must call their build method that their can
	 * create new Person
	 * @return macht neuen objekt von PersonAusBuilder
	 */
	public PersonAusBuilder build() {
		return new PersonAusBuilder(this);
	}

}
