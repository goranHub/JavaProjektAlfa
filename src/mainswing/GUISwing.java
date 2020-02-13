package mainswing;



import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;



@SuppressWarnings("serial")
public class GUISwing extends JFrame {
	

	private Register register = new Register();
	
	public GUISwing(){	
		this.setTitle("Arbeitnehmer Application");	
		setSize(1300, 900);
		registerZusammenstellen();
		menuBarC();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}


	private void registerZusammenstellen() {
		add(register);
	}
	
	
	private void menuBarC() {
		   JMenuBar bar = new JMenuBar();
		   JMenu menu = new JMenu("Options");
		   menu.setMnemonic(KeyEvent.VK_O);

		    ButtonGroup group = new ButtonGroup();
		    JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem("Zeige Liste An");
		    
		    group.add(menuItem);
		    menu.add(menuItem);

		    menuItem = new JRadioButtonMenuItem("B");
		    group.add(menuItem);
		    menu.add(menuItem);

		    menuItem = new JRadioButtonMenuItem("C");
		    group.add(menuItem);
		    menu.add(menuItem);

		    bar.add(menu);
		    this.setJMenuBar(bar);
	
	}
}
