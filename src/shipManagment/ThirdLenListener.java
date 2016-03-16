package shipManagment;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Cell;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Field;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Ship;

public class ThirdLenListener implements MouseListener {
	private Field field;

	public ThirdLenListener(Field field) {
		this.field = field;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		Cell next = field.getCellById(button.getXId() + 1, button.getYId());
		Cell next1 = field.getCellById(button.getXId() + 2, button.getYId());
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (field.getShipManage().getThirdShip() != 0)) {
			button.setEnabled(false);
			button.setBackground(Color.GREEN);
			//button.setShip();
			Ship ship = new Ship(3);
			ship.add(button);
			button.setShip(ship);
			button.setHasShip();
			field.getCellById(button.getXId() + 1, button.getYId()).setEnabled(
					false);
			field.getCellById(button.getXId() + 1, button.getYId())
					.setBackground(Color.GREEN);
			//field.getCellById(button.getXId() + 1, button.getYId()).setShip();
			ship.add(field.getCellById(button.getXId() + 1, button.getYId()));
			field.getCellById(button.getXId() + 1, button.getYId()).setShip(ship);
			field.getCellById(button.getXId() + 1, button.getYId()).setHasShip();
			field.getCellById(button.getXId() + 2, button.getYId()).setEnabled(
					false);
			field.getCellById(button.getXId() + 2, button.getYId())
					.setBackground(Color.GREEN);
			//field.getCellById(button.getXId() + 2, button.getYId()).setShip();
			ship.add(field.getCellById(button.getXId() + 2, button.getYId()));
			field.getCellById(button.getXId() + 2, button.getYId()).setShip(ship);
			field.getCellById(button.getXId() + 2, button.getYId()).setHasShip();
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
		Cell next = field.getCellById(button.getXId() + 1, button.getYId());
		Cell next1 = field.getCellById(button.getXId() + 2, button.getYId());
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (field.getShipManage().getThirdShip() != 0)) {
			button.setBackground(Color.GREEN);
			field.getCellById(button.getXId() + 1, button.getYId())
					.setBackground(Color.GREEN);
			field.getCellById(button.getXId() + 2, button.getYId())
					.setBackground(Color.GREEN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		Cell next = field.getCellById(button.getXId() + 1, button.getYId());
		Cell next1 = field.getCellById(button.getXId() + 2, button.getYId());
		if (button.isEnabled() && (next.isEnabled()) && (next1.isEnabled())
				&& (field.getShipManage().getThirdShip() != 0)) {
			button.setBackground(null);
			field.getCellById(button.getXId() + 1, button.getYId())
					.setBackground(null);
			field.getCellById(button.getXId() + 2, button.getYId())
					.setBackground(null);
		}
	}
}
