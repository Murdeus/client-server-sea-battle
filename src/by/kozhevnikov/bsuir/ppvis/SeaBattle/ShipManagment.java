package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.util.ArrayList;
import java.util.List;

public class ShipManagment {
	private int forthShipCount = 1;
	private int thirdShipCount = 2;
	private int secondShipCount = 3;
	private int firstShipCount = 4;
	private List<Ship> firstShipList;
	private List<Ship> secondShipList;
	private List<Ship> thirdShipList;
	private List<Ship> forthShipList;
	private int shipsAlive;

	public ShipManagment() {
		firstShipList = new ArrayList<Ship>();
		secondShipList = new ArrayList<Ship>();
		thirdShipList = new ArrayList<Ship>();
		forthShipList = new ArrayList<Ship>();
	}

	public void addShip(Ship ship) {
		int shipType = ship.getType();
		switch (shipType) {
		case 1: {
			firstShipList.add(ship);
			firstShipCount--;
		} break;
		case 2: {
			secondShipList.add(ship);
			secondShipCount--;
		} break;
		case 3: {
			thirdShipList.add(ship);
			thirdShipCount--;
		} break;
		case 4: {
			forthShipList.add(ship);
			forthShipCount--;
		} break;
		default: {
			System.exit(1);
		}
		}
	}
	
	public void removeShip(Ship ship){
		int shipType = ship.getType();
		switch (shipType) {
		case 1: {
			firstShipList.remove(ship);
		}
		case 2: {
			secondShipList.remove(ship);
		}
		case 3: {
			thirdShipList.remove(ship);
		}
		case 4: {
			forthShipList.remove(ship);
		}
		}
	}

	public int getShipAliveCount() {
		shipsAlive = firstShipList.size() + secondShipList.size()
				+ thirdShipList.size() + forthShipList.size();
		return shipsAlive;
	}

	public int getForthShip() {
		return forthShipCount;
	}

	public int getThirdShip() {
		return thirdShipCount;
	}

	public int getSecondShip() {
		return secondShipCount;
	}

	public int getFirstShip() {
		return firstShipCount;
	}

	public void backToNormal() {
		this.firstShipCount = 4;
		this.thirdShipCount = 2;
		this.secondShipCount = 3;
		this.forthShipCount = 1;
		this.firstShipList.clear();
		this.secondShipList.clear();
		this.thirdShipList.clear();
		this.forthShipList.clear();
	}
}
