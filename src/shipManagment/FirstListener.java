package shipManagment;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Cell;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Field;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Ship;

public class FirstListener implements MouseListener {
	private Field field;

	public FirstListener(Field field) {
		this.field = field;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		if (button.isEnabled() 
				&& (field.getShipManage().getFirstShip() != 0)) {
			button.setEnabled(false);
			button.setBackground(Color.GREEN);
			Ship ship = new Ship(1);
			ship.add(button);
			button.setShip(ship);
			button.setHasShip();
			ship.doCopy();
			field.getShipManage().addShip(ship);
			field.clear();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Cell button = (Cell) e.getSource();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Cell button = (Cell) e.getSource();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		if (button.isEnabled()	&& (field.getShipManage().getFirstShip() != 0)) {
			button.setBackground(Color.GREEN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		if (button.isEnabled() 	&& (field.getShipManage().getFirstShip() != 0)) {
			button.setBackground(null);
		}
	}
}
