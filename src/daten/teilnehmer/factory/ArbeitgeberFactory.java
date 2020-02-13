package daten.teilnehmer.factory;

public class ArbeitgeberFactory {

		public int id;
		public int urlaub;
		public int lohn;
		public int skill;
		public String vorname;
		public int alter;
		public String beruf;
		
		public ArbeitgeberFactory vorname(final String vorname) {		
			this.vorname = vorname;
			return this;
		}
		
		public ArbeitgeberFactory alter(final int alter) {		
			this.alter = alter;
			return this;			
		}
		
		public ArbeitgeberFactory beruf(final String beruf) {		
			this.beruf = beruf;
			return this;
		}
		

		public ArbeitgeberFactory id(final int id) {
			this.id = id;
			return this;
		}
	
		
		public ArbeitgeberFactory urlaub(final int urlaub) {
			this.urlaub = urlaub;
			return this;
		}

		public ArbeitgeberFactory lohn(final int lohn) {
			this.lohn = lohn;
			return this;
		}

		public ArbeitgeberFactory skill(final int skill) {
			this.skill = skill + 1000;
			return this;
		}

		public ArbeitgeberAusFactory build() {
			return new ArbeitgeberAusFactory(this);
		}
	}

