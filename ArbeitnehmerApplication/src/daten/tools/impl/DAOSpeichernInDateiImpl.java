package daten.tools.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusBuilder;

/**
 * die implementation gibt uns zu verfügung methode fuer schreiben von objekte (List ArbeitnehmerAusBuilder)
 * in datei ("liste/alleUser.dat") und methode fuer lesen aus der datei
 * @author GoranS
 *
 */

public class DAOSpeichernInDateiImpl implements DAOFuerArbeitnehmerAusBuilder {

	
	private List<ArbeitnehmerAusBuilder> liste = new ArrayList<ArbeitnehmerAusBuilder>();
	private File ziel = new File("liste/alleUser.dat");
	
	
	@SuppressWarnings("unchecked")
	@Override
	
	/**
	 * methode schreibt List<ArbeitnehmerAusBuilder>  in die ("liste/alleUser.dat")
	 */
	public List<ArbeitnehmerAusBuilder> getAllArbeiter() {
		try(ObjectInputStream objektLeser = new ObjectInputStream(new FileInputStream(ziel))){
			Object obj = objektLeser.readObject();	
			List<ArbeitnehmerAusBuilder> alleUserInFile = (List<ArbeitnehmerAusBuilder>) obj;
			return alleUserInFile;
		}catch(IOException | ClassNotFoundException ausnahme) {
			ausnahme.printStackTrace();
		}
		return null;
	}


	
	@Override
	/** 
	 * lesen aus der ("liste/alleUser.dat")
	 *
	 */
	
	public void addAllArbeiter(ArbeitnehmerAusBuilder name) {
		File pfad = new File("liste");
		if (!pfad.exists()) {
			pfad.mkdir(); 
		}
		try(ObjectOutputStream objektSreiber = new ObjectOutputStream(new FileOutputStream(ziel))){
			liste.add(name);
			objektSreiber.writeObject(liste);
			objektSreiber.flush();
		}catch(IOException ausnahme) {
			ausnahme.printStackTrace();
		}
		
	}

	@Override
	public void deleteAllArbeiter() {
		if (ziel.exists()) {
			ziel.delete();
		}	
	}



	@Override
	public void updateAllArbeiter() {
		// TODO Auto-generated method stub
		
	}
}
