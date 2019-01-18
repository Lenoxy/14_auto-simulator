package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Auto {
	private String marke;
	private int ps;
	private int aktuelleGeschwindigkeit = 0;
	private int aktuellerGang;
	private boolean istMotorGestartet = false;
	private int topSpeed;
	
	//Marke get / set
	String getMarke() {
		return marke;
	}
	
	void setMarke(String marke) {
		this.marke = marke;
	}

	//PS get / set
	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	//Aktuelle Geschwindigkeit get / set
	public int getAktuelleGeschwindigkeit() {
		return aktuelleGeschwindigkeit;
	}

	public void setAktuelleGeschwindigkeit(int aktuelleGeschwindigkeit) {
		this.aktuelleGeschwindigkeit = aktuelleGeschwindigkeit;
	}

	//Aktueller Gang get / set
	public int getAktuellerGang() {
		return aktuellerGang;
	}

	public void setAktuellerGang(int aktuellerGang) {
		this.aktuellerGang = aktuellerGang;
	}

	//Motor gestartet get / set
	public boolean isIstMotorGestartet() {
		return istMotorGestartet;
	}

	public void setIstMotorGestartet(boolean istMotorGestartet) {
		this.istMotorGestartet = istMotorGestartet;
	}
	
	//Topspeed get / set
	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	
	
	
	public void horn(){
		System.out.println("[Horn] " + this);
		String bip = "res/horn.mp3";
		Media hit = new Media(new File(bip).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
	}
	
	public void switchMotorState(){
		if(istMotorGestartet == false) {
			istMotorGestartet = true;
			System.out.println("[Key] " + this + " turns Motor on");
			aktuellerGang = 1;
		}else{
			istMotorGestartet = false;
			System.out.println("[Key] " + this + " turns Motor off");
			aktuellerGang = 0;
		}
	}
	
	public void breakCar() {
		if(aktuelleGeschwindigkeit >= (ps/20)) {
			aktuelleGeschwindigkeit -= (ps/20);
		}
	}
	
	public void accelerateCar() {
		if(istMotorGestartet == true) {
			if(aktuelleGeschwindigkeit <= topSpeed) {
				aktuelleGeschwindigkeit += (ps/20);
			}
		}
	}
	
	public void checkGears() {
		if(aktuelleGeschwindigkeit == 0 && istMotorGestartet == false) {
			aktuellerGang = 0;
		}else if(aktuelleGeschwindigkeit <= 10 && istMotorGestartet == true) {
			aktuellerGang = 1;
			System.out.println("[Gear] " + this + " is in gear 1");
		}else if(aktuelleGeschwindigkeit >10 && aktuelleGeschwindigkeit <= 20 && istMotorGestartet == true) {
			aktuellerGang = 2;
			System.out.println("[Gear] " + this + " is in gear 2");
		}else if(aktuelleGeschwindigkeit >20 && aktuelleGeschwindigkeit <= 40 && istMotorGestartet == true) {
			aktuellerGang = 3;
			System.out.println("[Gear] " + this + " is in gear 3");
		}else if(aktuelleGeschwindigkeit >40 && aktuelleGeschwindigkeit <= 70 && istMotorGestartet == true) {
			aktuellerGang = 4;
			System.out.println("[Gear] " + this + " is in gear 4");
		}else if(aktuelleGeschwindigkeit >70 && aktuelleGeschwindigkeit <= 100 && istMotorGestartet == true) {
			aktuellerGang = 5;
			System.out.println("[Gear] " + this + " is in gear 5");
		}else if(aktuelleGeschwindigkeit >100 && istMotorGestartet == true) {
			aktuellerGang = 6;
			System.out.println("[Gear] " + this + " is in gear 6");
		}
	}
	
	@Override
	public String toString() {
		return marke;
	}
}
