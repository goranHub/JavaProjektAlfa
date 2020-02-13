package daten.teilnehmer.factory;

public class ArbeitnehmerFactory {

		public int id;
		public int urlaub;
		public int lohn;
		public int skill;
		public String vorname;
		public int alter;
		public String beruf;
	
		public ArbeitnehmerFactory vorname(final String vorname) {		
			this.vorname = vorname;
			return this;
		}
		
		public ArbeitnehmerFactory alter(final int alter) {		
			this.alter = alter;
			return this;			
		}
		
		public ArbeitnehmerFactory beruf(final String beruf) {		
			this.beruf = beruf;
			return this;
		}

		public ArbeitnehmerFactory id(final int id) {
			this.id = id;
			return this;
		}

		public ArbeitnehmerFactory urlaub(final int urlaub) {
			this.urlaub = urlaub;
			return this;
		}

		public ArbeitnehmerFactory lohn(final int lohn) {
			this.lohn = lohn;
			return this;
		}

		public ArbeitnehmerFactory skill(final int skill) {
			this.skill = skill;
			return this;
		}

		public ArbeitnehmerAusFactory build() {
			return new ArbeitnehmerAusFactory(this);
		}
	}

