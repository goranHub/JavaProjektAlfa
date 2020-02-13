package mainfx;

import daten.teilnehmer.ArbeitnehmerAusBuilder;
import daten.teilnehmer.PersonAusBuilder;
import daten.teilnehmer.builder.build.ArbeitnehmerBuilder;
import daten.teilnehmer.builder.build.PersonenBuilder;
import daten.tools.impl.DAOFuerFXImpl;
import daten.tools.interfaces.DAOFuerFX;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class TabelleJavaFX {
	

	DAOFuerFX fxdatenQuelle = new DAOFuerFXImpl();
	TableView<ArbeitnehmerAusBuilder> table,table2;
	TableView<PersonAusBuilder> table1, table3;
	TextField nameInput, berufInput, alterInput, idInput, lohnInput, skillInput, urlaubInput;
	StackPane root = new StackPane();
	
	@SuppressWarnings("unchecked")
	public Scene returnScene() {
			 
		
		TableColumn<PersonAusBuilder, String> vornameColumn = new TableColumn<>("Vorname");
		vornameColumn.setMinWidth(100);
		vornameColumn.setCellValueFactory(new PropertyValueFactory<>("vorname"));

		TableColumn<PersonAusBuilder, String> berufColumn = new TableColumn<>("Beruf");
		berufColumn.setMinWidth(150);
		berufColumn.setCellValueFactory(new PropertyValueFactory<>("beruf"));
		
		TableColumn<PersonAusBuilder, String> alterColumn = new TableColumn<>("Alter");
		alterColumn.setMinWidth(50);
		alterColumn.setCellValueFactory(new PropertyValueFactory<>("alter"));

		
		table1 = new TableView<>();
		table1.setPrefSize(303,1);
		table1.setItems(fxdatenQuelle.getAllBPerson());
		table1.getColumns().addAll(vornameColumn, berufColumn, alterColumn);
		
		
		TableColumn<ArbeitnehmerAusBuilder, Integer> skillColumn = new TableColumn<>("Skill");
		skillColumn.setMinWidth(50);
		skillColumn.setCellValueFactory(new PropertyValueFactory<>("skill"));
		
		TableColumn<ArbeitnehmerAusBuilder, Integer> lohnColumn = new TableColumn<>("Gehalt");
		lohnColumn.setMinWidth(50);
		lohnColumn.setCellValueFactory(new PropertyValueFactory<>("lohn"));
		
		TableColumn<ArbeitnehmerAusBuilder, Integer> urlaubColumn = new TableColumn<>("Urlaub");
		urlaubColumn.setMinWidth(50);
		urlaubColumn.setCellValueFactory(new PropertyValueFactory<>("urlaub"));
		
		TableColumn<ArbeitnehmerAusBuilder, Integer> idColumn = new TableColumn<>("ID");
		idColumn.setMinWidth(40);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		
		table2 = new TableView<>();
		table2.setPrefSize(204,1);
		table2.setItems(fxdatenQuelle.getAllBArbeitnehmer());
		table2.getColumns().addAll(skillColumn, lohnColumn, urlaubColumn, idColumn);
		
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(50);        
        berufInput = new TextField();
        berufInput.setPromptText("Beruf");
        berufInput.setMinWidth(50);
        alterInput = new TextField();
        alterInput.setPromptText("Alter");
        alterInput.setMinWidth(50);
        idInput = new TextField();
        idInput.setPromptText("ID");
        idInput.setMinWidth(50);
        lohnInput = new TextField();
        lohnInput.setPromptText("Gehalt");
        lohnInput.setMinWidth(50);
        urlaubInput = new TextField();
        urlaubInput.setPromptText("Urlaub");
        urlaubInput.setMinWidth(50);
        skillInput = new TextField();
        skillInput.setPromptText("Skill");
        skillInput.setMinWidth(50);
        
   
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
			
			PersonenBuilder personenBuilder = new PersonenBuilder();
        					personenBuilder
        					.vorname(nameInput.getText())
        					.beruf(berufInput.getText())
        					.alter(Integer.parseInt(alterInput.getText()))
        					.build(); 
        					
        	PersonAusBuilder neuePerson = new PersonAusBuilder(personenBuilder);
        	
        	
			ArbeitnehmerBuilder arbeitnehmerBuilder = new ArbeitnehmerBuilder();
								arbeitnehmerBuilder.id(Integer.parseInt(idInput.getText()))
 												   .lohn(Integer.parseInt(lohnInput.getText()))
 												   .urlaub(Integer.parseInt(urlaubInput.getText()))
 												   .skill(Integer.parseInt(skillInput.getText())).build();
        	
        	
        	ArbeitnehmerAusBuilder neuerArbeiter = new ArbeitnehmerAusBuilder(arbeitnehmerBuilder);
        	
        	
        	
        	table1.getItems().add(neuePerson);
        	table2.getItems().add(neuerArbeiter);
        	
        	nameInput.clear();
        	berufInput.clear();
        	alterInput.clear();
        	idInput.clear();
        	lohnInput.clear();
        	urlaubInput.clear();
        	skillInput.clear();
        });
	    
		
		Button deleteButton = new Button("Delete");
		
		deleteButton.setOnAction(e -> {
			
			ObservableList<ArbeitnehmerAusBuilder> productSelectedA, allProductsA;
			allProductsA = table2.getItems();
			productSelectedA = table2.getSelectionModel().getSelectedItems();
			productSelectedA.forEach(allProductsA::remove);
			
			ObservableList<PersonAusBuilder> productSelected, allProducts;
			allProducts = table1.getItems();
			productSelected = table1.getSelectionModel().getSelectedItems();
			productSelected.forEach(allProducts::remove);
			
		});
		
		
	        
		HBox hBox = new HBox();
		hBox.getChildren().addAll(table1,table2, addButton, nameInput, 
							      berufInput, alterInput, idInput, lohnInput,
							      skillInput, urlaubInput, deleteButton);
		
		root.getChildren().addAll(hBox);	
		
		Scene scene = new Scene(root, 1700, 590);
		return scene;	
		
	}	
	
}
