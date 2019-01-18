package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import application.Auto;

public class AutoSimController {
	public int mode;
	
	@FXML
	private ComboBox<Auto> dropdownMenu;
	@FXML
	private Button key;
	@FXML
	private Button horn;
	@FXML
	private Button breakCar;
	@FXML
	private Button AccelerateCar;
	@FXML
	private TextField speed;
	@FXML
	private TextField gear;
	@FXML
	private TextField ps;
	@FXML
	public Label carLabel;
	
	Auto car;
	

	
	public void initialize() {
		
		Auto nissan = new Auto();
		Auto fiat = new Auto();
		Auto bugatti = new Auto();
		nissan.setMarke("Nissan");
		nissan.setPs(190);
		nissan.setTopSpeed(225);
		fiat.setMarke("Fiat");
		fiat.setPs(95);
		fiat.setTopSpeed(135);
		bugatti.setMarke("Bugatti");
		bugatti.setPs(265);
		bugatti.setTopSpeed(280);
		
		ObservableList<Auto> autoListe =  FXCollections.observableArrayList();
		autoListe.add(nissan);
		autoListe.add(fiat);
		autoListe.add(bugatti);
		
		dropdownMenu.setItems(autoListe);
		car = nissan;
		dropdownMenu.setValue(car);
		
		
		reload();
	}

	public void onDropdownMenuPress() {
		
		car = dropdownMenu.getValue();
		reload();
	
	}
	
	
	public void onKeyPress() {
		car.switchMotorState();
		if(car.isIstMotorGestartet() == true) {
			carLabel.setText("On");
		}else if(car.isIstMotorGestartet() == false) {
			carLabel.setText("Off");
		}
		reload();
	}
	
	public void onHornPress() {
		car.horn();
	}
	
	public void onBreakPress() {
		car.breakCar();
		car.checkGears();
		reload();
	}
	
	public void onAcceleratePress(){
		car.accelerateCar();
		car.checkGears();
		reload();
	}
	
	/*
	
	//Mode switcher
	public void onNissanPress() {
		mode = 0;
		dropdownMenu.setText("Nissan GTR");
		System.out.println("[Mode] Nissan (" + mode + ")");
		reload();
	}
	public void onFiatPress() {
		mode = 1;
		dropdownMenu.setText("Fiat 500");
		System.out.println("[Mode] Fiat (" + mode + ")");
		reload();
	}
	public void onBugattiPress() {
		mode = 2;
		dropdownMenu.setText("Bugatti Chiron");
		System.out.println("[Mode] Bugatti (" + mode + ")");
		reload();
	}
	
	public Auto getActiveCar() {
		switch(mode) {
		case 0:
			return nissan;
		case 1:
			return fiat;
		case 2:
			return bugatti;
		default:
			return null;
		}
		
		
	}
	
	*/
	public void reload() {	 
		ps.setText(car.getPs() + "");
		speed.setText(car.getAktuelleGeschwindigkeit() + "");
		gear.setText(car.getAktuellerGang() + "");
		if(car.isIstMotorGestartet()==true) {
			carLabel.setText("On");
		}else if(car.isIstMotorGestartet() == false) {
			carLabel.setText("Off");
		}
	}
}