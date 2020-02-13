package daten.tools;

import java.util.Random;

public enum Skills {

	KOMUNIKATION(10), BELASTBAR(4), AUSBILDUNG(13), SPRACHEN(6), VERLASLICHKEIT(9);

	int faktor, score;

	private Skills(int faktor) {
		this.faktor = faktor;
	}

	public int berechneSkills(int i) {	
		int randomInt = new Random().nextInt(10) + 2;
		return score = randomInt * faktor* i;

	}
}
