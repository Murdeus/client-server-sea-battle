package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FireListener implements MouseListener {
	public static Cell cell = null;
	private Playground playground;
	
	public FireListener(Playground playground){
		this.playground=playground;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		if (cell != null) {
			cell.setEnabled(true);
			cell.setBackground(null);
			cell = null;
		}
		if (button.isEnabled()) {
			button.setEnabled(false);
			button.setBackground(Color.CYAN);
			cell = button;
			playground.setCoord(button.getXId(), button.getYId());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		if (button.isEnabled()) {
			button.setBackground(Color.CYAN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cell button = (Cell) e.getSource();
		if (button.isEnabled()) {
			button.setBackground(null);
		}
	}

}
