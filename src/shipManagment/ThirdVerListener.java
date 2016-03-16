package shipManagment;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Cell;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Field;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Ship;

public class ThirdVerListener implements MouseListener {
	private Field field;

	public ThirdVerListener(Field field) {
		this.field = field;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		Cell next = field.getCellById(button.getXId(), button.getYId() + 1);
		Cell next1 = field.getCellById(button.getXId(), button.getYId() + 2);
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (field.getShipManage().getThirdShip() != 0)) {
			button.setEnabled(false);
			button.setBackground(Color.GREEN);
			//button.setShip();
			Ship ship = new Ship(3);
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
			//field.getCellById(button.getXId(), button.getYId() + 2).setShip();
			ship.add(field.getCellById(button.getXId(), button.getYId() + 2));
			field.getCellById(button.getXId(), button.getYId() + 2).setShip(ship);
			field.getCellById(button.getXId(), button.getYId() + 2).setHasShip();
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
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (field.getShipManage().getThirdShip() != 0)) {
			button.setBackground(Color.GREEN);
			field.getCellById(button.getXId(), button.getYId() + 1)
					.setBackground(Color.GREEN);
			field.getCellById(button.getXId(), button.getYId() + 2)
					.setBackground(Color.GREEN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		Cell next = field.getCellById(button.getXId(), button.getYId() + 1);
		Cell next1 = field.getCellById(button.getXId(), button.getYId() + 2);
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (field.getShipManage().getThirdShip() != 0)) {
			button.setBackground(null);
			field.getCellById(button.getXId(), button.getYId() + 1)
					.setBackground(null);
			field.getCellById(button.getXId(), button.getYId() + 2)
					.setBackground(null);
		}
	}
}
