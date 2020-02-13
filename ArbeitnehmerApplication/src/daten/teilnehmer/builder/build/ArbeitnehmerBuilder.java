package daten.teilnehmer.builder.build;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;

public class ArbeitnehmerBuilder {
	// izvuci u drugu kalsu bez static gore ubaciti kao object

	public int id;
	public int urlaub;
	public int lohn;
	public int skill;
	public PersonAusBuilder person;

	/**
	 * by creating a person object we must call their build method their create new
	 * Employer (Arbeitnehmer) with the private constructor ArbeitnehmerAusBuilder
	 * @return ArbeitnehmerAusBuilder
	 */

	public ArbeitnehmerAusBuilder build() {
		return new ArbeitnehmerAusBuilder(this);
	}

	/**
	 * this method take a person and take it to the Builder
	 * 
	 * @param person include person attributes (name, age,job) is also a builder
	 * @return Builder
	 */

	public ArbeitnehmerBuilder person(final PersonAusBuilder person) {
		this.person = person;
		return this;
	}

	public ArbeitnehmerBuilder id(final int id) {
		this.id = id;
		return this;
	}

	public ArbeitnehmerBuilder urlaub(final int urlaub) {
		this.urlaub = urlaub;
		return this;
	}

	public ArbeitnehmerBuilder lohn(final int lohn) {
		this.lohn = lohn;
		return this;
	}

	public ArbeitnehmerBuilder skill(final int skill) {
		this.skill = skill;
		return this;
	}
}
