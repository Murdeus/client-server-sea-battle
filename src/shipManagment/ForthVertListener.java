package shipManagment;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Cell;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Field;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Ship;

public class ForthVertListener implements MouseListener {

	private Field field;

	public ForthVertListener(Field field) {
		this.field = field;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		Cell next = field.getCellById(button.getXId(), button.getYId() + 1);
		Cell next1 = field.getCellById(button.getXId(), button.getYId() + 2);
		Cell next2 = field.getCellById(button.getXId(), button.getYId() + 3);
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (next2.isEnabled()) && (field.getShipManage().getForthShip() != 0)) {
			button.setEnabled(false);
			button.setBackground(Color.GREEN);
			//button.setShip();
			Ship ship = new Ship(4);
			ship.add(button);
			button.setShip(ship);
			button.setHasShip();
			field.getCellById(button.getXId(), button.getYId() + 1).setEnabled(
					false);
			field.getCellById(button.getXId(), button.getYId() + 1)
					.setBackground(Color.GREEN);
			//field.getCellById(button.getXId(), button.getYId() + 1).setShip();			
			ship.add(field.getCellById(button.getXId(), button.getYId() + 1));
			field.getCellById(button.getXId(), button.getYId() + 1).setShip(ship);
			field.getCellById(button.getXId(), button.getYId() + 1).setHasShip();			
			field.getCellById(button.getXId(), button.getYId() + 2).setEnabled(
					false);
			field.getCellById(button.getXId(), button.getYId() + 2)
					.setBackground(Color.GREEN);			
			ship.add(field.getCellById(button.getXId(), button.getYId() + 2));
			field.getCellById(button.getXId(), button.getYId() + 2).setShip(ship);
			field.getCellById(button.getXId(), button.getYId() + 2).setHasShip();			
			//field.getCellById(button.getXId(), button.getYId() + 2).setShip();
			field.getCellById(button.getXId(), button.getYId() + 3).setEnabled(
					false);
			field.getCellById(button.getXId(), button.getYId() + 3)
					.setBackground(Color.GREEN);			
			ship.add(field.getCellById(button.getXId(), button.getYId() + 3));
			field.getCellById(button.getXId(), button.getYId() + 3).setShip(ship);
			field.getCellById(button.getXId(), button.getYId() + 3).setHasShip();			
			//field.getCellById(button.getXId(), button.getYId() + 3).setShip();
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
		Cell next = field.getCellById(button.getXId(), button.getYId() + 1);
		Cell next1 = field.getCellById(button.getXId(), button.getYId() + 2);
		Cell next2 = field.getCellById(button.getXId(), button.getYId() + 3);
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (next2.isEnabled()) && (field.getShipManage().getForthShip() != 0)) {
			button.setBackground(Color.GREEN);
			field.getCellById(button.getXId(), button.getYId() + 1)
					.setBackground(Color.GREEN);
			field.getCellById(button.getXId(), button.getYId() + 2)
					.setBackground(Color.GREEN);
			field.getCellById(button.getXId(), button.getYId() + 3)
					.setBackground(Color.GREEN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		Cell next = field.getCellById(button.getXId(), button.getYId() + 1);
		Cell next1 = field.getCellById(button.getXId(), button.getYId() + 2);
		Cell next2 = field.getCellById(button.getXId(), button.getYId() + 3);
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (next2.isEnabled()) && (field.getShipManage().getForthShip() != 0)) {
			button.setBackground(null);
			field.getCellById(button.getXId(), button.getYId() + 1)
					.setBackground(null);
			field.getCellById(button.getXId(), button.getYId() + 2)
					.setBackground(null);
			field.getCellById(button.getXId(), button.getYId() + 3)
					.setBackground(null);
		}
	}
}
