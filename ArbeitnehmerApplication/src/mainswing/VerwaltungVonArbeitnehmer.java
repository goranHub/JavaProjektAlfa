package mainswing;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import daten.teilnehmer.builder.build.ArbeitnehmerBuilder;
import daten.teilnehmer.factory.ArbeitgeberAusFactory;
import daten.teilnehmer.factory.Person;
import service.ServiceArbeitnehmer;
import service.ServiceFactory;
import service.ServiceSortierenSkills;
import service.ServiceSpeichern;
import service.exception.GoranException;
import service.exception.PruefeGoran;
import service.util.ServiceSortiereAlter;
import service.util.ServiceSortiereGehalt;

public class VerwaltungVonArbeitnehmer extends JPanel {

	private static final long serialVersionUID = -8865860199605037401L;
	private JTextArea ersteTextArea = new JTextArea(5, 120);
	private JTextArea zweiteTextArea = new JTextArea(11, 120);
	private JButton filterButton = new JButton("Filter");
	private JButton zeigeAlleAnButton = new JButton("Zeige Neue Liste An");
	private JButton sortiereSkillsButton = new JButton("Sortiere nach Skills");
	private JButton sortiereAlterButton = new JButton("Sortiere nach Alter (bubbleSort)");
	private JButton sortiereGehaltButton = new JButton("Sortiere nach Gehalt (bubbleSort)");
	private JButton speichernListeButton = new JButton("Speichere Ganze Liste");
	private JButton speichernObjektButton = new JButton("Speichere Einzelne Objekte");
	private JButton ladeAlsObjektButton = new JButton("Lade in zweite text area");
	private JButton deleteListeButton = new JButton("DELETE LISTE");
	private JButton personenButton = new JButton("Personen aus Factory");
	private JTextArea vornameTextArea = new JTextArea("Vorname");
	private JTextArea idTextArea = new JTextArea("Id");
	private JTextArea skillsTextArea = new JTextArea("Skills");
	private JTextArea berufTextArea = new JTextArea("Beruf");
	private JTextArea alterTextArea = new JTextArea("Alter");
	private JTextArea urlaubTextArea = new JTextArea("Urlaub");
	private JTextArea gehaltTextArea = new JTextArea("Gehalt");
	private ServiceArbeitnehmer servisArbeitnehmer;
	private ServiceSpeichern serviceSpeichern;
	private ServiceSortierenSkills serviceSortierenSkills;
	private ServiceFactory servicePersonenAusFactory;
	
	public VerwaltungVonArbeitnehmer(ServiceArbeitnehmer servisArbeitnehmer, ServiceSpeichern serviceSpeichern,
									ServiceSortierenSkills serviceSortierenSkills, ServiceFactory servicePersonenAusFactory) {

		this.servisArbeitnehmer = servisArbeitnehmer;
		this.serviceSpeichern = serviceSpeichern;
		this.serviceSortierenSkills = serviceSortierenSkills;
		this.servicePersonenAusFactory = servicePersonenAusFactory;

		buttonBauen();
		bauen();
	}

	private void buttonBauen() {
		add(ersteTextArea);
		add(zweiteTextArea);	
		add(zeigeAlleAnButton);
		add(speichernListeButton);
		add(speichernObjektButton);
		add(ladeAlsObjektButton);
		add(sortiereAlterButton);
		add(sortiereGehaltButton);
		add(sortiereSkillsButton);
		add(deleteListeButton);
		add(idTextArea);
		add(vornameTextArea);
		add(berufTextArea);
		add(alterTextArea);
		add(urlaubTextArea);
		add(gehaltTextArea);
		add(skillsTextArea);
		add(filterButton);
		add(personenButton);
	}

