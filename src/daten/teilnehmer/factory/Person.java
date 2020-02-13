package daten.teilnehmer.factory;

public abstract class Person {
	
	public abstract String getVorname();
	public abstract int getAlter();
	public abstract String getBeruf();

	
	@Override
	public String toString() {
		return "Person [getVorname()=" + getVorname() + ", getAlter()=" + getAlter() + ", getBeruf()=" + getBeruf()+ "]";
	}
	
}
