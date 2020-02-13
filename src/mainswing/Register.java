package mainswing;


import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import daten.tools.impl.DAOArbeitnehmerAusBuilderImpl;
import daten.tools.impl.DAOArbeitnehmerAusFactoryImpl;
import daten.tools.impl.DAOSpeichernInDateiImpl;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusBuilder;
import daten.tools.interfaces.DAOFuerArbeitnehmerAusFactory;
import service.ServiceArbeitnehmer;
import service.ServiceSortierenSkills;
import service.ServiceSpeichern;
import service.ServiceFactory;


public class Register extends JTabbedPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2684603901864980510L;
	DAOFuerArbeitnehmerAusBuilder datenQuelleAusDatei = new DAOSpeichernInDateiImpl(); 
	DAOFuerArbeitnehmerAusBuilder datenQuelleAusBuilder = new DAOArbeitnehmerAusBuilderImpl();
	DAOFuerArbeitnehmerAusFactory datenQuelleAusFactory = new DAOArbeitnehmerAusFactoryImpl();
	
	ServiceArbeitnehmer serviceArbeitnehmer = new ServiceArbeitnehmer(datenQuelleAusBuilder);
	ServiceSpeichern serviceSpeichern = new ServiceSpeichern(datenQuelleAusDatei);
	ServiceSortierenSkills serviceSortierenSkills = new ServiceSortierenSkills();
	ServiceFactory servicePersonenAusFactory = new ServiceFactory(datenQuelleAusFactory);
	
	private JPanel verwaltungVonArbeitnehmer = new VerwaltungVonArbeitnehmer(serviceArbeitnehmer, serviceSpeichern, serviceSortierenSkills, servicePersonenAusFactory);
	
	public Register() {
		verwaltungJPanel();
	}

	
	public JPanel verwaltungJPanel() {
		scroll();
		return verwaltungVonArbeitnehmer;
	}

	
	private void scroll() {
		verwaltungVonArbeitnehmer.setPreferredSize(new Dimension(300,6000));
		JScrollPane scrollFrame = new JScrollPane(verwaltungVonArbeitnehmer);
		verwaltungVonArbeitnehmer.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(300,800));
		this.add(scrollFrame);
		
	}
}
