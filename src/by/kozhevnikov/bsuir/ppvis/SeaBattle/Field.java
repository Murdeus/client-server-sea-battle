package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.util.ArrayList;
import java.util.List;

public class Field {
	private List<Cell> list;
	private ShipManagment shipManage;
	private final int size = 11;

	public Field() {
		list = new ArrayList<Cell>();
		shipManage = new ShipManagment();
		for (int mark = 1; mark < size; mark++) {
			for (int counter = 1; counter < size; counter++) {
				Cell cell = new Cell();
				cell.setXId(counter);
				cell.setYId(mark);
				list.add(cell);
			}
		}
	}

	public Cell getCellById(int x, int y) {
		Boolean bool = false;
		int cellId = 0;
		while (!bool) {
			if ((list.get(cellId).getXId() == x) && (list.get(cellId).getYId() == y)) {
				bool = true;
			} else {
				cellId++;
			}
		}
		return list.get(cellId);
	}

	public void clear() {
		for (int mark = 0; mark < this.list.size(); mark++) {
			if (this.list.get(mark).getHasShip()) {
				block(this.list.get(mark).getXId(), this.list.get(mark).getYId());
			}
		}
	}

	public void block(int x, int y) {
		if ((x == 1) && (y == 1)) {
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y + 1).setEnabled(false);
			getCellById(x + 1, y + 1).setEnabled(false);
		} else if ((x == 10) && (y == 1)) {
			getCellById(x - 1, y).setEnabled(false);
			getCellById(x, y + 1).setEnabled(false);
			getCellById(x - 1, y + 1).setEnabled(false);
		} else if ((x == 1) && (y == 10)) {
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x + 1, y - 1).setEnabled(false);

		} else if ((x == 10) && (y == 10)) {
			getCellById(x - 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x - 1, y - 1).setEnabled(false);

		} else if ((x == 10) && (y == 1)) {
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x + 1, y - 1).setEnabled(false);

		} else if (x == 1) {
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x, y + 1).setEnabled(false);
			getCellById(x + 1, y + 1).setEnabled(false);
			getCellById(x + 1, y - 1).setEnabled(false);
		} else if (x == 10) {
			getCellById(x - 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x, y + 1).setEnabled(false);
			getCellById(x - 1, y - 1).setEnabled(false);
			getCellById(x - 1, y + 1).setEnabled(false);
		} else if (y == 1) {
			getCellById(x - 1, y).setEnabled(false);
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y + 1).setEnabled(false);
			getCellById(x + 1, y + 1).setEnabled(false);
			getCellById(x - 1, y + 1).setEnabled(false);
		} else if (y == 10) {
			getCellById(x - 1, y).setEnabled(false);
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x - 1, y - 1).setEnabled(false);
			getCellById(x + 1, y - 1).setEnabled(false);
		} else {
			getCellById(x - 1, y).setEnabled(false);
			getCellById(x + 1, y).setEnabled(false);
			getCellById(x, y - 1).setEnabled(false);
			getCellById(x, y + 1).setEnabled(false);
			getCellById(x - 1, y - 1).setEnabled(false);
			getCellById(x + 1, y + 1).setEnabled(false);
			getCellById(x + 1, y - 1).setEnabled(false);
			getCellById(x - 1, y + 1).setEnabled(false);
		}
	}

	public List<Cell> getList() {
		return this.list;
	}

	public ShipManagment getShipManage() {
		return this.shipManage;
	}
}