	private void bauen() {
		ersteTextArea.setFont(new Font("Monaco", Font.PLAIN, 12));
		zweiteTextArea.setFont(new Font("Monaco", Font.PLAIN, 12));
		idTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		vornameTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		berufTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		alterTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		urlaubTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		skillsTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		gehaltTextArea.setFont(new Font("Arial", Font.PLAIN, 20));

		
		personenButton.addActionListener(l->{		
			servicePersonenAusFactory.allesNeu();
			ersteTextArea.setText("");
			List<Person> suche = servicePersonenAusFactory.zeigeAllePersonenAusFactory();
			for(Person derjenige : suche) {
				((ArbeitgeberAusFactory)derjenige).getBeruf();				
				ersteTextArea.append("\n" +" "+ derjenige.getVorname() +" "+((ArbeitgeberAusFactory)derjenige).getBeruf());		
			}
		});
		
		
		zeigeAlleAnButton.addActionListener(event -> {
			servisArbeitnehmer.allesNeu();
			List<ArbeitnehmerAusBuilder> suche = servisArbeitnehmer.listeArbeitnehmerAusService();
			ersteTextArea.setText("");
			for (ArbeitnehmerAusBuilder name : suche) {
				ersteTextArea.append(name + "\n");
			}

			PruefeGoran gorran = new PruefeGoran();
			
			try {
				gorran.prufe(servisArbeitnehmer.listeArbeitnehmerAusService());
			} catch (GoranException e) {
					System.out.println("EXCEPTION ist aufgetreten Goran hat die ID14");
					servisArbeitnehmer.allesNeu();
			}
			
		});

		filterButton.addActionListener(event -> {
			zweiteTextArea.setText("");
			String myString0, myString1, myString2, myString3, myString4;
			myString0 = vornameTextArea.getText().trim();
			myString1 = berufTextArea.getText().trim();
			myString2 = idTextArea.getText().toString().trim();
			myString3 = alterTextArea.getText().toString().trim();
			myString4 = urlaubTextArea.getText().toString().trim();

			List<ArbeitnehmerAusBuilder> listeVornamen = servisArbeitnehmer.filterVornameAusService(myString0);
			List<ArbeitnehmerAusBuilder> listeBeruf = servisArbeitnehmer.filterBerufAusService(myString1);
			List<ArbeitnehmerAusBuilder> listeID = servisArbeitnehmer.filterIdAusService(myString2);
			List<ArbeitnehmerAusBuilder> listeAlter = servisArbeitnehmer.filterAlterAusService(myString3);
			List<ArbeitnehmerAusBuilder> listeUrlaub = servisArbeitnehmer.filterAlterUndUrlaubAusService(myString3, myString4);

			if (listeVornamen.isEmpty() || listeBeruf.isEmpty() || listeAlter.isEmpty() || listeID.isEmpty()	|| listeUrlaub.isEmpty()) {
				zweiteTextArea.setText("");
				zweiteTextArea.append("\t\t\t Ist nicht in der Liste\n");
			}

			for (ArbeitnehmerAusBuilder name : listeVornamen)
				zweiteTextArea.append(name + "\n");

			for (ArbeitnehmerAusBuilder name : listeBeruf)
				zweiteTextArea.append(name + "\n");

			for (ArbeitnehmerAusBuilder name : listeAlter)
				zweiteTextArea.append(name + "\n");

			for (ArbeitnehmerAusBuilder name : listeID)
				zweiteTextArea.append(name + "\n");

			for (ArbeitnehmerAusBuilder name : listeUrlaub)
				zweiteTextArea.append(name + "\n");

		});

		speichernListeButton.addActionListener(
				event -> serviceSpeichern.mSpeichernListe(servisArbeitnehmer.listeArbeitnehmerAusService()));

		
		speichernObjektButton.addActionListener(event -> {	
			ArbeitnehmerBuilder arbeitnehmerBuilder = new ArbeitnehmerBuilder();
			arbeitnehmerBuilder.id(33);
			ArbeitnehmerAusBuilder neuer1 = new ArbeitnehmerAusBuilder(arbeitnehmerBuilder);
			System.out.println("neuer1 " + neuer1.getId());
			
			serviceSpeichern.mSpeichernObjekt(neuer1);
		});

		
		ladeAlsObjektButton.addActionListener(event -> {
			List<?> suche = serviceSpeichern.listeLesen();
			zweiteTextArea.setText("");
			if (suche.isEmpty()) {
				zweiteTextArea.setText("");
				zweiteTextArea.append("\t\t\tListe ist leer\n");
			}
			for (Object name : suche) {
				zweiteTextArea.append(name + "\n");
			}
		});

		
		deleteListeButton.addActionListener(event -> serviceSpeichern.mDeleteFile());

		sortiereSkillsButton.addActionListener(event -> {
			List<ArbeitnehmerAusBuilder> suche = serviceSortierenSkills
					.soritereNachSkills(servisArbeitnehmer.listeArbeitnehmerAusService());
			ersteTextArea.setText("");
			for (ArbeitnehmerAusBuilder name : suche) {
				ersteTextArea.append(name + "\n");
			}
		});

		sortiereAlterButton.addActionListener(event -> {
			
			int[] intArray = ServiceSortiereAlter.sort(servisArbeitnehmer.listePersonenAusService());
			for (int i = 0; i < intArray.length; ++i) {
				System.out.print(intArray[i] + " ");
			}

			System.out.print("\n");
			ServiceSortiereAlter.bubbleSort(intArray);
			System.out.println("Sorted array");
			ServiceSortiereAlter.printArray(intArray);
			System.out.println("\n");
			zweiteTextArea.setText("");
			for (int alter : intArray) {
				zweiteTextArea.append(alter + " Alter \n");
			}

		});

		sortiereGehaltButton.addActionListener(l -> {
			int[] intArray = ServiceSortiereGehalt.sort(servisArbeitnehmer.listeArbeitnehmerAusService());

			for (int i = 0; i < intArray.length; ++i) {
				System.out.print(intArray[i] + " ");
			}
			System.out.print("\n");

			ServiceSortiereGehalt.bubbleSort(intArray);
			System.out.println("Sorted array");
			ServiceSortiereGehalt.printArray(intArray);
			System.out.println("\n");
			zweiteTextArea.setText("");
			for (int lohn : intArray) {
				zweiteTextArea.append(lohn + " Gehalt \n");
			}

		});

	}
}
