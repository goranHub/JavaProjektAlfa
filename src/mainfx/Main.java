package mainfx;


import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import daten.tools.impl.DAOFuerFXImpl;
import daten.tools.interfaces.DAOFuerFX;
import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class Main extends Application  {

	
	DAOFuerFX fxdatenQuelle = new DAOFuerFXImpl();
	
	Stage window;

	TableView<PersonAusBuilder> table1;
	TableView<ArbeitnehmerAusBuilder> table2;
	
	
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Arbeitnehmer Applikation");
		
		TabelleJavaFX meineTabelle = new TabelleJavaFX();
		window.setScene(meineTabelle.returnScene());
		window.show();

	}
}