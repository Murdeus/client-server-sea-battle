package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Cell extends JButton {
	private int xId;
	private int yId;
	private boolean hasShip = false;
	private Ship ship;

	public Cell() {
		this.setPreferredSize(new Dimension(10, 10));
	}

	public void setXId(int xId) {
		this.xId = xId;
	}

	public int getXId() {
		return this.xId;
	}
	
	public void setYId(int yId) {
		this.yId = yId;
	}

	public int getYId() {
		return this.yId;
	}
	
	public void setHasShip(){
		this.hasShip=true;
	}
	
	public void removeHasShip(){
		this.hasShip=false;
	}
	
	public boolean getHasShip(){
		return this.hasShip;
	}
	
	public void setShip(Ship ship){
		this.ship=ship;
	}
	
	public Ship getShip(){
		return this.ship;
	}
	
}
